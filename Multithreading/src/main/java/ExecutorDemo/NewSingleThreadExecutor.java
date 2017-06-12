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
public class NewSingleThreadExecutor {

	public static void main(String[] args) {
		/* Requests will be in queue when a thread gets executed */
		ExecutorService executors = Executors.newSingleThreadExecutor();
		for (int id = 1; id < 10; id++) {
			executors.submit(new TaskB(id));
		}

		executors.shutdown();
	}

}

class TaskB implements Runnable {

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
	public TaskB(int id) {
		super();
		this.id = id;
	}

}
