package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOfStringSort {
	private List<String> names = Arrays
			.asList("landon", "kobe", "dirk", "tmac");

	public void oldVersionSort() {
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
	}

	/**
	 * 使用lambda表达式实现1
	 * <p>
	 * 从语法上看，（String o1, String o2)为Comparator接口中compare方法的两个参数，没有方法名；->为方法的实现
	 * 此表达式返回一个Comparator对象
	 * （编译器知道Collection.sort第二个参数是一个Comparator接口实现的对象，而该接口只有一个方法compare
	 * ->个人认为编译器解释该lambda表达式的时候也会转为匿名内部类的方式实现）
	 */
	public void lambdaSort1() {
		Collections.sort(names, (String o1, String o2) -> {
			return -(o2.compareTo(o1));
		});
	}

	public void lambdaSort2() {
		Collections.sort(names, (String o1, String o2)->o2.compareTo(o1));
	}
	
	/**
	 * 使用lambda表达式实现3
	 * <p>
	 * 这是最简单的实现，类型都可以省略不写，因为Java编译器能够自动识别参数的类型（注，用ide编辑代码的时候，敲o2的时候
	 * 自动会出现String的方法——智能提示）
	 */
	public void lambdaSort3() {
		Collections.sort(names, (o1, o2)->o2.compareTo(o1));
		
	}
	public static void main(String[] args) {
		ListOfStringSort name = new ListOfStringSort();
		System.out.println(name.names.toString());
		// name.oldVersionSort();
		name.lambdaSort3();
		System.out.println(name.names.toString());
	}
}
