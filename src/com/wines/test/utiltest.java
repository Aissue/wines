package com.wines.test;

import com.wines.util.MD5Util;

public class utiltest {

	public static void main(String[] args) {
		System.out.println(MD5Util.encodeToBytes("��С��"));
		System.out.println(MD5Util.encodeToBytes("��С��"));
		System.out.println(MD5Util.encodeToHex("��С��"));
		String a=MD5Util.encodeToBytes("��С��").toString();
		System.out.println(a);

	}

}
