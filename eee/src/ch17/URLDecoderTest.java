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
		//½«ÆÕÍ¨×Ö·û´®×ª»»³Éapplication/x-www-form-urlencoded×Ö·û´®
		String urlStr = URLEncoder.encode("·è¿ñAndroid½²Òå", "GBK");
		System.out.println(urlStr);
	}

}
