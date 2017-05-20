package com.wines.test;

import com.wines.util.MD5Util;

public class utiltest {

	public static void main(String[] args) {
		System.out.println(MD5Util.encodeToBytes("王小二"));
		System.out.println(MD5Util.encodeToBytes("王小二"));
		System.out.println(MD5Util.encodeToHex("王小二"));
		String a=MD5Util.encodeToBytes("王小二").toString();
		System.out.println(a);

	}

}
