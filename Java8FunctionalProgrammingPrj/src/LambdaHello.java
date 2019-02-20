
public class LambdaHello {

	public static void main(String[] args) {
		// 익명클래스로 선언
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("Hello 익명클래스");
//			}
//		}).start();

		// 람다식
		new Thread(() -> System.out.println("Hello 람다")).start();
	}

}
