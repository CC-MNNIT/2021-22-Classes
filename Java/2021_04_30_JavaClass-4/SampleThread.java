public class SampleThread extends Thread{

	@Override
	public void run(){
		while(true)
			System.out.println("I am secondary thread.");
	}

	public static void main(String args[]){

		Thread t = new SampleThread();
		t.start();

		while(true)
			System.out.println("I am main thread.");

	}

}