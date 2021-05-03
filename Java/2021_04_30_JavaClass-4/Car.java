
/**
 * This program demonstrate Abstract Class.
 * @version 1.01- 17-08-2018
 * @author Abhey Rana
 */

import java.util.Calendar;
import java.util.Date;

public abstract class Car {

	// Abstract Class can also have instance variables .....

	private String modelName;
	private int passengerCapacity;
	private double topSpeed;
	private Date manufacturingDate;

	// Abstract Class can have constructor just like other classes ....

	public Car(String modelName, int passengerCapacity, double topSpeed) {
		this.modelName = modelName;
		this.passengerCapacity = passengerCapacity;
		this.topSpeed = topSpeed;
		this.manufacturingDate = Calendar.getInstance().getTime();
	}

	// Abstract Methods

	public abstract void accelerate();

	public abstract void brake();

	public abstract String getDescription();

	// Accessor Methods (See Abstract Class can also have concrete methods)

	public String getModelName() {
		return this.modelName;
	}

	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}

	public double getTopSpeed() {
		return this.topSpeed;
	}

	public Date getManufacturingDate() {
		return this.manufacturingDate;
	}

	// Mutator Methods

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setPassengerCapcity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}

}
