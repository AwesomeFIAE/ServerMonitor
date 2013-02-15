package Plugins;

import java.util.ArrayList;
import java.util.Hashtable;

import Entity.HDD;
import Util.Util;

public class DiskFree {
	
	Util util;
	
	public DiskFree(Util util) {
		this.util = util;
	}
	
	public void exec() {
		try {
			ArrayList<HDD> hdds = util.getHarddisks();
			for (int i = 0; i < hdds.size(); i++) {
				ArrayList<String> erg = util.networkCommand("df -h " + hdds.get(i).getDescription());
				String [] foo = erg.get(1).split("\\s+ ");
				hdds.get(i).setSize(foo[1]);
				hdds.get(i).setFree(foo[2]);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
