package pe.edu.utp.jsfdataaccess.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@ManagedBean(name = "hrservicefacade", eager = true)
@SessionScoped
public class HRServiceFacade {
    private Connection connection;

    public HRServiceFacade() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        return connection;
    }

    private EmployeesEntity getEmployeesEntity() {
        EmployeesEntity employeesEntity = new EmployeesEntity();
        employeesEntity.setConnection(connection);
        return employeesEntity;
    }

    public int getEmployeesCount() {
        return getEmployeesEntity().getEmployees().size();
    }

    public List<Employee> getEmployees() {
        return getEmployeesEntity().getEmployees();
    }


}