package com.redhat.examples.hola2.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="greeting")
public class GreeterRestController {
	
	private String saying;
	private String backendServiceHost;
	private String backendServicePort;
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "text/plain")
	public String greeting() {
		
		String backendServiceURL = String.format("http://%s:%d/hello?greeting={greeting}", backendServiceHost, backendServicePort);
		System.out.println("Sending to: " + backendServiceURL);
		return backendServiceURL;
	}

	public String getSaying() {
		return saying;
	}

	public void setSaying(String saying) {
		this.saying = saying;
	}

	public String getBackendServiceHost() {
		return backendServiceHost;
	}

	public void setBackendServiceHost(String backendServiceHost) {
		this.backendServiceHost = backendServiceHost;
	}

	public String getBackendServicePort() {
		return backendServicePort;
	}

	public void setBackendServicePort(String backendServicePort) {
		this.backendServicePort = backendServicePort;
	}
}
