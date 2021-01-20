package com.apex.server;

import java.rmi.RemoteException;

public class Client {
	public static void main(String[] args) throws RemoteException {
		TestServiceProxy ts=new TestServiceProxy();
		int val=ts.add(3, 4);
		System.out.println(val);
		

	}
	
}
