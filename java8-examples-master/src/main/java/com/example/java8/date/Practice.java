package com.example.java8.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
		
		ZoneId.getAvailableZoneIds().stream()
		  .filter(z -> z.contains("US") || z.contains("America"))
		  .sorted().forEach(System.out::println);
		
		System.out.println(ZoneId.systemDefault());
		
		
		Locale locale = Locale.getDefault();
		System.out.println(locale);
		
		Duration duration = Duration.ofDays(1);
		System.out.println(duration);
		System.out.println(Duration.ofDays(0));	
		
		Period p = Period.ofMonths(0);
		System.out.println(p);
		
		System.out.println(Period.ofMonths(1));		
		System.out.println(Period.ofYears(0));	
		
		
		LocalDate date = LocalDate.of(2017, 5, 13);
		LocalTime time = LocalTime.of(10, 0);
		LocalDateTime trainDay = LocalDateTime.of(date, time);
		ZonedDateTime zt = ZonedDateTime.now();
		Instant instant = zt.toInstant();
		instant = instant.plus(1, ChronoUnit.DAYS);
		System.out.println(instant);
		
		Duration duration2 = Duration.ofDays(1);
		Period period = Period.ofDays(1);
		
		System.out.println(duration2.toString());
		System.out.println(period.toString());
		
		Duration d = Duration.between(LocalDate.now(), LocalDate.now().minusDays(2));
		System.out.println(d);

	}

}
