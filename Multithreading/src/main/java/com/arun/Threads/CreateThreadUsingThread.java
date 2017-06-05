/**
 * 
 */
package com.arun.Threads;

/**
 * @author Adwiti
 *
 */
public class CreateThreadUsingThread {
	
	public static void main(String[] args) {
		Thread t1 = new Runner();
		t1.start();
		
		Thread t2 = new Runner();
		t2.start();
	}

}

/**
 * 
 * @author Adwiti
 * 
 *         creates a thread extending the class Thread and override run method.
 */
class Runner extends Thread {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {

			System.out.println("value " + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
