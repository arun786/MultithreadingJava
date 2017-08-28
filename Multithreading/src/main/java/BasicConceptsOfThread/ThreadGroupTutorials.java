/**
 * 
 */
package BasicConceptsOfThread;

/**
 * @author Adwiti
 *
 */
public class ThreadGroupTutorials {

	public static void main(String[] args) {
		System.out.println("Name of the current thread group : " + Thread.currentThread().getThreadGroup().getName()); // main
		System.out.println(
				"Name of the parent thread group : " + Thread.currentThread().getThreadGroup().getParent().getName()); // system

		ThreadGroup pg = new ThreadGroup("Parent group");
		System.out.println(pg.getName()); // Parent group

		ThreadGroup g = new ThreadGroup(pg, "Child Group");
		System.out.println(g.getName());
		System.out.println(g.getParent().getName());

		Thread t1 = new Thread(pg, "t1");
		System.out.println(t1.getPriority()); // 5

		Thread t2 = new Thread(pg, "t2");
		System.out.println(t2.getPriority()); // 5

		pg.setMaxPriority(3);

		Thread t3 = new Thread(pg, "t3");
		
		System.out.println(t1.getPriority()); // 5
		System.out.println(t2.getPriority()); // 5
		System.out.println(t3.getPriority());

	}

}
