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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ClientErrorException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ws.LoginWS;

/**
 *
 * @author t30r3m4
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClientErrorException, JSONException {
       response.setContentType("application/json");
       response.setCharacterEncoding("utf-8");
        
       System.out.println("Ingresa Login de App1");
       String user = request.getParameter("user");
       String password = request.getParameter("pass");
       Boolean exist = false;
       JSONObject jsonResp = new JSONObject();//Json que almacena la respuesta
       LoginWS loginClient = new LoginWS();//Cliente que consume REST webservice
       JSONArray res = loginClient.getJson();

       for(int i=0;i<res.length();i++){
           JSONObject jo = new JSONObject(res.optJSONObject(i).toString());
           if(user.compareTo(jo.get("user").toString())==0 && password.compareTo(jo.get("password").toString())==0){
                exist = true;
           }
       }
        if(exist){
            HttpSession session= request.getSession(true);
            session.setAttribute("admin", "1");
            Cookie ck = new Cookie("admin", "1");
            ck.setMaxAge(60 * 10);
            ck.setPath("/");
            ck.setSecure(false);
            response.addCookie(ck);
            System.out.println("Admin ha iniciado sesión");
           jsonResp.append("log", "ok");
       }else{
           jsonResp.append("log", "no");
       }
       PrintWriter out = response.getWriter();
        out.print(jsonResp);
        out.flush();
    }




    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClientErrorException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */


}
