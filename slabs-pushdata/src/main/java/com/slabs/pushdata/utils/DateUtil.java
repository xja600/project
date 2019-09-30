package com.slabs.pushdata.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	
	  public static String getNowTime(String format)
	  {
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date());
	    return sdf.format(c.getTime());
	  }
	
	//转换成：20160914
	public static String DateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currentDay = sdf.format(date);
		return currentDay;
		
	}
	
	//日期后加上N个月：当前是20160914 加上24 ，日期为：20180914
	public static String dateAddMonths(String date,int days) throws ParseException    
	   {    
	   		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
	       Calendar cal = Calendar.getInstance();    
	       cal.setTime(sdf.parse(date));
	       cal.add(Calendar.MONTH,days);
	       return sdf.format(cal.getTime());           
	   } 
	
	/**  
	    * 计算两个日期之间相差的月数不足保留到小数点二位。  
	    * @param smdate 较小的时间 
	    * @param bdate  较大的时间 
	    * @return 相差天数 
	    * @throws ParseException  
	    */  
	   public static BigDecimal monthsBetween(String date1, String date2) throws ParseException {
			int result1 = 0;
			int result2 = 0;
			int result3 = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(sdf.parse(date1));
			c2.setTime(sdf.parse(date2));
			result1 = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			result2 = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
			result3 = c2.get(Calendar.DAY_OF_MONTH) - c1.get(Calendar.DAY_OF_MONTH);
			int days_of_month=c2.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			return new BigDecimal(result1 * 12 + result2)
				.add(new BigDecimal(result3).divide(new BigDecimal(days_of_month), 2, BigDecimal.ROUND_HALF_UP));
		}	
	   
	   /**
	    * 判断两个日期大小
	    * @param date1
	    * @param date2
	    * @return
	 * @throws ParseException 
	    */
	   public static boolean judgeDate(String date1, String date2) throws ParseException{
		   boolean flag = false;
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		   if(date1 == null || date1 ==""){
			   date1 = "00000000";
		   }
		   if(date2 == null || date1 ==""){
			   date2 = "00000000";
		   }
		   if(sdf.parse(date2).getTime()>=sdf.parse(date1).getTime()){
			   flag = true;
		   }
		   if(date1.length()>8 || date2.length()>8){
			   flag = false;
		   }
		   return flag;
	   }
	   
	   public static boolean judgeDate2(String date1, String date2) throws ParseException{
		   boolean flag = false;
		   if(date1 == null || date1 ==""){
			   date1 = "00000000";
		   }
		   if(date2 == null || date1 ==""){
			   date2 = "00000000";
		   }
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		   
		   if(sdf.parse(date2).getTime()>sdf.parse(date1).getTime()){
			   flag = true;
		   }
		   return flag;
	   }
	   /**
	    * 加一天
	    * @param date
	    * @param day
	    * @return
	    * @throws ParseException
	    */
	   public static String addOneDay(String date, int day) throws ParseException{
		   String newDate = null;
		   Calendar calendar = new GregorianCalendar(); 
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		   calendar.setTime(sdf.parse(date)); 
	       calendar.add(calendar.DATE,day);
	       newDate = sdf.format(calendar.getTime());
		   return newDate;
	   }
	   
	   /**  
	    * 计算两个日期之间相差的天数
	    * @throws ParseException  
	    */    
		public static int daysBetween(String bdate,String edate) throws ParseException    
	   {    
	   	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
	       Calendar cal = Calendar.getInstance();    
	       cal.setTime(sdf.parse(bdate));    
	       long time1 = cal.getTimeInMillis();                 
	       cal.setTime(sdf.parse(edate));    
	       long time2 = cal.getTimeInMillis();         
	       long between_days=(time2-time1)/(1000*3600*24);  
	           
	      return Integer.parseInt(String.valueOf(between_days));           
	   } 
		/**
		 * 算两个日期之间相差的周
		 * @param bdate 较大的时间 
		 * @param edate 较小的时间 
		 * @return
		 * @throws ParseException
		 */
		public static Long weeksBetween(String bdate,String edate) throws ParseException{
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			 Date date1=df.parse(bdate);
		     Date date2=df.parse(edate);
		     Long weeks=(date1.getTime()-date2.getTime())/(7*24*60*60*1000);
		     
		     return weeks;
		}
		
		/**
		 * 获取系统时间
		 * @return yyyy-MM-dd HH:mm:ss
		 */
		public static String getSysTime() {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			return df.format(new Date());
		}		
	   
		/**
		 * 字符串转换为日期
		 * @param str   yyyyMMdd
		 * @return yyyy-MM-dd
		 * @throws ParseException
		 */
		public static String stringToDate(String str) throws ParseException{
			if(StringUtil.isEmpty(str) || str == "null")
				return "";
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			return sdf2.format(sdf1.parse(str));
		}
		
		/**
		 * 字符串yyyy-MM-dd转换为yyyyMMdd
		 * @param str   yyyy-MM-d
		 * @return yyyyMMdd
		 * @throws ParseException
		 */
		public static String stringChange(String str) throws ParseException{
			if(StringUtil.isEmpty(str) || str == "null")
				return "";
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			return sdf1.format(sdf2.parse(str));
		}
		
		/**
		 * 字符串yyyy/MM/dd转换为yyyyMMdd
		 * @param str   yyyy/MM/d
		 * @return yyyyMMdd
		 * @throws ParseException
		 */
		public static String stringChange2(String str) throws ParseException{
			if(StringUtil.isEmpty(str) || str == "null")
				return "";
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			
			return sdf1.format(sdf2.parse(str));
		}
		
		 /**
		 * 计算两个日期之间相差的月份,不足一个月按一个月计算
		 * @param date1
		 * @param date2
		 * @return
		 * @throws ParseException
		 */
	   public static int getMonthSpace(String date1, String date2) throws ParseException {
			int result1 = 0;
			int result2 = 0;
			int result3 = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(sdf.parse(date1));
			c2.setTime(sdf.parse(date2));
			result1 = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			result2 = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
			result3 = c2.get(Calendar.DAY_OF_MONTH) - c1.get(Calendar.DAY_OF_MONTH);
			if (result3 > 0) {
				return result1 * 12 + result2 + 1;
			} else {
				return result1 * 12 + result2;
			}
		}
	   /**  
	    * 计算一个日期增加month个月后的日期  
	    * @param date 时间 yyyyMMdd
	    * @param month 月数
	    * @return 增加一个月后的日期 
	    * @throws ParseException  
	    */    
	   public static String dateAddMoney(String date,int month) throws ParseException    
	   {    
	   	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");  
	       Calendar cal = Calendar.getInstance();    
	       cal.setTime(sdf.parse(date));
	       //判断date是否是一个月的最后一天，如果是最后一天，则加N个月后还是最后一天。
	       Boolean isLastDay=false;
	       if(cal.get(Calendar.DAY_OF_MONTH)==
	    		   cal.getActualMaximum(Calendar.DAY_OF_MONTH)){
	    	   isLastDay=true;
	       }
	       cal.add(Calendar.MONTH,month);
	       if(isLastDay){
	    	   cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	       }
	       return sdf.format(cal.getTime());           
	   } 
	   
	   /**
	    * 下个月的第一天
	    * @return
	    */
	   public static String nextMonthFirstDate(){
		   Calendar calendar = Calendar.getInstance();
	       calendar.set(Calendar.DAY_OF_MONTH, 1);
	       calendar.add(Calendar.MONTH, 1);
	       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	       
	       return sdf.format(calendar.getTime());
	   }
	   
	   /**
	    * 获取某月下个月的第一天
	    * @param date
	    * @return
	    * @throws ParseException
	    */
	   public static String someMonthFirstDate(String date) throws ParseException{
		   String someDate = dateAddMoney(date,1);
		   
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		   
		   Calendar calendar = Calendar.getInstance();
		   calendar.setTime(sdf.parse(someDate));
		   calendar.set(Calendar.DAY_OF_MONTH, 1);
		   
		   return sdf.format(calendar.getTime());
	   }
	   public static void main(String[] args) throws ParseException {
//		System.out.println(DateUtil.getMonthSpace("20170606", "20170606"));
		  System.out.println(DateUtil.someMonthFirstDate("20170331"));
	}


	/**
	 * 日期格式化
	 */
	public static String dateFormat(String time) throws ParseException {
		if (StringUtil.isEmpty(time))
			return "";

		SimpleDateFormat sdf = new SimpleDateFormat();
		String[] dateFormat = {"yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd", "yy-MM-dd"};
		String[] timeFormat = {"yyyyMMdd hhmmss", "yyyy-MM-dd hhmmss", "yyyy/MM/dd hhmmss", "yyyyMMdd hh:mm:ss", "yyyy-MM-dd hh:mm:ss", "yyyy/MM/dd hh:mm:ss"};

		int is_date = time.indexOf(" ");//判断值是否带时间
		if (is_date <= -1) {//日期
			if (time.indexOf("/") > -1) {
				sdf.applyPattern(dateFormat[2]);
			} else if (time.indexOf("-") > -1 && time.length() > 8) {
				sdf.applyPattern(dateFormat[1]);
			} else if (time.indexOf("-") > -1 && time.length() <= 8) {
				sdf.applyPattern(dateFormat[3]);
			} else {
				sdf.applyPattern(dateFormat[0]);
			}
			Date date = sdf.parse(time);
			sdf.applyPattern(dateFormat[0]);// 本系统默认存储格式 yyyyMMdd

			return sdf.format(date);
		} else {
			if ((time.indexOf("/") > -1) && (time.indexOf(":") <= -1)) {
				sdf.applyPattern(timeFormat[2]);
			} else if ((time.indexOf("-") > -1) && (time.indexOf(":") <= -1)) {
				sdf.applyPattern(timeFormat[1]);
			} else if ((time.indexOf("/") > -1) && (time.indexOf(":") > -1)) {
				sdf.applyPattern(timeFormat[5]);
			} else if ((time.indexOf("-") > -1) && (time.indexOf(":") > -1)) {
				sdf.applyPattern(timeFormat[4]);
			} else if (time.indexOf(":") > -1) {
				sdf.applyPattern(timeFormat[3]);
			} else {
				sdf.applyPattern(timeFormat[0]);
			}
			Date date = sdf.parse(time);
			//sdf.applyPattern(timeFormat[3]);
			sdf.applyPattern(dateFormat[0]);//本系统默认存储格式 yyyyMMdd
			return sdf.format(date);
		}
	}

	public static String getNowDate(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(new Date());
	}
	
	public static String getLastDate(String format)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date d = cal.getTime();
		SimpleDateFormat sp = new SimpleDateFormat(format);
		return sp.format(d);// 获取昨天日期
	}
}
