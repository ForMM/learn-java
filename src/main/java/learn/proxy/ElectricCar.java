package learn.proxy;

public class ElectricCar implements Rechargable, Vehicle {

	public void drive() {
		System.out.println("Electric car is moving...");

	}

	public void recharge() {
		System.out.println("Electric car is recharging...");
	}

}
