package com.ovd.projetoteste.config;

import com.ovd.projetoteste.api.VeiculoApi;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Luan
 */
@javax.ws.rs.ApplicationPath("ovdService")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        //Necessariamente precisa estar por primeiro do que a linha
        //addRestResourceClasses(resources);
        resources.add(ObjectMapperProvider.class);
        resources.add(JacksonFeature.class);
        resources.add(CORSResponseFilter.class);

        addRestResourceClasses(resources);

        return resources;
    }


    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(VeiculoApi.class);
    }
}
