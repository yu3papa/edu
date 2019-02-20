package lambdasinaction._02stream.with.optional;

import java.util.Optional;

public class MobileTesterWithOptional {
	
	public static void main(String[] args) {
		ScreenResolution resolution = new ScreenResolution(750,1334);
		// Null�� ������� ���� Optional.of()
		DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
		Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));
		
		MobileService mService = new MobileService();
		
		int width = mService.getMobileScreenWidth(Optional.of(mobile));
		System.out.println("Apple iPhone 6s Screen Width = " + width);
		
		//ifPresent(), isPresent() �޼ҵ� ���
		Optional<ScreenResolution> scr = dfeatures.getResolution();
		scr.ifPresent(System.out::println);
		System.out.println(scr.isPresent());

		// Null�� ����ϴ� Optional.empty()
		// ofNullable()�� �ش� ��ü�� null���� �ƴ��� Ȯ���� ���� ���¿��� ����ϴ� �޼ҵ�
//		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());
		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.ofNullable(null));
//		int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
		int width2 = mService.getMobileScreenWidth(Optional.ofNullable(mobile2));
		System.out.println("Apple iPhone 16s Screen Width = " + width2);
		
		Optional<DisplayFeatures> df = mobile2.getDisplayFeatures();
		df.ifPresent(System.out::println);
		System.out.println(df.isPresent());
	}
}
