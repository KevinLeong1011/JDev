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
	 * ���Ƶ����ļ�
	 *
	 * @param sourceFileName
	 *            �����Ƶ��ļ���
	 * @param overlay
	 *            ���Ŀ���ļ����ڣ��Ƿ񸲸�
	 * @return ������Ƴɹ�����true�����򷵻�false
	 * @throws IOException
	 */
	public static boolean copyFile(String sourceFileName, String destFileName, boolean overlay) throws IOException {
		if (!StringUtils.nullOrEmpty(sourceFileName) && sourceFileName.equals(destFileName)) {
			return true;
		}
		File srcFile = new File(sourceFileName);
		// �ж�Ŀ���ļ��Ƿ����
		File destFile = new File(destFileName);
		if (destFile.exists()) {
			// ���Ŀ���ļ����ڲ�������
			if (overlay) {
				// ɾ���Ѿ����ڵ�Ŀ���ļ�������Ŀ���ļ���Ŀ¼���ǵ����ļ�
				new File(destFileName).delete();
			}
		} else {
			// ���Ŀ���ļ�����Ŀ¼�����ڣ��򴴽�Ŀ¼
			if (!destFile.getParentFile().exists()) {
				// Ŀ���ļ�����Ŀ¼������
				if (!destFile.getParentFile().mkdirs()) {
					// �����ļ�ʧ�ܣ�����Ŀ���ļ�����Ŀ¼ʧ��
					return false;
				}
			}
		}

		// �����ļ�
		int byteread = 0; // ��ȡ���ֽ���
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
