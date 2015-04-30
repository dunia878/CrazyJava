package java8;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;

public class DateFormatDemo {

	public static void main(String[] args) throws IOException {
		Date date = new Date();
		dateInstanceDemo(date);
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(Calendar.DECEMBER);
		calendar.set(1582, Calendar.OCTOBER, 15);
		System.out.println(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calendar.getTime());
		Calendar birthDay = Calendar.getInstance();
		birthDay.set(1976, Calendar.DECEMBER, 24);
		Calendar now = Calendar.getInstance();
		System.out.println(yearsBetween(birthDay, now));
		System.out.println(daysBetween(birthDay, now));
		String[] zones = TimeZone.getAvailableIDs();
		for (String zone : zones) {
			TimeZone timeZone = TimeZone.getTimeZone(zone);
			Calendar calendar2 = Calendar.getInstance(timeZone);
			System.out.printf("%s  %s  %d:%d%n", zone, timeZone.getDisplayName()
					, calendar2.get(Calendar.HOUR)
					, calendar2.get(Calendar.MINUTE));
		}
		System.out.println(Paths.get("c:\\","users","...","geng","junzhao\\").normalize().toString());;
		
		Path file = Paths.get("C:\\windows");
		BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
		System.out.println(attrs.lastModifiedTime());
		System.out.println();
	}
	
	static void dateInstanceDemo(Date date){
		System.out.println("getDateInstance() demo");
		System.out.printf("\tSHORT: %s%n", DateFormat.getDateInstance(DateFormat.SHORT).format(date));
	}
	
	static long yearsBetween(Calendar begin, Calendar end){
		Calendar calendar = (Calendar) begin.clone();
		long years = 0;
		while(calendar.before(end)){
			calendar.add(Calendar.YEAR, 1);
			years++;
		}
		return years;
	}
	static long daysBetween(Calendar begin, Calendar end){
		Calendar calendar = (Calendar) begin.clone();
		long days = 0;
		while(calendar.before(end)){
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			days++;
		}
		return days;
	}
}
