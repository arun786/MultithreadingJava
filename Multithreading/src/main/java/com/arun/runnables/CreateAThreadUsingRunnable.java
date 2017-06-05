/**
 * 
 */
package com.arun.runnables;

import java.util.Arrays;
import java.util.List;

/**
 * @author Adwiti
 *
 */
public class CreateAThreadUsingRunnable {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runner());
		t1.start();
		
		Thread t2 = new Thread(new Runner());
		t2.start();

	}

}

/**
 * 
 * @author Adwiti
 *
 *         A class implementing Runnable interface to create thread
 */
class Runner implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		for (int i = 0; i < lst.size(); i++) {

			System.out.println("hello world ..."+ lst.get(i));

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
