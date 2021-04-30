public class SampleThreadRunnable implements Runnable{

	@Override
	public void run(){
		while(true)
			System.out.println("I am secondary thread.");
	}

	public static void main(String args[]){

		Runnable r = new SampleThreadRunnable();
		Thread t = new Thread(r);
		t.start();

		while(true)
			System.out.println("I am main thread.");

	}

}