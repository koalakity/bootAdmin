package com.snowstore.bootAdmin.service.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
	private final static Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

	private static String[] weekNickname = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };

	public static Date addDate(Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_YEAR, count);

		return calendar.getTime();
	}

	public static Date addMinute(Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, count);
		return calendar.getTime();
	}

	/**
	 * 将日期的时分秒都改为最大值。
	 */
	public static Date toMaxDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static Date toMinDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 
	 * @description: 月份增减计算
	 * @author: wujinsong
	 * @param date
	 * @param count
	 * @return
	 */
	public static Date addMonth(Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.MONTH, count);
		return calendar.getTime();
	}

	/**
	 * 
	 * @description: 月份增减计算，默认为当天
	 * @author: wujinsong
	 * @param count
	 * @return
	 */
	public static Date addMonth(int count) {
		Date date = new Date();

		return addMonth(date, count);
	}

	/**
	 * @description: 增减周计算
	 * @author: wujinsong
	 * @param date
	 * @param count
	 * @return
	 */
	public static Date addWeek(Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 7 * count);

		return calendar.getTime();
	}

	/**
	 * 
	 * @description: 增减周计算
	 * @author: wujinsong
	 * @param count
	 * @return
	 */
	public static Date addWeek(int count) {
		Date date = new Date();

		return addWeek(date, count);
	}

	/**
	 * 
	 * @return 系统当前季度
	 */
	public static Integer currentQuarter() {
		Calendar calendar = Calendar.getInstance();
		return (int) Math.ceil((calendar.get(Calendar.MONTH) + 1) / Double.valueOf(3));
	}

	public static Date getCurrenDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getNextDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到本季度第一天的日期
	 * 
	 * @Methods Name getFirstDayOfQuarter
	 * @return Date
	 */
	public static Date getFirstDayOfQuarter() {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(new Date());
		int curMonth = cDay.get(Calendar.MONTH);
		if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH) {
			cDay.set(Calendar.MONTH, Calendar.JANUARY);
		}
		if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE) {
			cDay.set(Calendar.MONTH, Calendar.APRIL);
		}
		if (curMonth >= Calendar.JULY && curMonth <= Calendar.AUGUST) {
			cDay.set(Calendar.MONTH, Calendar.JULY);
		}
		if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {
			cDay.set(Calendar.MONTH, Calendar.OCTOBER);
		}
		cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMinimum(Calendar.DAY_OF_MONTH));
		cDay.set(Calendar.MINUTE, 0);
		cDay.set(Calendar.SECOND, 0);
		cDay.set(Calendar.HOUR_OF_DAY, 0);
		cDay.set(Calendar.MILLISECOND, 0);
		return cDay.getTime();
	}

	/**
	 * 获取当前时间 只有年月日
	 * 
	 * @return
	 */
	public static Calendar getCurrenCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	/**
	 * 获取本周星期一
	 * 
	 * @return
	 */
	public static Date getCurrentMonday() {
		Calendar calendar = getCurrenCalendar();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return calendar.getTime();
	}

	/**
	 * 获取本周星期天
	 * 
	 * @return
	 */
	public static Date getCurrentSunday() {
		Calendar calendar = getCurrenCalendar();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return calendar.getTime();
	}

	/**
	 * 获取下周星期一
	 * 
	 * @return
	 */
	public static Date getNextMonday() {
		Calendar calendar = getCurrenCalendar();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		return calendar.getTime();
	}

	/**
	 * 获取下周星期一
	 * 
	 * @return
	 */
	public static Date getNextMonday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		return calendar.getTime();
	}

	/**
	 * 
	 * @description: 获取本周周一
	 * @author: wujinsong
	 * @return
	 */
	public static String getMondayOfThisWeek() {
		Calendar c = Calendar.getInstance();
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0) {
			dayofweek = 7;
		}
		c.add(Calendar.DATE, -dayofweek + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(c.getTime());
	}

	/**
	 * 
	 * @description: 获取日期是周几
	 * @author: SM
	 * @return
	 */
	public static String getWeekDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return convert(dayofweek);
	}

	static String convert(int val) {
		String retStr = "";
		switch (val) {
		case 0:
			return "星期日";
		case 1:
			return "星期一";
		case 2:
			return "星期二";
		case 3:
			return "星期三";
		case 4:
			return "星期四";
		case 5:
			return "星期五";
		case 6:
			return "星期六";
		default:
			break;
		}
		return retStr;
	}

	/**
	 * 
	 * @description: 获取本周周末
	 * @author: wujinsong
	 * @return
	 */
	public static String getSundayOfThisWeek() {
		Calendar c = Calendar.getInstance();
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0) {
			dayofweek = 7;
		}
		c.add(Calendar.DATE, -dayofweek + 7);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(c.getTime());
	}

	/**
	 * 
	 * @description: 将字符串转换为某一格式的日期
	 * @author: wujinsong
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date stringToDate(String dateStr, String formatStr) {
		DateFormat dd = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			LOGGER.error("DAteUtil 异常", e);
		}

		return date;
	}

	/**
	 * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
	 * 
	 * @param time
	 *            Date 日期<br>
	 * @param formatStr
	 *            String 格式<br>
	 * @return String 字符串<br>
	 */

	public static String dateToString(Date time, String formatStr) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat(formatStr);
		String ctime = formatter.format(time);
		return ctime;
	}

	/**
	 * 获得当年某月的第一天
	 * 
	 * @param month
	 *            month 月份 01 02 11 12
	 * @return
	 */
	public static Date getfirstDayOfMonth(int count) {
		Calendar calendar = Calendar.getInstance();
		int thisYear = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.set(Calendar.YEAR, thisYear);
		calendar.add(Calendar.MONTH, count - 1);
		return calendar.getTime();
	}

	/**
	 * 获得某年某月的第一天
	 * 
	 * @param month
	 *            month 月份 01 02 11 12
	 * @return
	 */
	public static Date getfirstDayOfMonth(int count, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.add(Calendar.MONTH, count - 1);
		return calendar.getTime();
	}

	/**
	 * 获得当年某月的最后一天
	 * 
	 * @param month
	 *            month 月份 01 02 11 12
	 * @return
	 */
	public static Date getLastDayOfMonth(int count) {
		Calendar calendar = Calendar.getInstance();
		int thisYear = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.set(Calendar.YEAR, thisYear);
		calendar.add(Calendar.MONTH, count);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return calendar.getTime();
	}

	/**
	 * 获得某年某月的最后一天
	 * 
	 * @param month
	 *            month 月份 01 02 11 12
	 * @return
	 */
	public static Date getLastDayOfMonth(int count, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.add(Calendar.MONTH, count);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return calendar.getTime();
	}

	/**
	 * 
	 * @description: 获取n小时前的时间
	 * @author: wujinsong
	 * @param n
	 * @return
	 */
	public static Date getNHourTime(int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - n);

		return calendar.getTime();
	}

	/**
	 * 
	 * @description: 获取当天结束时间(24小时制)
	 * @author: wujinsong
	 * @return
	 */
	public static Date getEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime();
	}

	/**
	 * 
	 * @description: 获取当天开始时间(24小时制)
	 * @author: wujinsong
	 * @return
	 */
	public static Date getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}

	/**
	 * 两个时间相隔天数（不计算时分秒）
	 * 
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int daysOfTwo(Date fDate, Date oDate) {
		return (int) ((getDate(fDate).getTime() - getDate(oDate).getTime()) / 86400000);
	}

	/**
	 * 去掉时分秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 
	 * @description: 转换日期为yyyy-MM-dd格式
	 * @author: wujinsong
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date format(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String sDate = format.format(date);

		return format.parse(sDate);
	}

	/**
	 * 获取当年的最后一天 by gab
	 */
	public static Date getCurrYearLast() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}

	public static Date getYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		return currYearLast;
	}

	/**
	 * 
	 * @description: 判断时间间隔，分钟
	 * @author: wujinsong
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean judgeMinuteDiffByTime(Date time1, Date time2, int min) {
		long diffValue = time1.getTime() - time2.getTime();
		return Math.abs(diffValue) > min * 1000 * 60;
	}

	/**
	 * 
	 * @description: 判断时间间隔
	 * @author: wujinsong
	 * @param time1
	 * @param min
	 * @return
	 */
	public static boolean judgeMinuteDiffByTime(Date time1, int min) {
		return judgeMinuteDiffByTime(time1, new Date(), min);
	}

	/**
	 * isToday
	 * 
	 * @param date
	 *            判断时间是不是当天 @return
	 * 
	 *            boolean
	 * 
	 * @exception
	 */
	public static boolean isToday(Date date) {
		return DateUtils.getEndTime().getTime() >= date.getTime() && DateUtils.getStartTime().getTime() <= date.getTime();
	}

	/**
	 * 获取当前时间是否在指定时间之前。
	 * 
	 * @return
	 */
	public static boolean beforeForHour(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtils.getDate(date));
		cal.set(Calendar.HOUR_OF_DAY, hour);
		if (new Date().getTime() < cal.getTimeInMillis()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @description: 获取当天开始时间(24小时制)
	 * @author: gab
	 * @return
	 */
	public static Date getInitTime(Date date) {
		Calendar start = Calendar.getInstance();
		start.setTime(date);
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		return start.getTime();
	}

	/**
	 * 获取日期间隔 by gab
	 */
	public static int getDaysBetweenDate(Date date1, Date date2) {
		long time1 = getInitTime(date1).getTime();
		long time2 = getInitTime(date2).getTime();
		long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(betweenDays));
	}

	/**
	 * 将日期的时分秒都改为最大值。
	 */
	public static Date getDateLast(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static Date dateFormat(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return sdf.parse(dateStr);
	}

	public static Date getNow() {
		return new Date();
	}

	public static String getWeekNickname(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return weekNickname[calendar.get(Calendar.DAY_OF_WEEK) - 1];
	}
}
