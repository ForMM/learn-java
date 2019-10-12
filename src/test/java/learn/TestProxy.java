package learn;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import learn.proxy.ElectricCar;
import learn.proxy.InvocationImpl;
import learn.proxy.Rechargable;
import learn.proxy.Vehicle;

public class TestProxy {

	@Test
	public void test() {
		ElectricCar car = new ElectricCar();
		ClassLoader classLoader = car.getClass().getClassLoader();
		Class<?>[] interfaces = car.getClass().getInterfaces();
		InvocationImpl invocationHandler = new InvocationImpl(car);
		
		Object o = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
		
		Vehicle v = (Vehicle)o;
		v.drive();
		Rechargable r = (Rechargable)o;
		r.recharge();

	}

}
