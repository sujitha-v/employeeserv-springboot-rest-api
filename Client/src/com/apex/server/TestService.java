/**
 * TestService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.apex.server;

public interface TestService extends java.rmi.Remote {
    public int add(int i, int j) throws java.rmi.RemoteException;
    public com.apex.server.Employee getUser(int id) throws java.rmi.RemoteException;
    public java.lang.String sayHello() throws java.rmi.RemoteException;
    public java.util.Calendar getServerDate() throws java.rmi.RemoteException;
    public java.lang.String hellowithName(java.lang.String name) throws java.rmi.RemoteException;
}
