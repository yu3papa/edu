package lambdasinaction.dateapi;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.DayOfWeek;

public class TemporalAdjusterTest {

	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		
		System.out.println("2번째 금요일=" + d.with(dayOfWeekInMonth(2, DayOfWeek.FRIDAY)));
		
		System.out.println("다을달의 첫날=" + d.with(firstDayOfNextMonth()));
		System.out.println("첫번째 목요일" + d.with(firstInMonth(DayOfWeek.THURSDAY)));
		System.out.println("이번달의 마지막" + d.with(lastDayOfMonth()));
		
		System.out.println("이번달의 마지막 월요일" + d.with(lastInMonth(DayOfWeek.MONDAY)));
		System.out.println("다음 수요일" + d.with(next(DayOfWeek.WEDNESDAY)));
		System.out.println("이전 화요일" + d.with(previous(DayOfWeek.TUESDAY)));
	}

}
