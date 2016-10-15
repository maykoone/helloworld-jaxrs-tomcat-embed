package com.maykoone.jaxrsexamples;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *  JAX-RS application class
 * @author maykoone
 */
public class JaxRsApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public JaxRsApplication() {
        singletons.add(new HelloWorldResource());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
