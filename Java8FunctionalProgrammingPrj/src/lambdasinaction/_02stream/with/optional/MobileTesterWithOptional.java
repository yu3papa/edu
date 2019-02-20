package lambdasinaction._02stream.with.optional;

import java.util.Optional;

public class MobileTesterWithOptional {
	
	public static void main(String[] args) {
		ScreenResolution resolution = new ScreenResolution(750,1334);
		// Null을 허용하지 않은 Optional.of()
		DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
		Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));
		
		MobileService mService = new MobileService();
		
		int width = mService.getMobileScreenWidth(Optional.of(mobile));
		System.out.println("Apple iPhone 6s Screen Width = " + width);
		
		//ifPresent(), isPresent() 메소드 사용
		Optional<ScreenResolution> scr = dfeatures.getResolution();
		scr.ifPresent(System.out::println);
		System.out.println(scr.isPresent());

		// Null을 허용하는 Optional.empty()
		// ofNullable()은 해당 객체가 null인지 아닌지 확신이 없는 상태에서 사용하는 메소드
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
