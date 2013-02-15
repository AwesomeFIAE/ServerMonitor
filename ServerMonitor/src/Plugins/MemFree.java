package Plugins;

import java.util.ArrayList;

import Util.Util;

import Entity.HDD;

public class MemFree {
	double free, size;
	Util util;
	
	public MemFree(Util util) {
		this.util = util;
	}
	
	public void exec(){
		try {
			ArrayList<String> erg = util.networkCommand("free");
			size = erg.get(1)
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
