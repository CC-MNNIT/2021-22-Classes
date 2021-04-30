public class SampleThreadRunnable implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("I am secondary thread.");
			try {
				Thread.sleep(500);
			} catch (Exception ex) {
				System.err.println("exception");
			}
		}
	}

	public static void main(String args[]) throws Exception {

		Runnable r = new SampleThreadRunnable();
		Thread t = new Thread(r);
		t.start();// separate stack memory is allocated, then run gets called

		while (true) {
			System.out.println("I am main thread.");
			Thread.sleep(700);
		}

	}

}
