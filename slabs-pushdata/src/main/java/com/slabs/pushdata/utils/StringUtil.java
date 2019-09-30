/**
 * 
 */
package com.slabs.pushdata.utils;

import java.text.ParseException;

/**
 * Title: project_name Description: XXXX Company:kayak Makedate:2017-8-17
 * 上午11:55:49
 * 
 * @author hupp
 * @version %I%, %G%
 * 
 */
public class StringUtil {

	public static String getNonNULLString(String str) {
		return (str == null || str.equals("null")) ? "" : str;
	}

	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}
		if (str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 描述 : 如果不为空，将yyyyMMdd格式的字符串转化为yyyy-MM-dd <br>
	 * <p>
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static String getNonNULLDateString(String str) throws ParseException {
		return (str == null || str.equals("null")) ? "" : DateUtil.stringToDate(str);
	}
}
