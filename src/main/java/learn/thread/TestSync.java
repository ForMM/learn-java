package learn.thread;

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
