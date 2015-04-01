package net;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
			long startMilli = System.currentTimeMillis();
			int i = 0;
			while ((temp = br.readLine()) != null) { // ���ж�ȡ�����
				// if (!temp.trim().equals("")) {
				// System.out.println(++i + "   "
				// + (System.currentTimeMillis() - startMilli));
				if (temp.contains("href=\"http://dl.vmall.com/")
						|| temp.contains("href=\"http://dl.dbank.com/")) {
					html.append(temp).append("\r\n"); // ����ÿ�к���
					break;
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

	public static void main(String[] args) throws IOException {
		String[] tids = { "17681", "5836" };
		File file = new java.io.File("c:\\tids.txt");
		int i = 0;
		try (FileWriter fw = new FileWriter(file);) {
			for (String tid : tids) {
				System.out.println(++i);
				fw.append(tid + "  ").append(new ReadHtml()
						.getHtml("http://www.itokoo.com/read.php?tid=" + tid));
				fw.flush();
			}
		}
	}

}
