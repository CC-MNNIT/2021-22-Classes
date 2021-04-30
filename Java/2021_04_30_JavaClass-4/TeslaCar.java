
/**
 * This program demonstrate Concrete SubClasses of Car Abstract Class.
 * @version 1.01- 17-08-2018
 * @author Abhey Rana
 */

import java.util.Calendar;
import java.util.Date;

class TeslaCar extends Car implements Repairable {

	public TeslaCar(String modelName, int passengerCapacity, double topSpeed) {
		super(modelName, passengerCapacity, topSpeed);
	}

	// Overriding Abstract methods

	public void accelerate() {
		System.out.println("Tesla's specialized acceleration system");
	}

	public void brake() {
		System.out.println("Tesla's specialized braking system");
	}

	public String getDescription() {
		return "Tesla Car, Model Name: " + this.getModelName() + ", Top Speed: " + this.getTopSpeed();
	}

	// Overriding abstract methods of Repairable interface.

	public boolean isRepairable() {
		// Tesla Car has a warranty time and can be repaired during that time only ....
		Date currentDate = Calendar.getInstance().getTime();
		if (currentDate.getTime() - this.getManufacturingDate().getTime() > 100000)
			return false;
		return true;
	}

	public void repair() {
		System.out.println("Procedure for repairing Tesla Car");
	}

}
