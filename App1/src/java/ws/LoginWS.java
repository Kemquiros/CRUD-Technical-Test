/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Jersey REST client generated for REST resource:LoginResource [login]<br>
 * USAGE:
 * <pre>
 *        LoginClient client = new LoginClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author t30r3m4
 */
public class LoginWS {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/App2/webresources";

    public LoginWS() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("login");
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public JSONArray getJson() throws ClientErrorException, JSONException {
        WebTarget resource = webTarget;
        String temp = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        return new JSONArray(temp);
    }

    public void close() {
        client.close();
    }
    
}
