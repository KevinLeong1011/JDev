package com.dev.utils;

/**
 * 操作系统类： 获取System.getProperty("os.name")对应的操作系统
 * 
 * @author Kevin
 */
public class OSInfo {
	private OSInfo() {
	}

	/**
	 * 获取操作系统名称
	 * @return
	 */
	public static String getName() {
		return System.getProperty("os.name");
	}

	/**
	 * 获取操作系统版本
	 * @return
	 */
	public static String getVersion() {
		return System.getProperty("os.version");
	}

	/**
	 * 获取操作系统内核
	 * @return
	 */
	public static String getArch() {
		return System.getProperty("os.arch");
	}

	/**
	 * 判断是否Linux系统
	 * @return
	 */
	public static boolean isLinux() {
		return getName().toLowerCase().indexOf("linux") >= 0;
	}

	/**
	 * 判断是否MacOS
	 * @return
	 */
	public static boolean isMacOS() {
		String name = getName().toLowerCase();
		return name.indexOf("mac") >= 0 && name.indexOf("os") > 0 && name.indexOf("x") < 0;
	}

	/**
	 * 判断是否MacOSX
	 * @return
	 */
	public static boolean isMacOSX() {		
		String name = getName().toLowerCase();
		return name.indexOf("mac") >= 0 && name.indexOf("os") > 0 && name.indexOf("x") > 0;
	}

	/**
	 * 判断是否Windows
	 * @return
	 */
	public static boolean isWindows() {
		return getName().toLowerCase().indexOf("windows") >= 0;
	}

	public static boolean isOS2() {
		return getName().toLowerCase().indexOf("os/2") >= 0;
	}

	public static boolean isSolaris() {
		return getName().toLowerCase().indexOf("solaris") >= 0;
	}

	public static boolean isSunOS() {
		return getName().toLowerCase().indexOf("sunos") >= 0;
	}

	public static boolean isMPEiX() {
		return getName().toLowerCase().indexOf("mpe/ix") >= 0;
	}

	public static boolean isHPUX() {
		return getName().toLowerCase().indexOf("hp-ux") >= 0;
	}

	public static boolean isAix() {
		return getName().toLowerCase().indexOf("aix") >= 0;
	}

	public static boolean isOS390() {
		return getName().toLowerCase().indexOf("os/390") >= 0;
	}

	public static boolean isFreeBSD() {
		return getName().toLowerCase().indexOf("freebsd") >= 0;
	}

	public static boolean isIrix() {
		return getName().toLowerCase().indexOf("irix") >= 0;
	}

	public static boolean isDigitalUnix() {
		String name = getName().toLowerCase();
		return name.indexOf("digital") >= 0 && name.indexOf("unix") > 0;
	}

	public static boolean isNetWare() {
		return getName().toLowerCase().indexOf("netware") >= 0;
	}

	public static boolean isOSF1() {
		return getName().toLowerCase().indexOf("osf1") >= 0;
	}

	public static boolean isOpenVMS() {
		return getName().toLowerCase().indexOf("openvms") >= 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(OSInfo.getName());
		System.out.println(OSInfo.getVersion());
		System.out.println(OSInfo.getArch());
	}
}
