package lambdasinaction.dateapi;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.DayOfWeek;

public class TheDayMartOffUsingLambda {

	public static void main(String[] args) {
		// ���� ��Ʈ ���� ���� �����ϱ�?
//		LocalDate today = LocalDate.now();
		LocalDate today = LocalDate.of(2019, 2, 25);
		LocalDate theDayMartOff = today.with(temporal -> {
			//1. ������ �Ǵ� ��¥�� ���ϱ�
			LocalDate theDay = LocalDate.from(temporal);
			System.out.println("���س�¥=" + theDay);
			
			//2. 2��°, 4��° �Ͽ��� ���ϱ�
			LocalDate secondDay = theDay.with(dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
			LocalDate fourthDay = theDay.with(dayOfWeekInMonth(4, DayOfWeek.SUNDAY));
			
			//3. ���س�¥�� ��
			if(theDay.isBefore(secondDay)) return secondDay;
			else if(theDay.isBefore(fourthDay)) return fourthDay;
			else return theDay.plusMonths(1).with(dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
			
		});
		
		System.out.println(theDayMartOff);
	}

}
