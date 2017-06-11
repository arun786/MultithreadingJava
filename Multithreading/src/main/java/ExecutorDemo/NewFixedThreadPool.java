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
public class NewFixedThreadPool {
	public static void main(String[] args) {

		/*
		 * New Fixed Thread pool will execute maximum in the parameter
		 * specified, rest will wait in the queue
		 */
		ExecutorService executes = Executors.newFixedThreadPool(3);
		for (int id = 1; id <= 5; id++) {
			executes.submit(new Task(id));
		}
		executes.shutdown();
	}
}

class Task implements Runnable {

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
	public Task(int id) {
		super();
		this.id = id;
	}

}
