/**
 * This program demonstrate AbstractTest driver class
 * 
 * @version 1.01- 17-08-2018
 * @author Abhey Rana
 */

public class AbstractTest {

	public static void main(String args[]) {

		Car[] showroom = new Car[3];

		showroom[0] = new TeslaCar("Model S", 4, 250.0);
		showroom[1] = new AudiCar("Audi A3", 4, 240.0);
		showroom[2] = new TeslaCar("Model X", 4, 210.0);

		for (Car c : showroom)
			System.out.println(c.getDescription());

	}

}
