package com.dev.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * AES ���ܹ�����
 * @author Kevin
 *
 */
public class AESUtil {

	private static final String KEY_ALGORITHM = "AES";
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";// Ĭ�ϵļ����㷨

	/**
	 * AES ���ܲ���
	 *
	 * @param content
	 *            ����������
	 * @param password
	 *            ��������
	 * @return ����Base64ת���ļ�������
	 */
	public static String encrypt(String content, String password) {
		try {
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// ����������

			byte[] byteContent = content.getBytes("utf-8");

			cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));// ��ʼ��Ϊ����ģʽ��������

			byte[] result = cipher.doFinal(byteContent);// ����

			return Base64.encodeBase64String(result);// ͨ��Base64ת�뷵��
		} catch (Exception ex) {
			Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	/**
	 * AES ���ܲ���
	 *
	 * @param content
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	public static String decrypt(String content, String password) {
		try {
			// ʵ����
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			// ʹ����Կ��ʼ��������Ϊ����ģʽ
			cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
			// ִ�в���
			byte[] result = cipher.doFinal(Base64.decodeBase64(content));
			return new String(result, "utf-8");
		} catch (Exception ex) {
		}

		return null;
	}

	/**
	 * ���ɼ�����Կ
	 *
	 * @return
	 */
	private static SecretKeySpec getSecretKey(final String password) {
		// ��������ָ���㷨��Կ�������� KeyGenerator ����
		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance(KEY_ALGORITHM);
			// AES Ҫ����Կ����Ϊ 128
			kg.init(128, new SecureRandom(password.getBytes()));
			// ����һ����Կ
			SecretKey secretKey = kg.generateKey();
			return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// ת��ΪAESר����Կ
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public static void main(String[] args) {
		String s = "hello,����";

		System.out.println("s:" + s);

		String s1 = AESUtil.encrypt(s, "1234");
		System.out.println("s1:" + s1);

		System.out.println("s2:" + AESUtil.decrypt(s1, "1234"));
	}
}