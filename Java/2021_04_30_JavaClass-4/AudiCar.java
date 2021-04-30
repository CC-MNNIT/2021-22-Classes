/**
 * This program demonstrate Concrete SubClasses of Car Abstract Class.
 * 
 * @version 1.01- 17-08-2018
 * @author Abhey Rana
 */

class AudiCar extends Car {

	public AudiCar(String modelName, int passengerCapacity, double topSpeed) {
		super(modelName, passengerCapacity, topSpeed);
	}

	// Overriding Abstract methods

	public void accelerate() {
		System.out.println("Audi's specialized acceleration system");
	}

	public void brake() {
		System.out.println("Audi's specialized braking system");
	}

	public String getDescription() {
		return "Audi Car, Model Name: " + this.getModelName() + ", Top Speed: " + this.getTopSpeed();
	}

}
