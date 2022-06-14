package com.amelin.traveladviser.app.rest.service.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
/**
 * REST web-service configuration for Jersey
 * @author Mike Amelin
 */
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {packages("com.amelin.traveladviser.app.rest");}
}
