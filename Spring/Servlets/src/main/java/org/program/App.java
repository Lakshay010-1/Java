package org.program;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main( String[] args ) throws LifecycleException {
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8081);

        Context context=tomcat.addContext("",null);
        Tomcat.addServlet(context,"Greet_Servlet",new ServletsHttp());
        context.addServletMappingDecoded("/greet","Greet_Servlet");

        tomcat.start();
        tomcat.getServer().await();

    }
}
