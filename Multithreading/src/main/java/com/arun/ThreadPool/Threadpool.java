/**
 * 
 */
package com.arun.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Adwiti
 *
 */
public class Threadpool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 10; i++) {
			executor.submit(new Runner(i));
		}
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All Tasks completed...");
	}

}

class Runner implements Runnable {

	private Integer id;

	public Runner(Integer id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("Printing " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("End of the Id " + id);
	}
}
