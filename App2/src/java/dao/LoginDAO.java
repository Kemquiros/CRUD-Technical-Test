/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Login;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.NewHibernateUtil;

/**
 *
 * @author t30r3m4
 */
public class LoginDAO implements ILoginDAO{

    @Override
    public void createLogin(Login l) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Login> readLogins() {
        Session session = null;
        List<Login> list =null;
        
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Login");
            list = (List<Login>)q.list();            
        }catch(HibernateException he){
            System.err.println(he.getMessage());
        }finally{
            if(session!=null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public void updateLogin(Login l) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deleteLogin(Login l) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
