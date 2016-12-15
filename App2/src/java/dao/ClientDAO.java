
package dao;

import java.util.List;
import model.Clients;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.NewHibernateUtil;

/**
 *
 * @author t30r3m4
 */
public class ClientDAO implements IClientDAO{



    @Override
    public List<Clients> readClients() {
        Session session = null;
        List<Clients> list =null;
        
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Clients");
            list = (List<Clients>)q.list();            
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
    public void createClient(Clients c) {
        doAction(1, c);     
    }    

    @Override
    public void updateClient(Clients c) {
        doAction(2, c);   
    }

    @Override
    public void deleteClient(Clients c) {
        doAction(3, c);
    }
    
    private void doAction(int n,Clients c){//Especie de Facade GoF Pattern
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();//Solicita nueva sesion al Factory
            session.beginTransaction();//Inicia la transaccion
            switch(n){
                case 1://Create
                    session.save(c);//Almacena el objeto
                    break;
                case 2://Update
                    session.update(c);//Actualiza el objeto
                    break;
                case 3://Delete
                    session.delete(c);//Elimina el objeto
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
