package pe.edu.utp.jsfdataaccess.models;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by GrupoUTP on 09/07/2016.
 */
@ManagedBean(name = "employee")
@SessionScoped
public class Employee {
    private String firstName;
    private String lastName;
    private Integer id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }


}