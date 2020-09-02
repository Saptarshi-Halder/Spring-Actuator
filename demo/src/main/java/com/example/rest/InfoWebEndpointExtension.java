/*package com.example.rest;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class InfoWebEndpointExtension {


    @ReadOperation
    public WebEndpointResponse<Map> info() {
        
        HashMap<Object, Object>  newHashMap = new HashMap<>();
        newHashMap.put("info.app.version", "2.0.1");
        newHashMap.put("info.app.description", "Topic Software");
        
        
        return new WebEndpointResponse<>(newHashMap, 200);
    }

    
}*/