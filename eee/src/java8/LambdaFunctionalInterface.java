package java8;

import org.omg.CORBA.PUBLIC_MEMBER;

public class LambdaFunctionalInterface {

	public interface Convert<F, T>{
		T convert(F from);
	}
	
	public static void main(String[] args) {
		Convert<String, Integer> convert = (from)->Integer.valueOf(from);
		System.out.println(convert.convert("123"));
	}

}
