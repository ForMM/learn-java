package learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationImpl implements InvocationHandler {

	private ElectricCar car;
	public InvocationImpl(ElectricCar car) {
		this.car = car;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("you are going to invoke "+method.getName());
		method.invoke(car, args);
		System.out.println(method.getName()+" invocation has been finished");
		return null;
	}

	public ElectricCar getCar() {
		return car;
	}
	public void setCar(ElectricCar car) {
		this.car = car;
	}

}
