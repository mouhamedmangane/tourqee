package com.boutique.server;

public class ServerInfo {
	
	private static final String protocol="http";
	private static final String host="localhost";
	private static final int port=8080;
	
	public static String url(String nom) {
		return  defaultUrl()+nom;
	}
	public static String defaultUrl() {
		return protocol+"://"+host+":"+port+"/";
	}
}
