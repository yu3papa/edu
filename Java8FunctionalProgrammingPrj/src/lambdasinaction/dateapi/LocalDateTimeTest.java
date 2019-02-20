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
		// LocalDate ���
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDate todayAgain = LocalDate.now();
		System.out.println(todayAgain);
		
		System.out.println(today.compareTo(todayAgain) == 0);
		
		System.out.println("��=" + today.getYear());
		System.out.println("��=" + today.getMonth());
		System.out.println("��=" + today.getMonthValue());
		System.out.println("��=" + today.getDayOfMonth());
		System.out.println("~��=" + today.getDayOfYear());
		
		System.out.println("����=" + today.getDayOfWeek());
		System.out.println("����=" + today.getDayOfWeek().getValue());
		
		// Ư�� ��¥�� �����ؼ� LocalDate ����
		LocalDate endDay = LocalDate.of(2019, 12, 31);
		System.out.println("������� ���� ���� �ִ°�=" + today.until(endDay, ChronoUnit.DAYS));
		
		System.out.println("���� ���� 1���� ��=" + today.plusMonths(1));
		System.out.println(DayOfWeek.TUESDAY.plus(3));
		
		// LocalTime
		LocalTime now = LocalTime.now();
		System.out.println(now);
		System.out.println("�ú��� ������=" + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond() + ":" + now.getNano());
		
		// Ư���ð��� �����ؼ� LocalTime ����
		LocalTime bedTime = LocalTime.of(23, 40);
		LocalTime wadeTime = bedTime.plusHours(8);
		System.out.println("���ð�=" + wadeTime);
		
		// LocalDateTime ���
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		LocalDate date = dt.toLocalDate();
		LocalTime time = dt.toLocalTime();
		System.out.println(date);
		System.out.println(time);
		
		// Ư����¥�� �ð��� �����ؼ� LocalDateTime ����
		LocalDateTime dt2 = LocalDateTime.of(2019, 2, 19, 13, 20, 50);
		System.out.println("dt2=" + dt2);
		System.out.println("  dt2=" + dt2.getMonth());
		System.out.println("" + dt2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		// ������ ���� ������ Formatter ����
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a", Locale.KOREA);
		System.out.println(dt2.format(myFormat));

	}
}
