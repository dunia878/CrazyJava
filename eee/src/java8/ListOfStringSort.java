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
	 * ʹ��lambda���ʽʵ��1
	 * <p>
	 * ���﷨�Ͽ�����String o1, String o2)ΪComparator�ӿ���compare����������������û�з�������->Ϊ������ʵ��
	 * �˱��ʽ����һ��Comparator����
	 * ��������֪��Collection.sort�ڶ���������һ��Comparator�ӿ�ʵ�ֵĶ��󣬶��ýӿ�ֻ��һ������compare
	 * ->������Ϊ���������͸�lambda���ʽ��ʱ��Ҳ��תΪ�����ڲ���ķ�ʽʵ�֣�
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
	 * ʹ��lambda���ʽʵ��3
	 * <p>
	 * ������򵥵�ʵ�֣����Ͷ�����ʡ�Բ�д����ΪJava�������ܹ��Զ�ʶ����������ͣ�ע����ide�༭�����ʱ����o2��ʱ��
	 * �Զ������String�ķ�������������ʾ��
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
