package com.reco.common;

import org.springframework.beans.factory.BeanFactory;


public class ServiceLookup {

  private static BeanFactory serviceFactory = null;


  public static BeanFactory getServiceFactory() {
    return serviceFactory;
  }

  public static void setServiceFactory(BeanFactory serviceFactory) {
    ServiceLookup.serviceFactory = serviceFactory;
  }

  public static Object getService(String id){
//    if (serviceFactory == null)
//      init();
    return serviceFactory.getBean(id);
  }


}
