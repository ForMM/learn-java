package learn;

import learn.thread.Car;
import learn.thread.WaxOff;
import learn.thread.WaxOn;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSync {

	private String key;

	public TestSync() {
	}

	public synchronized String set(String key, String id) {
		System.out.println("key=" + key + "   id=" + id);
		return key;
	}


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
