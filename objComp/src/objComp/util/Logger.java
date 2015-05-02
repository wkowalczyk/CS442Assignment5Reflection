package objComp.util;

public final class Logger{
	private static int DEBUG_VALUE = 0;

	private static Logger uniqueInstance;

	public static Logger getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Logger();
		}
		return uniqueInstance;
	}
	
	public static void setDebugValue(int value){
		if(value >= 0 && value < 5){
			DEBUG_VALUE = value;
		} else {
			System.out.println("Debug Value is not valid. Exiting Program.");
			System.exit(0);
		}
	}

	public static void printToStdout(int level, String debugMessage){
		if(level == DEBUG_VALUE){
			System.out.println(debugMessage);
		}
	}
}
