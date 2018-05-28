package com.dev.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.dev.utils.StringUtils;

public class FileHelper {

	public static boolean copyFile(String sourceFile, String destFile) throws IOException {
		return copyFile(sourceFile, destFile, true);
	}

	/**
	 * 复制单个文件
	 *
	 * @param sourceFileName
	 *            待复制的文件名
	 * @param overlay
	 *            如果目标文件存在，是否覆盖
	 * @return 如果复制成功返回true，否则返回false
	 * @throws IOException
	 */
	public static boolean copyFile(String sourceFileName, String destFileName, boolean overlay) throws IOException {
		if (!StringUtils.nullOrEmpty(sourceFileName) && sourceFileName.equals(destFileName)) {
			return true;
		}
		File srcFile = new File(sourceFileName);
		// 判断目标文件是否存在
		File destFile = new File(destFileName);
		if (destFile.exists()) {
			// 如果目标文件存在并允许覆盖
			if (overlay) {
				// 删除已经存在的目标文件，无论目标文件是目录还是单个文件
				new File(destFileName).delete();
			}
		} else {
			// 如果目标文件所在目录不存在，则创建目录
			if (!destFile.getParentFile().exists()) {
				// 目标文件所在目录不存在
				if (!destFile.getParentFile().mkdirs()) {
					// 复制文件失败：创建目标文件所在目录失败
					return false;
				}
			}
		}

		// 复制文件
		int byteread = 0; // 读取的字节数
		try (InputStream in = new FileInputStream(srcFile); OutputStream out = new FileOutputStream(destFile);) {
			byte[] buffer = new byte[1024];

			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			return true;
		} catch (IOException e) {
			throw e;
		}
	}

	public static void main(String[] args) {
		String newPath = "D:\\zc\\defaultroot\\sbbb\\temp\\SGHT\\201411030005064964\\1.docx";
		String oldPath = "D:\\zc\\defaultroot\\sbbb\\annex\\ZC_SGHT\\201411030005064964\\1.docx";
		try {
			copyFile(oldPath, newPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
