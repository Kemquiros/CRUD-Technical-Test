/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Login;

/**
 *
 * @author t30r3m4
 */
public interface ILoginDAO {
        //Create
    public void createLogin(Login l);
    //Read
    public List<Login> readLogins();
    //Update
    public void updateLogin(Login l);
    //Delete
    public void deleteLogin(Login l); 
    
}
