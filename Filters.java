DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter Demo</title>
</head>
<body>
        <a href="dashboard?userid=johndoe">Account Dashboard (allow filter)</a><br>
        <a href="profile?userid=johndoe">Account Profile (allow filter)</a><br>
        <a href="dashboard">Account Dashboard (block filter)</a><br>
        <a href="info">Info Page </a><br>
</body>
</html>

//AccountProfile

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class AccountProfile
*/
@WebServlet("/AccountProfile")
public class AccountProfile extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public AccountProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                response.getWriter().write("I am in Account Profile after passing through LoginFilter");
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}

//Acccount Dashboard

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class AccountDashboard
*/
@WebServlet("/AccountDashboard")
public class AccountDashboard extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public AccountDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
        
                response.getWriter().write("I am in Account Dashboard after passing through LoginFilter");
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}

//InfoPage

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class InfoPage
*/
@WebServlet("/InfoPage")
public class InfoPage extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public InfoPage() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                response.getWriter().write("I am in InfoPage");
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}

//LoginFilter

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
* Servlet Filter implementation class LoginFilter
*/
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
* Default constructor.
*/
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

        /**
         * @see Filter#destroy()
         */
        public void destroy() {
                // TODO Auto-generated method stub
        }

        /**
         * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
         */
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                // TODO Auto-generated method stub
                // place your code here
                
                String userId = request.getParameter("userid");

                if( userId != null){
                        chain.doFilter(request, response);
            }
                 
                
        }

        /**
         * @see Filter#init(FilterConfig)
         */
        public void init(FilterConfig fConfig) throws ServletException {
                // TODO Auto-generated method stub
        }

}


//web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>FilterDemo</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  
  <filter>
    <filter-name>loginFilter</filter-name>
    <filter-class>LoginFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>loginFilter</filter-name>
    <url-pattern>/dashboard</url-pattern>
    <url-pattern>/profile</url-pattern>
  </filter-mapping>
  
  
  <servlet>
    <servlet-name>AccountDashboard</servlet-name>
    <servlet-class>AccountDashboard</servlet-class>
  </servlet>
  <servlet>
    <servlet-name>AccountProfile</servlet-name>
    <servlet-class>AccountProfile</servlet-class>
  </servlet>
  <servlet>
    <servlet-name>InfoPage</servlet-name>
    <servlet-class>InfoPage</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>AccountDashboard</servlet-name>
    <url-pattern>/dashboard</url-pattern>
  </servlet-mapping>
   <servlet-mapping>
    <servlet-name>AccountProfile</servlet-name>
<url-pattern>/profile</url-pattern>
  </servlet-mapping>
   <servlet-mapping>
    <servlet-name>InfoPage</servlet-name>
    <url-pattern>/info</url-pattern>
  </servlet-mapping>
</web-app>

//To run the project, open a web browser and type: http://localhost:8080/FilterDemo

