package com.maykoone.jaxrsexamples;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maykoone
 */
public class HelloWorldResourceTest {

    static Tomcat server;

    public HelloWorldResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws LifecycleException {
        server = Main.startServer();
    }

    @AfterClass
    public static void tearDownClass() throws LifecycleException {
        if (server != null) {
            server.stop();
            server.destroy();
        }
    }

    @Test
    public void testHelloWorld() throws LifecycleException {
        WebTarget target = ClientBuilder.newClient().target(Main.getBaseURI() + "helloworld");
        assertEquals(HelloWorldResource.MESSAGE, target.request(MediaType.TEXT_PLAIN).get(String.class));
    }
}
