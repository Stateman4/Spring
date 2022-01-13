package ru.gb.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class BasicServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);

    private transient ServletConfig config; //транзиент - чтобы поле не сериализовалось

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
     this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");
        servletResponse.getWriter().println("<h1>Servlet content</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed",getServletInfo());
    }
}
