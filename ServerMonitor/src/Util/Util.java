package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Entity.HDD;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;


public class Util {
	
	Connection conn;
	Session sess;
	
	ArrayList<HDD> harddisks = new ArrayList<HDD>();
	
	/*
	 * Befehle per SSH2 absetzen
	 */
	public ArrayList<String> networkCommand(String cmd){
		
		ArrayList<String> erg = new ArrayList<String>();
		String hostname = "192.168.2.184";
		String username = "user";
		String password = "user";

		try
		{
			if(conn == null){
				/* Create a connection instance */
				conn = new Connection(hostname);
			}
				
			
			if(!conn.isAuthenticationComplete()){
				
				/* Now connect */
				conn.connect();

				/* Authenticate.
				 * If you get an IOException saying something like
				 * "Authentication method password not supported by the server at this stage."
				 * then please check the FAQ.
				 */
				boolean isAuthenticated = conn.authenticateWithPassword(username, password);

				if (isAuthenticated == false)
					throw new IOException("Authentication failed.");
				
				sess = conn.openSession();
			}
			
			if(sess.getExitStatus() != null){
				/* Create a session */
				sess = conn.openSession();
			}

			
			sess.execCommand(cmd);

			/* 
			 * This basic example does not handle stderr, which is sometimes dangerous
			 * (please read the FAQ).
			 */

			InputStream stdout = new StreamGobbler(sess.getStdout());

			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
			
			// Arraylist erstellen und füllen
			
			String line;
			while ((line = br.readLine()) != null) {
				erg.add(line);
			}

		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(2);
		}
		
		return erg;
	}

	/*
	 * Befehle lokal absetzen
	 */
	public static ArrayList<String> localCommand(String cmd) throws IOException {
		ArrayList<String> erg = new ArrayList<String>();
		Process p = Runtime.getRuntime().exec(cmd);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String line;
		while ((line = br.readLine()) != null) {
			erg.add(line);
		}
		return erg;
	}
	
	/*
	 * Festplatten verwalten
	 */
	public void addHDD(String description){
		harddisks.add(new HDD(description));
	}

	public ArrayList<HDD> getHarddisks() {
		return harddisks;
	}
	
	
}
