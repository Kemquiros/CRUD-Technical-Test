
package dao;

import java.util.List;
import model.Products;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.NewHibernateUtil;

/**
 *
 * @author t30r3m4
 */
public class ProductDAO implements IProductDAO{



    @Override
    public List<Products> readProducts() {
        Session session = null;
        List<Products> list =null;
        
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Products");
            list = (List<Products>)q.list();            
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
    public void createProduct(Products p) {
        doAction(1, p);              
    }    

    @Override
    public void updateProduct(Products p) {
        doAction(2, p);      
    }

    @Override
    public void deleteProduct(Products p) {
        doAction(3, p);
    }
    
    private void doAction(int n,Products p){//Especie de Facade GoF Pattern
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();//Solicita nueva sesion al Factory
            session.beginTransaction();//Inicia la transaccion
            switch(n){
                case 1://Create
                    session.save(p);//Almacena el objeto
                    break;
                case 2://Update
                    session.update(p);//Actualiza el objeto
                    break;
                case 3://Delete
                    session.delete(p);//Elimina el objeto
                    break;
            }            
            session.getTransaction().commit();                     
        }catch(HibernateException he){//En caso de error
            System.err.println(he.getMessage());//Muestra el error
            session.getTransaction().rollback();//Devuelve la transaccion
        }finally{
            if(session!=null){//Si la transaccion se existe
                session.close();//Cierra la sesion existente
            }
        }                                                       
    }    
    
}
