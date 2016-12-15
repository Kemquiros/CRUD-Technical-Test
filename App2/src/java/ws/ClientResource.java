/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.ClientDAO;
import dao.IClientDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Clients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author t30r3m4
 */
@Path("client")
public class ClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public ClientResource() {
    }

    /**
     * Retrieves representation of an instance of ws.ClientResource
     * @return an instance of java.lang.String
     * @throws org.json.JSONException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws JSONException {
        IClientDAO clientDAO = new ClientDAO();
        JSONArray ja = new JSONArray();
        for(Clients c:clientDAO.readClients()){
            JSONObject jo = new JSONObject(c.toString());            
            //jo.append("name", c.getClientName());
            //jo.append("city", c.getCity());
            //jo.append("id", c.getId());
            ja.put(jo);
        }
        return ja.toString();
    }

    /**
     * PUT method for updating or creating an instance of ClientResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) throws JSONException {
        JSONObject jo = new JSONObject(content);
        String id = jo.get("id").toString();
        String name= jo.get("name").toString();//Limpiar los rastros de JSON
        String city = jo.get("city").toString();
        id= id.substring(2, id.length()-2);
        name= name.substring(2, name.length()-2);
        city= city.substring(2, city.length()-2);
        
        IClientDAO clientDAO = new ClientDAO();
        List<Clients> lc = clientDAO.readClients();
        for(Clients cTemp:lc){
            if(cTemp.getId()==Integer.parseInt(id)){
                cTemp.setCity(city);
                cTemp.setClientName(name);
                clientDAO.updateClient(cTemp);
            }
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content) throws JSONException {
        JSONObject jo = new JSONObject(content);
        IClientDAO clientDAO = new ClientDAO();
        String p1 = jo.get("name").toString();//Limpiar los rastros de JSON
        String p2 = jo.get("city").toString();//Limpiar los rastros de JSON
        Clients c= new Clients( p1.substring(2, p1.length()-2), p2.substring(2, p2.length()-2));
        clientDAO.createClient(c);
    }
    

    @DELETE
    @Path(value="/{idClient}")
    public void deleteJson(String content,@PathParam("idClient") int idClient) throws JSONException {
        //idClient="100";
        Clients c= null;
        IClientDAO clientDAO = new ClientDAO();
        List<Clients> lc = clientDAO.readClients();
        for(Clients cTemp:lc){
            if(cTemp.getId()==idClient){
                System.out.println("Elimina Cliente con id -> "+idClient);
                c=cTemp;
            }
        }        
        clientDAO.deleteClient(c);
    }    
}
