/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Muzammil Abdul Rehman <muzammil.abdul.rehman@gmail.com>
 **/

public class NodeInfo implements Serializable{
	private static final long serialVersionUID = 435466571L;
	
	private int port;
	private InetAddress ip;


	public NodeInfo(InetAddress ip, int port) {
		this.port = port;
		this.ip = ip;
	}

	public NodeInfo(String ip, int port) throws UnknownHostException {
		this.ip = (InetAddress)InetAddress.getByName(ip);
		this.port = port;
	}
	
	public NodeInfo() {
		this.ip =null;
		this.port = 0;
	}
	
	public boolean isNull(){
		return this.ip==null;
	}
	
	public void setNull(){
		this.ip=null;this.port=0;
	}
		
	public String getNodeInfo(){
		return this.ip.getHostAddress()+","+ String.valueOf(port);
	}
	
	public String getNodeLinkName(){
		return this.ip.getHostAddress();
	}
	
	public int getNodePort(){
		return this.port;
	}
	
	
	public void printNodeInfo() {
		System.out.println("\tIP: "+ip.getHostAddress());
		System.out.println("\tPort: "+String.valueOf(port));
	}
	
	public boolean equalsTo(NodeInfo nodeInfo){
		if (this.port!=nodeInfo.port)
			return false;
		if (!(this.ip.getHostAddress().equals(nodeInfo.ip.getAddress())))
			return false;
		return true;
	}
}
