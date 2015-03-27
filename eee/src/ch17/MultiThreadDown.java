/**
 * 
 */
package ch17;

/**
 * @author gengjunzhao
 *
 */
public class MultiThreadDown {

	/**
	 * 
	 */
	public MultiThreadDown() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		final DownUtil downUtil = new DownUtil("http://insp.ccic.com/a.gif", "b.mp4", 4);
		downUtil.download();
		new Thread() {
			public void run() {
				while (downUtil.getCompleteRate() < 1) {
					System.out.println("ÒÑÍê³É£º" + downUtil.getCompleteRate());

				}
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
				}
			}
		}.start();
	}

}
