package Plugins;

import java.util.ArrayList;

import Util.Util;

public class Ipconfig {

	Util util;
	String ip, bcast, mask;
	
	public Ipconfig(Util util) {
		this.util = util;
	}

	public void exec() {
		try {
			ArrayList<String> erg = util.networkCommand("ifconfig eth0");
			
			for (int i = 0; i < erg.size(); i++) {
				if(erg.get(i).contains("inet Adresse:")){
					String[] buffer = erg.get(i).split(":");
					
					ip = buffer[1].substring(0, 14).trim();
					bcast = buffer[2].substring(0, 14).trim();
					mask = buffer[3].trim();
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getIp() {
		return ip;
	}

	public String getBcast() {
		return bcast;
	}

	public String getMask() {
		return mask;
	}
	
	

}
