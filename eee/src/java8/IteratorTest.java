package java8;

public class IteratorTest {

	public IteratorTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int i = 100;
		int j = 200;
		while (++i<--j) {
			System.out.println("i= " + ++i + "   j= " + j);
		}
		System.out.println("midpoint is " + i);
	}

}
