/**
 * 
 */
package com.arun.innerThread;

import java.util.Arrays;
import java.util.List;

/**
 * @author Adwiti
 *
 */
public class CreateThreadUsingARunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			List<Integer> lst = Arrays.asList(10, 20, 30, 40, 50);

			public void run() {
				for (int i = 0; i < lst.size(); i++) {
					System.out.println("Hello World..." + lst.get(i));
				}
			}
		});

		t1.start();
	}

}
