package java8;

@FunctionalInterface
public interface Formula {
	public double calculate(int a);

	/**
	 * Ĭ�ϵķǳ��󷽷���default�ؼ��֣�
	 * 
	 * @param a
	 * @return sqrt(a)
	 */
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

	/**
	 * ������public�ؼ���
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
