package learn.map;

import java.util.HashMap;
import java.util.Map;

public class Maputil {
	public static void main(String[] args) {
		Object a = "";
		String b = new String("bacdsa");
		char[] cc = {'g', 'f', 'b', 'y'};
		String c = new String(cc, 1, 2);

		System.out.println(b.toString());
		System.out.println(c.hashCode());
		System.out.println(b.indexOf("ace"));
		System.out.println(b.replace("a", "w").toString());

		Map<String, String> dd = new HashMap<String, String>();

	}
}
