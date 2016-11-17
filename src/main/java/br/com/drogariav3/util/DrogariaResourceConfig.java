package br.com.drogariav3.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class DrogariaResourceConfig extends ResourceConfig {
	public DrogariaResourceConfig() {
		packages("br.com.drogariav3.service");
	}

}
