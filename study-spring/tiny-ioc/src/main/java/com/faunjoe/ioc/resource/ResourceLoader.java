package com.faunjoe.ioc.resource;

/**
 * Resource的处理器ResourceLoader。当前我们就只处理classpath方式的
 * @author faunjoe
 */
public class ResourceLoader {
    
    final String CLASSPATH_URL_PREFIX = "classpath:";
	
	public Resource getResource(String location){
	    if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        else {
            return new ClassPathResource(location);
        }
	}
}
