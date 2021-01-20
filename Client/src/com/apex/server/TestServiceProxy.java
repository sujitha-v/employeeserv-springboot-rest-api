package com.apex.server;

public class TestServiceProxy implements com.apex.server.TestService {
  private String _endpoint = null;
  private com.apex.server.TestService testService = null;
  
  public TestServiceProxy() {
    _initTestServiceProxy();
  }
  
  public TestServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initTestServiceProxy();
  }
  
  private void _initTestServiceProxy() {
    try {
      testService = (new com.apex.server.TestServiceServiceLocator()).getTestService();
      if (testService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)testService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)testService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (testService != null)
      ((javax.xml.rpc.Stub)testService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.apex.server.TestService getTestService() {
    if (testService == null)
      _initTestServiceProxy();
    return testService;
  }
  
  public int add(int i, int j) throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.add(i, j);
  }
  
  public com.apex.server.Employee getUser(int id) throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.getUser(id);
  }
  
  public java.lang.String sayHello() throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.sayHello();
  }
  
  public java.util.Calendar getServerDate() throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.getServerDate();
  }
  
  public java.lang.String hellowithName(java.lang.String name) throws java.rmi.RemoteException{
    if (testService == null)
      _initTestServiceProxy();
    return testService.hellowithName(name);
  }
  
  
}