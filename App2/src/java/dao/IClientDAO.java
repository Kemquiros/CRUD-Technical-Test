
package dao;

import java.util.List;
import model.Clients;

/**
 *
 * @author t30r3m4
 */
public interface IClientDAO {
    //Create
    public void createClient(Clients c);
    //Read
    public List<Clients> readClients();
    //Update
    public void updateClient(Clients c);
    //Delete
    public void deleteClient(Clients c);
}
