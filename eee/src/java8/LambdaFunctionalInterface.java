package java8;


public class LambdaFunctionalInterface {

	public interface Convert<F, T>{
		T convert(F from);
	}
	
	public static void main(String[] args) {
		Convert<String, Integer> convert = (from)->Integer.valueOf(from);
		System.out.println(convert.convert("123"));
	}

}
