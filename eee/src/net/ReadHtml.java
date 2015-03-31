package net;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ReadHtml {

	public ReadHtml() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 获取所指向url的输出流(指所有内容)
	 * 
	 * @urlString url路径 如:http://www.baidu.com返回的String 则为html代码
	 */
	private String getHtml(String urlString) {
		try {
			StringBuffer html = new StringBuffer();
			java.net.URL url = new java.net.URL(urlString); // 根据 String 表示形式创建
															// URL 对象。
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url
					.openConnection();// 返回一个 URLConnection 对象，它表示到 URL
										// 所引用的远程对象的连接。
			java.io.InputStreamReader isr = new java.io.InputStreamReader(
					conn.getInputStream());// 返回从此打开的连接读取的输入流。
			java.io.BufferedReader br = new java.io.BufferedReader(isr);// 创建一个使用默认大小输入缓冲区的缓冲字符输入流。

			String temp;
			while ((temp = br.readLine()) != null) { // 按行读取输出流
//				 if (!temp.trim().equals("")) {

				if (temp.contains("href=\"http://dl.vmall.com/")) {
					html.append(temp).append("\n"); // 读完每行后换行
				}
			}
			br.close(); // 关闭
			isr.close(); // 关闭
			return html.toString(); // 返回此序列中数据的字符串表示形式。
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
