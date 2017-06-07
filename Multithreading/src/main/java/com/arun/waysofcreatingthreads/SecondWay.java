/**
 * 
 */
package com.arun.waysofcreatingthreads;

import java.util.concurrent.TimeUnit;

/**
 * @author Adwiti
 *
 */
public class SecondWay {
	
	public static void main(String[] args) {
		System.out.println("Main thread starts...");
		new SecondTask().start();
		Thread t = new SecondTask();
		t.start();
		System.out.println("Main thread ends..");
	}

}

class SecondTask extends Thread {

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

	public SecondTask() {
		this.id = ++count;
	}
}
