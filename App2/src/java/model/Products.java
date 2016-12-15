package model;
// Generated 14/12/2016 09:40:55 PM by Hibernate Tools 4.3.1



/**
 * POJO
 */
public class Products  implements java.io.Serializable {


     private Integer id;
     private String productName;
     private Integer quantity;

    public Products() {
    }

    public Products(String productName, Integer quantity) {
       this.productName = productName;
       this.quantity = quantity;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}


