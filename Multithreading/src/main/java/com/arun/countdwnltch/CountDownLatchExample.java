/**
 * 
 */
package com.arun.countdwnltch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Adwiti
 *
 */
public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i=0 ; i<3 ; i++){
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(10000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed.. with new name");
		System.out.println("Completed..this is two name..");
		System.out.println("We have been using a new method to test merge and conflict..");
		System.out.println("We are going to going to test conflicts...");
	}

}

class Processor implements Runnable {

	private CountDownLatch latch;

	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.println("started...");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("CountDown..");
	}
}
