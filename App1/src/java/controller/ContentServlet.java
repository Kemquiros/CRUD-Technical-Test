/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author t30r3m4
 */
public class ContentServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String codeParam = request.getParameter("code");
            String code ="";
            if(codeParam.equals("login")){
                code= "<div class=\"mdl-grid demo-content\">\n" +
"          <div class=\"demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid\">\n" +
"            <div class=\"demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop\">\n" +
"              <div class=\"mdl-card__title mdl-card--expand mdl-color--teal-300\">\n" +
"                <h1 class=\"mdl-card__title-text\">Login</h1>\n" +
"              </div>\n" +
"                \n" +
"\n" +
"              <div class=\"mdl-card__supporting-text mdl-color-text--grey-600\">\n" +
"                <div title=\"User: admin\" class=\"icon material-icons\">help_outline</div>\n" +
"                 <div class=\"mdl-textfield mdl-js-textfield mdl-textfield--floating-label\">\n" +
"                    <input class=\"mdl-textfield__input\" type=\"text\" id=\"user\">\n" +
"                    <label class=\"mdl-textfield__label\" >User</label>\n" +
"                </div><br>    \n" +
"                <div title=\"Password: 123\" class=\"icon material-icons\">help_outline</div>\n" +
"                <div class=\"mdl-textfield mdl-js-textfield mdl-textfield--floating-label\">\n" +
"                  <input class=\"mdl-textfield__input\" type=\"text\" id=\"pass\">\n" +
"                  <label class=\"mdl-textfield__label\" >Password</label>\n" +
"                </div><br>\n" +
"                <button class=\"mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored\" onclick=\"getLogin()\">\n" +
"                  <i class=\"material-icons\">input</i>\n" +
"                  </button>\n" +
"                <br>\n" +
"                \n" +
"              </div>\n" +
"\n" +
"            </div>\n" +
"          </div>\n" +
"\n" +
"          \n" +
"        </div>";
            }else if(codeParam.equals("home")){
                code="<div class=\"mdl-grid demo-content\">\n" +
"          <div class=\"demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid\">\n" +
"            <div class=\"demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop\">\n" +
"              <div class=\"mdl-card__title mdl-card--expand mdl-color--teal-300\">\n" +
"                <h1 class=\"mdl-card__title-text\">App 1: Client Side</h1>\n" +
"              </div>\n" +
"              <div class=\"mdl-card__supporting-text mdl-color-text--grey-600\">\n" +
"                Guest user: Only can read data.\n" +
"                <br>\n" +
"                Admin user: Totally CRUD data.\n" +
"              </div>\n" +
"\n" +
"            </div>\n" +
"          </div>\n" +
"\n" +
"          <div class=\"demo-cards mdl-cell mdl-color--blue mdl-shadow--2dp mdl-cell--4-col mdl-cell--8-col-tablet mdl-grid mdl-grid--no-spacing\">\n" +
"          <h1 class=\"mdl-card__title-text mdl-color-text--white\">Komet Sales</h1>\n" +
"            <div class=\"demo-separator mdl-cell--1-col\"></div>\n" +
"            <div class=\"demo-options mdl-card mdl-color--deep-purple-500 mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--3-col-tablet mdl-cell--12-col-desktop\">\n" +
"              \n" +
"              <div class=\"mdl-card__supporting-text mdl-color-text--blue-grey-50\">\n" +
"                \n" +
"                <h3>Technical Test</h3>\n" +
"                <p>John Tapias Zarrazola</p>\n" +
"              </div>\n" +
"            </div>\n" +
"          </div>\n" +
"        </div>";
            }
            
            out.write(code);
            out.flush();
            out.close();
        }
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
        processRequest(request, response);
    }



}
