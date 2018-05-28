package com.dev.utils;

/**
 * ����ϵͳ�ࣺ ��ȡSystem.getProperty("os.name")��Ӧ�Ĳ���ϵͳ
 * 
 * @author Kevin
 */
public class OSInfo {
	private OSInfo() {
	}

	/**
	 * ��ȡ����ϵͳ����
	 * @return
	 */
	public static String getName() {
		return System.getProperty("os.name");
	}

	/**
	 * ��ȡ����ϵͳ�汾
	 * @return
	 */
	public static String getVersion() {
		return System.getProperty("os.version");
	}

	/**
	 * ��ȡ����ϵͳ�ں�
	 * @return
	 */
	public static String getArch() {
		return System.getProperty("os.arch");
	}

	/**
	 * �ж��Ƿ�Linuxϵͳ
	 * @return
	 */
	public static boolean isLinux() {
		return getName().toLowerCase().indexOf("linux") >= 0;
	}

	/**
	 * �ж��Ƿ�MacOS
	 * @return
	 */
	public static boolean isMacOS() {
		String name = getName().toLowerCase();
		return name.indexOf("mac") >= 0 && name.indexOf("os") > 0 && name.indexOf("x") < 0;
	}

	/**
	 * �ж��Ƿ�MacOSX
	 * @return
	 */
	public static boolean isMacOSX() {		
		String name = getName().toLowerCase();
		return name.indexOf("mac") >= 0 && name.indexOf("os") > 0 && name.indexOf("x") > 0;
	}

	/**
	 * �ж��Ƿ�Windows
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
