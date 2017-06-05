/**
 * 
 */
package com.arun.Synchrnizes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Adwiti
 *
 */
public class Synchronizingmethods {

	public static void main(String[] args) {
		Worker w = new Worker();
		w.main();
	}

}

class Worker {

	Object lock1 = new Object();
	Object lock2 = new Object();

	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	public void stageOne() throws InterruptedException {
		Thread.sleep(1);
		synchronized (lock1) {
			list1.add(random.nextInt(100));
		}
	}

	public void stageTwo() throws InterruptedException {
		Thread.sleep(1);
		synchronized (lock2) {
			list2.add(random.nextInt(100));
		}
	}

	public void process() throws InterruptedException {

		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void main() {

		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println(
				"Time taken " + (end - start) + " size of list1 and list 2 are " + list1.size() + " : " + list2.size());
	}

}
