package com.company.project.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * md5加密工具
 */
public class MD5Utils {
	private static final String SALT = "md5_salt";
	private static final String ALGORITHM_NAME = "md5";
	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String passwd) {
		return new SimpleHash(ALGORITHM_NAME, passwd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
	}

	public static String encrypt(String username, String passwd) {
		return new SimpleHash(ALGORITHM_NAME, passwd, ByteSource.Util.bytes(username + SALT),
				HASH_ITERATIONS).toHex();
	}
	public static void main(String[] args) {
		System.out.println(MD5Utils.encrypt("test", "123456"));
	}

}
