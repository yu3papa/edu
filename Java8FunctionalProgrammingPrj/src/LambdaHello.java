
public class LambdaHello {

	public static void main(String[] args) {
		// �͸�Ŭ������ ����
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("Hello �͸�Ŭ����");
//			}
//		}).start();

		// ���ٽ�
		new Thread(() -> System.out.println("Hello ����")).start();
	}

}
