package com.reco.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


import org.springframework.web.context.support.WebApplicationContextUtils;


import com.reco.common.ServiceLookup;






public class AppInitServlet extends HttpServlet {


	
  public void init() throws ServletException {
    // all we need to do is to save the BeanFactory in the ServiceLocator
    System.out.println("Initializing services............");
    ServiceLookup.setServiceFactory(WebApplicationContextUtils.getWebApplicationContext(getServletContext()));
    System.out.println("Done initializing services!!!");
    
   
  }

}
