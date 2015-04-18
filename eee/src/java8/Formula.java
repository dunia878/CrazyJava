package java8;

@FunctionalInterface
public interface Formula {
	public double calculate(int a);

	/**
	 * 默认的非抽象方法（default关键字）
	 * 
	 * @param a
	 * @return sqrt(a)
	 */
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

	/**
	 * 增加了public关键字
	 * 
	 * @param a
	 * @return sin(a)
	 */
	public default double sin(int a) {
		return Math.sin(a);
	}

	public static void main(String[] args) {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}

		};
		
		System.out.println(formula.calculate(144));
	}
}
