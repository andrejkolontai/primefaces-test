package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.primefaces.util.ResourceUtils;

import java.math.BigDecimal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
	
	private static final String JAKARTA_RESOURCE_URL = "/admin-ui/jakarta.faces.resource/9752-66110-07_3.jsf?ln=requestPhotosEdit";
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    
    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";
    }
    
    public String getJakartaResourceURL() {
    	return JAKARTA_RESOURCE_URL;
    }
    
    public String getJavaxResourceURL() {
    	return JAKARTA_RESOURCE_URL.replaceAll("jakarta\\.", "javax.");
    }
    
    public String getJakartaFromResourceUtils() {
    	FacesContext ctx = FacesContext.getCurrentInstance();
    	return ResourceUtils.getResourceURL(ctx, this.getJakartaResourceURL());
    }

    public String getJavaxFromResourceUtils() {
    	FacesContext ctx = FacesContext.getCurrentInstance();
    	return ResourceUtils.getResourceURL(ctx, this.getJavaxResourceURL());
    }
}
