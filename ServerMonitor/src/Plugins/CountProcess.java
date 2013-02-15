package Plugins;

import java.util.ArrayList;

import Util.Util;

public class CountProcess {

	Util util;
	int count;
	
	public CountProcess(Util util) {
		this.util = util;
	}
	
	public void exec(){
		try {
			ArrayList<String> erg = util.networkCommand("ps -e | wc -l");
			count = Integer.parseInt(erg.get(0));
			System.out.println(count);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
