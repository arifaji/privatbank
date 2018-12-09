package com.sti.privatebank.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sti.privatebank.bisnis.Connector;
import com.sti.privatebank.model.Customer;

public class Database implements Connector {
	//Setting DB
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/day4msql";
    static final String USER = "root";
    static final String PASS = "";
    //End Setting DB
    
    String hasil = "";
    
    //Setting Connection DB   
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private Connection getConnection () throws ClassNotFoundException, SQLException {
    	if (connect == null || connect.isClosed()) {
    		Class.forName(JDBC_DRIVER);
    		connect = DriverManager.getConnection(DB_URL, USER, PASS);
    	}
		return connect;
    }
    //End Setting Connection
    
    //View Customer List
    @Override
    public List<Customer> getList() throws Exception{
		statement = getConnection().createStatement();
        resultSet = statement.executeQuery("select * from customer");
        
        List<Customer> list = new ArrayList<>();
        
        while (resultSet.next()) {
        		Customer customer = new Customer();
        		customer.setBirthDate(resultSet.getDate("birthdate"));
        		customer.setCustomerNumber(resultSet.getInt("customernumber"));
        		customer.setFirstName(resultSet.getString("firstname"));
        		customer.setLastName(resultSet.getString("lastname"));
        		customer.setUsername(resultSet.getString("username"));
        		customer.setPassword(resultSet.getString("password"));
        		customer.setPhoneType(resultSet.getString("phonetype"));
        		customer.setPhoneNumber(resultSet.getString("phonenumber"));
        		
        		list.add(customer);
        }
        
        return list;
	}
    //End View Customer List
    
    //Create Customer
    public void insertCustomer(Customer customer) throws Exception{
		preparedStatement = getConnection()
                .prepareStatement("INSERT INTO `day4msql`.`customer`\n" + 
                		"(`firstname`, `lastname`, `birthdate`, `username`, `password`, `phonenumber`, `phonetype`)\n" + 
                		"VALUES\n" + 
                		"(?,?,?,?,?,?,?)");

		preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setDate(3, new java.sql.Date(customer.getBirthDate().getTime()));
        preparedStatement.setString(4, customer.getUsername());
        preparedStatement.setString(5, customer.getPassword());
        preparedStatement.setString(6, customer.getPhoneType());
        preparedStatement.setString(7, customer.getPhoneNumber());
        preparedStatement.executeUpdate();
	}
    //End Create Customer
   
    //Delete Customer
	@Override
	public String deleteCust(Customer cust) {
		// TODO Auto-generated method stub
		PreparedStatement ps =null;
		try {
			String sql = "DELETE FROM customer WHERE customernumber= ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, cust.getCustomerNumber());
			//System.out.println(ps);
			ps.executeUpdate();
			
			
			hasil = "Berhasil";
		} catch (Exception e) {
			hasil = "Gagal";
		}
		return hasil;
		
	}
	//End Delete Customer

	@Override
	public String updateCustomer(Customer updateCustomer) throws Exception {
    	try {
    		preparedStatement = getConnection()
                    .prepareStatement("UPDATE `day4msql`.`customer` SET `firstname` = '?', `lastname` = '?', `birthdate` = '?', `username` = '?', `Password` = '?', `phonetype` = '?', `phonenumber` = '?' WHERE (`customernumber` = '?')");
    		//UPDATE `day4msql`.`customer` SET `firstname` = 'rexuss', `lastname` = 's', `birthdate` = '1980-09-09 00:00:00', `username` = '123a456', `Password` = '1234a564', `phonetype` = '123a456', `phonenumber` = '1234a564' WHERE (`customernumber` = '17');

    		preparedStatement.setString(1, updateCustomer.getFirstName());
            preparedStatement.setString(2, updateCustomer.getLastName());
            preparedStatement.setDate(3, new java.sql.Date(updateCustomer.getBirthDate().getTime()));
            preparedStatement.setString(4, updateCustomer.getUsername());
            preparedStatement.setString(5, updateCustomer.getPassword());
            preparedStatement.setString(6, updateCustomer.getPhoneType());
            preparedStatement.setString(7, updateCustomer.getPhoneNumber());
            preparedStatement.setInt(8, updateCustomer.getCustomerNumber());
            preparedStatement.executeUpdate();
            
            hasil = "Berhasil Update";
    	} catch (Exception e) {
    		hasil = "Gagal Update";
    	}
		return hasil;
	}
       

}
