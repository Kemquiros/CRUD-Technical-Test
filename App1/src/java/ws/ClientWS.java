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
import org.json.JSONObject;
import org.json.JSONException;

/**
 * Jersey REST client generated for REST resource:ClientResource [client]<br>
 * USAGE:
 * <pre>
 *        ClientWS client = new ClientWS();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author t30r3m4
 */
public class ClientWS {

    private WebTarget webTarget;
    private WebTarget webTarget1;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/App2/webresources";

    public ClientWS() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("client");
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }
    
    public void postJson(Object requestEntity) throws ClientErrorException {        
        System.out.println("Antes de enviar >> "+(String)requestEntity);
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public JSONArray getJson() throws ClientErrorException, JSONException {
        WebTarget resource = webTarget;
        String temp = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        return new JSONArray(temp);
    }
    
    public void deleteJson(Object requestEntity) throws ClientErrorException, JSONException {     

        JSONObject jo = new JSONObject((String)requestEntity);
        String p1 = jo.get("id").toString();
        p1=p1.substring(2, p1.length()-2);       
        //System.out.println("Destino - > "+client.target("http://localhost:8080/App2/webresources").path("client").queryParam("idClient", p1).toString());
        
        Object o = client.target("http://localhost:8080/App2/webresources/client/"+p1).request().delete();
         
        
        //WebResource resource = client.resource(BASE_URI);
        //webTarget.
        //webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).delete(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }    

    public void close() {
        client.close();
    }
    
}
