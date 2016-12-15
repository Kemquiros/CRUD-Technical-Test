/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ClientErrorException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ws.ClientWS;

/**
 *
 * @author t30r3m4
 */
public class ClientServlet extends HttpServlet {

    //CRUD what uses ClientWS 

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getParameter("code").equals("create")){
            System.out.println("Ingresa ClientServlet App 1 >> POST");
            ClientWS client = new ClientWS();
            JSONObject jo = new JSONObject();


            String name = req.getParameter("name");
            String city = req.getParameter("city");

            try {
                jo.append("name", name);
                jo.append("city", city);
            } catch (JSONException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            client.postJson(jo.toString());
        }else if(req.getParameter("code").equals("delete")){
            System.out.println("Ingresa ClientServlet App 1 >> DELETE");
            ClientWS client = new ClientWS();
            JSONObject jo = new JSONObject();


            String id = req.getParameter("id");

            try {
                jo.append("id", id);
            } catch (JSONException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                client.deleteJson(jo.toString());
            } catch (ClientErrorException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(req.getParameter("code").equals("update")){
            System.out.println("Ingresa ClientServlet App 1 >> UPDATE");
            ClientWS client = new ClientWS();
            JSONObject jo = new JSONObject();
            try {
                jo.append("id", req.getParameter("id"));
                jo.append("name", req.getParameter("name"));
                jo.append("city", req.getParameter("city"));
            } catch (JSONException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            client.putJson(jo.toString());
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Ingresa ClientServlet App 1 >> GET");
        //resp.setContentType("application/json");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session= req.getSession();
        ClientWS client = new ClientWS();
        String code="";
        //Si es Admin puede ver usar todo el CRUD
        //Si es Guest sólo puede usar Read
        if(session.getAttribute("admin") != null){
            if(session.getAttribute("admin").equals("1")){
                try {
                    //Script
                    /*
                    code = code.concat("<script>");
                    code = code.concat("function createRow(o){");
                    
                    code = code.concat("$.ajax(");
                    code = code.concat("url: 'http://localhost:8080/App1/client',");
                    code = code.concat("id: $('id1').val(),");
                    code = code.concat("name: $('id2').val(),");
                    code = code.concat("city: $('id3').val(),");
                    code = code.concat("type: 'POST'");
                    code = code.concat("}).then(function(text) {clients();});");
                    code = code.concat("</script>");  
                    */
                    JSONArray ja =client.getJson();
                    code ="<table class='mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp'>";
                    code = code.concat("<thead>");
                    code = code.concat("<tr>");
                    code = code.concat("<th>");
                    code = code.concat("ID");
                    code = code.concat("</th>");
                    code = code.concat("<th>");
                    code = code.concat("Name");
                    code = code.concat("</th>");
                    code = code.concat("<th>");
                    code = code.concat("City");
                    code = code.concat("</th>");
                    code = code.concat("<th>");
                    code = code.concat("</th>");
                    code = code.concat("</tr>");
                    code = code.concat("</thead>");
                    code = code.concat("<tbody>");
                    for(int i=0;i<ja.length();i++){ 
                        code = code.concat("<tr>");
                        JSONObject jo = ja.getJSONObject(i);
                        code = code.concat("<td>");
                        code = code.concat(jo.get("id").toString());
                        code = code.concat("</td>");
                        code = code.concat("<td>");
                        code = code.concat(jo.get("name").toString());
                        code = code.concat("</td>");    
                        code = code.concat("<td>");
                        code = code.concat(jo.get("city").toString());
                        code = code.concat("</td>");
                        code = code.concat("<td>");
                        //Update------------------
                        code = code.concat("<button class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect' onclick='editRow(this)'>");
                        code = code.concat("<i class='material-icons'>mode_edit</i>");
                        code = code.concat("</button>");
                        //Delete------------------
                        code = code.concat("<button class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect' onclick='deleteRow(this)'>");
                        code = code.concat("<i class='material-icons'>delete_forever</i>");
                        code = code.concat("</button>");                      
                        code = code.concat("</td>");                        
                        code = code.concat("</tr>");

                    }
                    //Create------------------
                    code = code.concat("<tr>");
                    code = code.concat("<td>");
                    code = code.concat("<span>");
                    code = code.concat("</span>");
                    code = code.concat("</td>");
                    code = code.concat("<td>");                                      
                    code = code.concat("<input class='mdl-textfield__input' type='text' id='id2' size='8'>");
                    code = code.concat("<label class='mdl-textfield__label' >Name</label>");  
                    code = code.concat("<td>");
                    code = code.concat("<input class='mdl-textfield__input' type='text' id='id3' size='8'>");
                    code = code.concat("<label class='mdl-textfield__label' >City</label>");
                    code = code.concat("</td>");
                    code = code.concat("<td>");
                    code = code.concat("<button class='mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect' onclick='createRow(this)'>");
                    code = code.concat("<i class='material-icons'>send</i>");
                    code = code.concat("</button>");
                    code = code.concat("</tr>");
                    code = code.concat("</tbody>");
                    code = code.concat("</table>");
                    

                   
                } catch (ClientErrorException ex) {
                    Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            try {
                JSONArray ja =client.getJson();
                code ="<table class='mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp'>";
                code = code.concat("<thead>");
                code = code.concat("<tr>");
                code = code.concat("<th>");
                code = code.concat("ID");
                code = code.concat("</th>");
                code = code.concat("<th>");
                code = code.concat("Name");
                code = code.concat("</th>");
                code = code.concat("<th>");
                code = code.concat("City");
                code = code.concat("</th>");
                code = code.concat("</tr>");
                code = code.concat("</thead>");
                code = code.concat("<tbody>");
                for(int i=0;i<ja.length();i++){ 
                    code = code.concat("<tr>");
                    JSONObject jo = ja.getJSONObject(i);
                    code = code.concat("<td>");
                    code = code.concat(jo.get("id").toString());
                    code = code.concat("</td>");
                    code = code.concat("<td>");
                    code = code.concat(jo.get("name").toString());
                    code = code.concat("</td>");    
                    code = code.concat("<td>");
                    code = code.concat(jo.get("city").toString());
                    code = code.concat("</td>");                    
                    code = code.concat("</tr>");
                    
                }
                code = code.concat("</tbody>");
                code = code.concat("</table>");
                
            } catch (ClientErrorException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*JSONObject jsonResp = null;
        try {
            jsonResp = new JSONObject(code);
        } catch (JSONException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        PrintWriter out = resp.getWriter();
        out.print(code);
        out.flush();
        out.close();
        
        
        
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }    
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }




    

}
