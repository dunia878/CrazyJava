package net;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ReadHtml {

	public ReadHtml() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * ��ȡ��ָ��url�������(ָ��������)
	 * 
	 * @urlString url·�� ��:http://www.baidu.com���ص�String ��Ϊhtml����
	 */
	private String getHtml(String urlString) {
		try {
			StringBuffer html = new StringBuffer();
			java.net.URL url = new java.net.URL(urlString); // ���� String ��ʾ��ʽ����
															// URL ����
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url
					.openConnection();// ����һ�� URLConnection ��������ʾ�� URL
										// �����õ�Զ�̶�������ӡ�
			java.io.InputStreamReader isr = new java.io.InputStreamReader(
					conn.getInputStream());// ���شӴ˴򿪵����Ӷ�ȡ����������
			java.io.BufferedReader br = new java.io.BufferedReader(isr);// ����һ��ʹ��Ĭ�ϴ�С���뻺�����Ļ����ַ���������

			String temp;
			while ((temp = br.readLine()) != null) { // ���ж�ȡ�����
//				 if (!temp.trim().equals("")) {

				if (temp.contains("href=\"http://dl.vmall.com/")) {
					html.append(temp).append("\n"); // ����ÿ�к���
				}
			}
			br.close(); // �ر�
			isr.close(); // �ر�
			return html.toString(); // ���ش����������ݵ��ַ�����ʾ��ʽ��
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		String[] tids = {"5494",
				"5495",
				"5496",
				"5497",
				"5498",
				"5499",
				"5500",
				"5501",
				"5547",
				"5548",};
		for (String tid : tids) {
			
		System.out.println(new ReadHtml()
				.getHtml("http://www.itokoo.com/read.php?tid=" + tid));
		}
	}

}
