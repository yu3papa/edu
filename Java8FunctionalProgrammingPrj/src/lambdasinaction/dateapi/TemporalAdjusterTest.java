package lambdasinaction.dateapi;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.DayOfWeek;

public class TemporalAdjusterTest {

	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		
		System.out.println("2��° �ݿ���=" + d.with(dayOfWeekInMonth(2, DayOfWeek.FRIDAY)));
		
		System.out.println("�������� ù��=" + d.with(firstDayOfNextMonth()));
		System.out.println("ù��° �����" + d.with(firstInMonth(DayOfWeek.THURSDAY)));
		System.out.println("�̹����� ������" + d.with(lastDayOfMonth()));
		
		System.out.println("�̹����� ������ ������" + d.with(lastInMonth(DayOfWeek.MONDAY)));
		System.out.println("���� ������" + d.with(next(DayOfWeek.WEDNESDAY)));
		System.out.println("���� ȭ����" + d.with(previous(DayOfWeek.TUESDAY)));
	}

}
