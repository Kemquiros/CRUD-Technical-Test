
package dao;

import java.util.List;
import model.Products;

/**
 *
 * @author t30r3m4
 */
public interface IProductDAO {
    //Create
    public void createProduct(Products p);
    //Read
    public List<Products> readProducts();
    //Update
    public void updateProduct(Products p);
    //Delete
    public void deleteProduct(Products p);    
}
