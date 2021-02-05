package com.java.listeners;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;


// you can have bunch of  listeners .and registered them in deployment  descriptor ( web.xml )

// On startup it executes
//onDestroy it executes
// this is one time activity

public class AppEventListener implements ServletContextListener {

    private ServletContext servletContext;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
      servletContext=sce.getServletContext();
      servletContext.log("context initialized "+this.getClass());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext= sce.getServletContext();
        servletContext.log("context Destroyed  "+this.getClass());
        displayContext();

    }
    private void displayContext()
    {

        servletContext.log("------------print servlet context key value -----");
        Enumeration<String> contextKeys= servletContext.getInitParameterNames();
        while (contextKeys.hasMoreElements())
        {
            String key= contextKeys.nextElement();
            String value = servletContext.getInitParameter(key);
            servletContext.log(" key " +key+"  |  value  "+value);
        }


    }
}
