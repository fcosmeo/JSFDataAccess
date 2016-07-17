package pe.edu.utp.jsfdataaccess.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class EmployeesEntity {
    private Connection connection;

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) { this.connection = connection;}

    public void setEditEmployee(Employee employee){
        if(connection != null) {

            try {
                PreparedStatement pstm = null;
                pstm = getConnection().prepareStatement("update employees set first_name= ?,last_name= ? where employee_id= ? ");
                pstm.setString(1, employee.getFirstName());
                pstm.setString(2, employee.getLastName());
                pstm.setInt(3, employee.getId());
                pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void setEditEmployee2(int id, String firstName,String lastName){
            int li_cant;
            String sql="update employees set first_name= ?,last_name= ? where employee_id= ? ";

            try {
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString(1, firstName);
                pstm.setString(2, lastName);
                pstm.setInt(3, id);
                li_cant=pstm.executeUpdate();
                out.println("hola");
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public List<Employee> getEmployees(){
        String sql="SELECT *FROM employees";
        List<Employee> employees=new ArrayList<>();
        if(connection == null){
            return null;
        }
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(connection == null){ return null;}
            while(rs.next()){
                Employee employee=new Employee();
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setId(rs.getInt("employee_id"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}