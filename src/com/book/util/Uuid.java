package com.book.util;

import java.util.UUID;

/**
 * @ClassName: Uuid
 * @Description: 生成uuid
 * @author c-kx@outlook.com
 * @date 2015�?12�?20�? 下午8:13:38
 */

/*
 * replace() 方法用于在字符串中用�?些字符替换另�?些字符，或替换一个与正则表达式匹配的子串�?
 * toUpperCase()描述说明:该方法返回指定的char值的大写形式
 */
public class Uuid {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
