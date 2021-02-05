package com.java.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class EmployeeServlet extends HttpServlet {
      //GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); to need to call super
        //we will write own implementation
        getServletContext().log("hashcode : "+this.hashCode());
        //System.out.println("not recommended");
        getServletContext().log("current thread "+Thread.currentThread());
        PrintWriter writer = resp.getWriter();
        writer.write("Welcome to web app"+this.getClass());
    }

    public EmployeeServlet()
    {
        //getServletContext().log("Constructor executed "); // java.lang.NullPointerException
        System.out.println("Constructor"+this.getClass());

    }
    //servlet life cycle method | (3) | init , service , destroy


    @Override
    public void init(ServletConfig config) throws ServletException {

        config.getServletContext().log("param based init "+this.getClass());
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        //super.init(); // it is empty so no need to call super
        getServletContext().log(" 0 param based init "+this.getClass());// executed only once
    }

    @Override
    public void destroy() {
        super.destroy();
        getServletContext().log("destroy is executing "+this.getClass()); // executed only once
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().log("service is executing "+this.getClass());
        super.service(req, resp);// service will execute first than doGET
        // service will executed the number times we refresh or send request tp the server
        displayContextAndConfig();
    }
    //can call any where inside the life cycle method or inside doXXX
    private void displayContextAndConfig()
    {
        ServletContext servletContext = getServletContext();
        servletContext = getServletConfig().getServletContext();

        ServletConfig servletConfig = getServletConfig();

        servletContext.log("------------print servlet context key value -----");
        Enumeration<String> contextKeys= servletContext.getInitParameterNames();
        while (contextKeys.hasMoreElements())
        {
            String key= contextKeys.nextElement();
            String value = servletContext.getInitParameter(key);
            servletContext.log(" key " +key+"  |  value  "+value);
        }

        servletContext.log("------------print servlet config key value -----");
        Enumeration<String> configKeys= servletConfig.getInitParameterNames();
        while (configKeys.hasMoreElements())
        {
            String key= configKeys.nextElement();
            String value = servletConfig.getInitParameter(key);
            servletContext.log(" key " +key+"  |  value  "+value);
        }

    }
}
