package com.dev.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import com.dev.utils.OSInfo;
import com.dev.utils.StringUtils;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;

public class ProcessHelper {
	static String LOCAL_HOST = "127.0.0.1";

	private ProcessHelper() {
	}

	/**
	 * 开启一个进程
	 * 
	 * @param cmd
	 * @return
	 * @throws Exception
	 */
	public static Process exec(String cmd) throws Exception {
		if (OSInfo.isWindows()) {
			return Runtime.getRuntime().exec(cmd);
		} else if (OSInfo.isLinux()) {
			String[] cmdA = { "/bin/sh", "-c", cmd };
			return Runtime.getRuntime().exec(cmdA);
		} else {
			throw new Exception("Unknown system.");
		}
	}

	/**
	 * 杀死进程
	 * 
	 * @param pid
	 * @return
	 */
	public static boolean kill(String pid) {
		if (StringUtils.nullOrEmpty(pid))
			throw new IllegalArgumentException("pid cannot be null or empty.");
		else {
			String killCmd = "taskkill /pid %s -t -f";
			String command = String.format(killCmd, pid);
			try {
				Runtime.getRuntime().exec(command);
				return true;
			} catch (IOException e) {
				return false;
			}
		}
	}

	/**
	 * 判断指定进程是否运行
	 * 
	 * @param processName
	 * @return
	 */
	public static boolean exist(String processName) {
		BufferedReader bufferedReader = null;
		try {
			Process proc = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq " + processName + "\"");
			bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains(processName)) {
					return true;
				}
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Exception ex) {
				}
			}
		}
	}

	/**
	 * 
	 * @param port
	 * @return
	 */
	public static String getPidByPort(int port) {
		String grepStatCommand = "netstat -nao | findstr \"%d\"";
		String psNumber = "";
		try {
			String command = String.format(grepStatCommand, port);
			System.out.println(command);
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while (true) {
				line = bufferedReader.readLine();
				if (line == null)
					break;
				System.out.println(line);
				if (line.contains("LISTENING")) {
					String[] lineSplit = line.replace(" ", "").split("LISTENING");
					if (lineSplit.length >= 2) {
						psNumber = lineSplit[1];
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("exception");
		}
		return psNumber;
	}

	/***
	 * true:already in using false:not using
	 * 
	 * @param port
	 */
	public static boolean isLoclePortUsing(int port) {
		boolean flag = true;
		try {
			flag = isPortUsing(LOCAL_HOST, port);
		} catch (Exception e) {
		}
		return flag;
	}

	/***
	 * true:already in using false:not using
	 * 
	 * @param host
	 * @param port
	 * @throws IOException
	 */
	public static boolean isPortUsing(String host, int port) throws IOException {
		boolean flag = false;
		InetAddress theAddress = InetAddress.getByName(host);
		try (Socket socket = new Socket(theAddress, port)) {
			flag = true;
		} catch (IOException e) {

		}
		return flag;
	}

	public static int getProcessPid(Process process)
			throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
		int pid = 0;
		if (OSInfo.isWindows()) {
			pid = getProcessPidWindows(process);
		} else if (OSInfo.isLinux()) {
			pid = getProcessPidLiunx(process);
		}
		return pid;
	}

	private static int getProcessPidWindows(Process process) throws NoSuchFieldException, IllegalAccessException {
		int pid = 0;
		Field f = process.getClass().getDeclaredField("handle");
		f.setAccessible(true);
		long handl = f.getLong(process);
		Kernel32 kernel = Kernel32.INSTANCE;
		WinNT.HANDLE handle = new WinNT.HANDLE();
		handle.setPointer(Pointer.createConstant(handl));
		pid = kernel.GetProcessId(handle);
		return pid;
	}

	private static int getProcessPidLiunx(Process process)
			throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		int pid = 0;
		Field field = null;
		Class<?> clazz = Class.forName("java.lang.UNIXProcess");
		field = clazz.getDeclaredField("pid");
		field.setAccessible(true);
		pid = (Integer) field.get(process);
		return pid;
	}

	public static void main(String[] args) {
		System.out.println(getPidByPort(443));
	}

}
