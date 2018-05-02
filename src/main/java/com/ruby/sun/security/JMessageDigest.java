package com.ruby.sun.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JMessageDigest {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String password = "yia6Ohv8ahlu";
		byte[] challenge = "16byChal".getBytes();
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] passwordMd5 = messageDigest.digest(password.getBytes(Charset.forName("US-ASCII")));
        messageDigest.reset();
        messageDigest.update(passwordMd5);
        messageDigest.update(challenge);
        byte[] passwordChallengeMd5 = messageDigest.digest();
        System.out.println(new String(passwordChallengeMd5, Charset.forName("US-ASCII")));
	}
}
