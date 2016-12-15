package model;
// Generated 14/12/2016 09:40:55 PM by Hibernate Tools 4.3.1



/**
 * POJO
 */
public class Clients  implements java.io.Serializable {


     private Integer id;
     private String clientName;
     private String city;

    public Clients() {
    }

    public Clients(String clientName, String city) {
       this.clientName = clientName;
       this.city = city;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getClientName() {
        return this.clientName;
    }
    
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", name=" + clientName + ", city=" + city + '}';
    }




}


