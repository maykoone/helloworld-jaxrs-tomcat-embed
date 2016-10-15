package com.maykoone.jaxrsexamples;

import java.io.File;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 *
 * @author maykoone
 */
public class Main {

    public static void main(String[] args) throws LifecycleException {
        startServer().getServer().await();
    }

    public static Tomcat startServer() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);

        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

        ServletContainer jerseyServlet = new ServletContainer(ResourceConfig.forApplication(new JaxRsApplication()));
        Tomcat.addServlet(ctx, "jaxrs", jerseyServlet);
        ctx.addServletMapping("/*", "jaxrs");

        tomcat.start();
        return tomcat;
    }

    public static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(PORT).build();
    }
    
    public static final int PORT = 8080;

}
