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

/*o/p will be
#########Task#######  1
##### Task : 1 count : 0 #####
##### Task : 1 count : 1 #####
##### Task : 1 count : 2 #####
##### Task : 1 count : 3 #####
##### Task : 1 count : 4 #####
#########Task#######  2
##### Task : 2 count : 0 #####
##### Task : 2 count : 1 #####
##### Task : 2 count : 2 #####
##### Task : 2 count : 3 #####
##### Task : 2 count : 4 #####
#########Task#######  3
##### Task : 3 count : 0 #####
##### Task : 3 count : 1 #####
##### Task : 3 count : 2 #####
##### Task : 3 count : 3 #####
##### Task : 3 count : 4 #####
#########Task#######  4
##### Task : 4 count : 0 #####
##### Task : 4 count : 1 #####
##### Task : 4 count : 2 #####
##### Task : 4 count : 3 #####
##### Task : 4 count : 4 #####
#########Task#######  5
##### Task : 5 count : 0 #####
##### Task : 5 count : 1 #####
##### Task : 5 count : 2 #####
##### Task : 5 count : 3 #####
##### Task : 5 count : 4 #####
#########Task#######  6
##### Task : 6 count : 0 #####
##### Task : 6 count : 1 #####
##### Task : 6 count : 2 #####
##### Task : 6 count : 3 #####
##### Task : 6 count : 4 #####
#########Task#######  7
##### Task : 7 count : 0 #####
##### Task : 7 count : 1 #####
##### Task : 7 count : 2 #####
##### Task : 7 count : 3 #####
##### Task : 7 count : 4 #####
#########Task#######  8
##### Task : 8 count : 0 #####
##### Task : 8 count : 1 #####
##### Task : 8 count : 2 #####
##### Task : 8 count : 3 #####
##### Task : 8 count : 4 #####
#########Task#######  9
##### Task : 9 count : 0 #####
##### Task : 9 count : 1 #####
##### Task : 9 count : 2 #####
##### Task : 9 count : 3 #####
##### Task : 9 count : 4 #####
*/
