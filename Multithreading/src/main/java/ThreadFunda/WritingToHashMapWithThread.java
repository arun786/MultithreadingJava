/**
 * 
 */
package ThreadFunda;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adwiti
 *
 */
public class WritingToHashMapWithThread {
	public static void main(String[] args) {

		Thread t1 = new Thread(new HashMapFunda());
		Thread t2 = new Thread(new HashMapFunda());
		Thread t3 = new Thread(new HashMapFunda());

		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class HashMapFunda implements Runnable {

	Map<String, String> map = new HashMap<>();
	private static int count = 0;
	private int id;

	public void run() {
		id = ++count;
		System.out.println("id " + id);

		for (int i = 0; i < 1000000; i++) {
			map.put("1 " + id + " " + i, "one");
		}
		System.out.println(id + ":" + map.size());
	}

}
