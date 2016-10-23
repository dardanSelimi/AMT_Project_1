package ch.heigvd.amt.project.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/***
 * 
 * @author Dardan Selimi & Romain Albasini
 */
@ApplicationPath("/api")
public class RESTDemoApplication  extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.disableMoxyJson", true);
        return properties;
    }
}
