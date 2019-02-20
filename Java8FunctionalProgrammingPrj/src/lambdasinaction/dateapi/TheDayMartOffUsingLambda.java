package lambdasinaction.dateapi;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.DayOfWeek;

public class TheDayMartOffUsingLambda {

	public static void main(String[] args) {
		// 다음 마트 쉬는 날이 언제일까?
//		LocalDate today = LocalDate.now();
		LocalDate today = LocalDate.of(2019, 2, 25);
		LocalDate theDayMartOff = today.with(temporal -> {
			//1. 기준이 되는 날짜를 구하기
			LocalDate theDay = LocalDate.from(temporal);
			System.out.println("기준날짜=" + theDay);
			
			//2. 2번째, 4번째 일요일 구하기
			LocalDate secondDay = theDay.with(dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
			LocalDate fourthDay = theDay.with(dayOfWeekInMonth(4, DayOfWeek.SUNDAY));
			
			//3. 기준날짜와 비교
			if(theDay.isBefore(secondDay)) return secondDay;
			else if(theDay.isBefore(fourthDay)) return fourthDay;
			else return theDay.plusMonths(1).with(dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
			
		});
		
		System.out.println(theDayMartOff);
	}

}
