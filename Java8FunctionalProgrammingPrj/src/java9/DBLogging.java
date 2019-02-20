package java9;

public interface DBLogging {
	default void logInfo(String msg) {
		log(msg);
	}
	
	private void log(String msg) {
		System.out.println(msg);
	}

}
