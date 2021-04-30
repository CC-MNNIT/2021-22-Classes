public class SonyMusicPlayer implements Repairable {

	// Some code for Music Player .....

	public boolean isRepairable() {
		// Let's assume that our music player comes with lifetime warranty :P
		return true;
	}

	public void repair() {
		System.out.println("Procedure for repairing Sony Music Player");
	}

}
