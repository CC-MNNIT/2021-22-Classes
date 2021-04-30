class Thread1 extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("I am Thread1.");
			try {
				Thread.sleep(500);
			} catch (Exception ex) {
				System.err.println("exception");
			}
		}
	}

}

class Thread2 extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("I am Thread2.");
			try {
				Thread.sleep(500);
			} catch (Exception ex) {
				System.err.println("exception");
			}
		}
	}

}

class SampleThread {
	public static void main(String args[]) throws Exception {

		Thread t1 = new Thread1();
		t1.start();// separate stack memory is allocated, then run gets called
		Thread t2 = new Thread2();
		t2.start();// separate stack memory is allocated, then run gets called

		while (true) {
			System.out.println("I am main thread.");
			Thread.sleep(1000);
		}
	}
}
