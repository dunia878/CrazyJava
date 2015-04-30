package ch18;

class Test {
	static {
		System.out.println("static init...");
	}
	
	static byte age = 22;
	static final String name = age + "";
}

public class fff {
	static {
		b = 6;
	}

	static int b = 9;
	static {
		System.out.println("b=" + b);
		b = 99;
	}

	public fff() {
	}

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		cl.loadClass("ch18.Test");
		System.out.println("bbb");
		Class.forName("ch18.Test");
		
		byte[] one = new byte[1];
		one[0] = 0x54;
		int range = one[0];
		System.out.printf("%h", range&0x00ff);
		System.out.println((char)range);
		System.out.println(Integer.toBinaryString(123));
		System.out.println("\' \"");

	}

}
