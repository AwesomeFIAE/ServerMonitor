package Plugins;

import java.util.ArrayList;

import Util.Util;

import Entity.HDD;

public class MemFree {
	double MemUsed, MemTotal;
	double SwapUsed, SwapTotal;
	Util util;
	
	public MemFree(Util util) {
		this.util = util;
	}
	
	public void exec(){
		try {
			ArrayList<String> erg = util.networkCommand("free");
			MemTotal = Double.parseDouble(erg.get(1).split("\\s+ ")[1]) / 1024;
			MemUsed = Double.parseDouble(erg.get(1).split("\\s+ ")[2]) / 1024;
			
			SwapTotal = Double.parseDouble(erg.get(3).split("\\s+ ")[1]) / 1024;
			SwapUsed = Double.parseDouble(erg.get(3).split("\\s+ ")[2]);
			
			if(SwapUsed != 0)
				SwapUsed /= 1024;
			
			System.out.println(MemTotal + " " + MemUsed);
			System.out.println(SwapTotal + " " + SwapUsed);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public double getMemUsed() {
		return MemUsed;
	}

	public double getMemTotal() {
		return MemTotal;
	}

	public double getSwapUsed() {
		return SwapUsed;
	}

	public double getSwapTotal() {
		return SwapTotal;
	}
	
	
}
