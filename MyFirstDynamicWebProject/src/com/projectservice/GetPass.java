package com.projectservice;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetPass {

	public static byte[] obtainSHA(String s) throws NoSuchAlgorithmException {
		MessageDigest msgDgst = MessageDigest.getInstance("SHA-256");

		return msgDgst.digest(s.getBytes(StandardCharsets.UTF_8));
	}

	public static String toHexStr(byte[] hash) {

		BigInteger no = new BigInteger(1, hash);

		StringBuilder hexStr = new StringBuilder(no.toString(16));

		while (hexStr.length() < 32) {
			hexStr.insert(0, '0');
		}

		return hexStr.toString();
	}

	public static String getpass(String temppass) {
		String hash = null;
		try {
			hash = toHexStr(obtainSHA(temppass));
		}
		catch (NoSuchAlgorithmException obj) {
			System.out.println("An exception is generated for the incorrect algorithm: " + obj);
		}
		return hash;
	}
}
