package Plugins;

import Util.Util;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Util util = new Util();
		
		util.addHDD("/dev/sda1");
		DiskFree test = new DiskFree(util);
		test.exec();
		
		
		
		
	}

}
