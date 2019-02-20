package lambdasinaction.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		// LocalDate 사용
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDate todayAgain = LocalDate.now();
		System.out.println(todayAgain);
		
		System.out.println(today.compareTo(todayAgain) == 0);
		
		System.out.println("년=" + today.getYear());
		System.out.println("월=" + today.getMonth());
		System.out.println("월=" + today.getMonthValue());
		System.out.println("일=" + today.getDayOfMonth());
		System.out.println("~일=" + today.getDayOfYear());
		
		System.out.println("요일=" + today.getDayOfWeek());
		System.out.println("요일=" + today.getDayOfWeek().getValue());
		
		// 특정 날짜를 지정해서 LocalDate 생성
		LocalDate endDay = LocalDate.of(2019, 12, 31);
		System.out.println("현재기준 몇일 남아 있는가=" + today.until(endDay, ChronoUnit.DAYS));
		
		System.out.println("현재 기준 1개월 후=" + today.plusMonths(1));
		System.out.println(DayOfWeek.TUESDAY.plus(3));
		
		// LocalTime
		LocalTime now = LocalTime.now();
		System.out.println(now);
		System.out.println("시분초 나노초=" + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond() + ":" + now.getNano());
		
		// 특정시간을 지정해서 LocalTime 생성
		LocalTime bedTime = LocalTime.of(23, 40);
		LocalTime wadeTime = bedTime.plusHours(8);
		System.out.println("기상시간=" + wadeTime);
		
		// LocalDateTime 사용
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		LocalDate date = dt.toLocalDate();
		LocalTime time = dt.toLocalTime();
		System.out.println(date);
		System.out.println(time);
		
		// 특정날짜와 시간을 지정해서 LocalDateTime 생성
		LocalDateTime dt2 = LocalDateTime.of(2019, 2, 19, 13, 20, 50);
		System.out.println("dt2=" + dt2);
		System.out.println("  dt2=" + dt2.getMonth());
		System.out.println("" + dt2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		// 포맷을 직접 설정한 Formatter 생성
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a", Locale.KOREA);
		System.out.println(dt2.format(myFormat));

	}
}
