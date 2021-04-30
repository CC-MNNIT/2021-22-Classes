public class RepairingGuy {

	// Static doRepair method of RepairingGuy ....

	public static void doRepair(Repairable object) {

		if (!object.isRepairable())
			System.out.println("Sorry I can't repair this item. Please contact someone else");
		else {
			object.repair();
			System.out.println("Your item has been successfully repaired.");
		}
	}

}
