public class InterfaceTest {

	public static void main(String args[]) {

		Repairable[] item_to_repair = new Repairable[3];

		item_to_repair[0] = new TeslaCar("Model S", 4, 250.0);
		item_to_repair[1] = new SonyMusicPlayer();
		item_to_repair[2] = new TeslaCar("Model X", 4, 210.0);

		for (Repairable item : item_to_repair)
			RepairingGuy.doRepair(item);

	}

}
