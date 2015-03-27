/**
 * 
 */
package ch17;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author gengjunzhao
 *
 */
public class DownUtil {
	private String path;
	private String targetFile;
	private int threadNum;
	private DownThread[] threads;
	private int fileSize;
	
	public DownUtil(String path, String targetFile, int threadNum){
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
	}
	
	public void download() throws Exception{
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept",
				"image/gif, image/jpeg, image/pjpeg");
		conn.setRequestProperty("Accept-Language", "zh-cn");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "Keep-Alive");
		
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum +1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		
		file.setLength(fileSize);
		file.close();
		for (int i = 0; i < threadNum; i++) {
			int startPos = i * currentPartSize;
			RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
			currentPart.seek(startPos);
			threads[i]= new DownThread(startPos, currentPartSize, currentPart);
			threads[i].start();
		}
	}
	
	public double getCompleteRate(){
		int sumSize = 0;
		for (int i = 0; i < threadNum; i++) {
			sumSize += threads[i].length;
					
		}
		return sumSize * 1.0 / fileSize;
	}
	/**
	 * 
	 */
	public DownUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private class DownThread extends Thread
	{
		private int startPos;
		private int currentPartSize;
		private RandomAccessFile currentPart;
		public int length;
		public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart)
		{
			this.startPos = startPos;
			this.currentPartSize = currentPartSize;
			this.currentPart = currentPart;
		}
		public void run()
		{
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setConnectTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept",
						"image/gif, image/jpeg, image/pjpeg");
				conn.setRequestProperty("Accept-Language", "zh-cn");
				conn.setRequestProperty("Charset", "UTF-8");
				InputStream inputStream = conn.getInputStream();
				inputStream.skip(this.startPos);
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				while (length < currentPartSize
						&& (hasRead = inputStream.read(buffer)) != -1){
					currentPart.write(buffer, 0, hasRead);
					length += hasRead;
				}
				currentPart.close();
				inputStream.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
