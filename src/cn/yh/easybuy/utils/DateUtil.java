package cn.yh.easybuy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 日期类型转换为字符串类型
	 * @param date
	 * @return
	 */
	public static String  date2String(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
	}
	/**
	 * 日期转换为字符串 需两个参数
	 * @param date
	 * @param fmt
	 * @return
	 */
	public static String date2String(Date date,String fmt){
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		String str = sdf.format(date);
		return str;
	}
	/**
	 * 字符串转换为日期类型
	 * @param str
	 * @return
	 */
	public static Date string2Date(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
