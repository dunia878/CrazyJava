/**
 * 
 */
package ch17;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author gengjunzhao
 *
 */
public class URLDecoderTest {

	/**
	 * 
	 */
	public URLDecoderTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String keyWord = URLDecoder.decode("%B7%E8%BF%F1java", "GBK");
		System.out.println(keyWord);
		//����ͨ�ַ���ת����application/x-www-form-urlencoded�ַ���
		String urlStr = URLEncoder.encode("���Android����", "GBK");
		System.out.println(urlStr);
	}

}
