/**
 * 
 */
package com.arun.waysofcreatingthreads;

import java.util.concurrent.TimeUnit;

/**
 * @author Adwiti
 *
 */
public class ThirdWay {
	
	public static void main(String[] args) {
		System.out.println("Main thread starts...");
		Thread t1 = new Thread(new ThirdTask());
		t1.start();
		
		Thread t2 = new Thread(new ThirdTask());
		t2.start();
		
		
		System.out.println("Main thread ends..");
	}

}

class ThirdTask implements Runnable {

	private static int count = 0;
	private int id;

	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(id + " : " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public ThirdTask() {
		this.id = ++count;
	}
}
