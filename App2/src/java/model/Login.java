package model;
// Generated 14/12/2016 09:40:55 PM by Hibernate Tools 4.3.1



/**
 * POJO
 */
public class Login  implements java.io.Serializable {


     private Integer id;
     private String userName;
     private String password;

    public Login() {
    }

    public Login(String userName, String password) {
       this.userName = userName;
       this.password = password;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" + "user=" + userName + ", password=" + password + '}';
    }




}


