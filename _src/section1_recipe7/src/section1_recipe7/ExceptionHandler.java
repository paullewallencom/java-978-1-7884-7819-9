package section1_recipe7;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {
	
	/**
	 * Main method of the class. It process the uncaught excpetions throwed in a
	 * Thread
	 * 
	 * @param t
	 *            The Thead than throws the Exception
	 * @param e
	 *            The Exception throwed
	 */
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
	}

}
