package net;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadHtml_all {

	public ReadHtml_all() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * ��ȡ��ָ��url�������(ָ��������)
	 * 
	 * @urlString url·�� ��:http://www.baidu.com���ص�String ��Ϊhtml����
	 */
	@SuppressWarnings("unused")
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

	/** */
	/**
	 * ͨ����վ����URL��ȡ����վ��Դ��
	 * 
	 * @param url
	 * @return String
	 * @throws Exception
	 */
	public static String getURLSource(URL url) throws Exception {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
//		conn.setConnectTimeout(5 * 1000);
		InputStream inStream = conn.getInputStream(); // ͨ����������ȡhtml����������
		byte[] data = readInputStream(inStream); // �Ѷ���������ת��Ϊbyte�ֽ�����
		String htmlSource = new String(data);
		return htmlSource;
	}

    /** *//** 
     * �Ѷ�������ת��Ϊbyte�ֽ����� 
     * @param instream 
     * @return byte[] 
     * @throws Exception 
     */  
    public static byte[] readInputStream(InputStream instream) throws Exception {  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[]  buffer = new byte[1204];  
        int len = 0;  
        while ((len = instream.read(buffer)) != -1){  
            outStream.write(buffer,0,len);  
        }  
        instream.close();  
        return outStream.toByteArray();           
    }  
	public static void main(String[] args) throws Exception {
		String[] tids = { "4695"};
//		String[] tids = { "4695", "4729", "4731", "4732", "4733", "4735",
//				"4736", "4866", "4867", "4868", "4870", "4871", "4872", "4873",
//				"4874", "4875", "4876", "4877", "4878", "4879", "4880", "4881",
//				"4883", "4913", "4914", "4915", "4919", "4920", "4925", "4928",
//				"4930", "4932", "4933", "4939", "4940", "4943", "4945", "4947",
//				"4949", "4950", "4951", "4952", "4971", "4972", "4973", "4974",
//				"4975", "4976", "4977", "4978", "4979", "4980", "4983", "4984",
//				"4985", "4986", "4987", "4988", "4990", "4991", "4993", "4994",
//				"4995", "4996", "4997", "4998", "4999", "5000", "5001", "5002",
//				"5003", "5004", "5005", "5006", "5007", "5008", "5009", "5010",
//				"5011", "5156", "5235", "5261", "5262", "5271", "5316", "5322",
//				"5345", "5346", "5348", "5349", "5350", "5353", "5358", "5359",
//				"5362", "5364", "5365", "5369", "5377", "5379", "5380", "5384",
//				"5387", "5418", "5422", "5426", "5427", "5428", "5431", "5452",
//				"5453", "5454", "5456", "5457", "5458", "5460", "5461", "5472",
//				"5474", "5475", "5476", "5477", "5479", "5481", "5482", "5485",
//				"5486", "5487", "5488", "5489", "5490", "5491", "5492", "5493",
//				"5641", "8507", "21682", "23133" };
		File file = new java.io.File("c:\\tids.txt");
		int i = 0;
		try (FileWriter fw = new FileWriter(file);) {
			for (String tid : tids) {
				System.out.println(++i);
				new ReadHtml_all();
				fw.append(ReadHtml_all
						.getURLSource(new URL("http://www.itokoo.com/read.php?tid=" + tid)));
				fw.flush();
			}
		}
	}

}
