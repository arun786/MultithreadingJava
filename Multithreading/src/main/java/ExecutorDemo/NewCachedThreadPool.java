/**
 * 
 */
package ExecutorDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Adwiti
 *
 */
public class NewCachedThreadPool {
	public static void main(String[] args) {
		/* It will start all the threads submitted */
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int id = 1; id < 6; id++) {
			executor.submit(new TaskA(id));
		}

		executor.shutdown();
	}
}

class TaskA implements Runnable {

	private int id;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		System.out.println("#########Task#######  " + id);

		for (int i = 0; i < 5; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				System.out.println("##### Task : " + id + " count : " + i + " #####");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param id
	 */
	public TaskA(int id) {
		super();
		this.id = id;
	}

}
