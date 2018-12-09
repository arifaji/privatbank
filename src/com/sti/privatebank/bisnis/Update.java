package com.sti.privatebank.bisnis;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.sti.privatebank.data.Database;
import com.sti.privatebank.interfaces.MenuCRUD;
import com.sti.privatebank.model.Customer;

public class Update {
	Connector connector = new Database();
	MenuCRUD menuCrud = new MenuCRUD();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public void updateCustomer() throws Exception {
	/*	List<Customer> list = connector.getList();
		System.out.println("View Data Customer");
		if(list!=null && !list.isEmpty()) {
			for (Customer customer : list) {
				System.out.println("==================================");
				System.out.println("customer\t : "+customer.getCustomerNumber());
				System.out.println("firstName\t : "+customer.getFirstName());
				System.out.println("lastName\t : "+customer.getLastName());
				System.out.println("username\t : "+customer.getUsername());
				System.out.println("password\t : "+customer.getPassword());
				System.out.println("phonetype\t : "+customer.getPhoneType());
				System.out.println("phonenumber\t : "+customer.getPhoneNumber());
		}
				System.out.println("==================================");
		} else {
			System.out.println("empty data");
		} */
		
		System.out.print("\nSilahkan masukkan id yg mau diupdate : ");	
		Scanner inputCustomer = new Scanner(System.in);
		Scanner idCustomer = new Scanner(System.in);
		
		int customerNumber = idCustomer.nextInt();
		System.out.println("====================");
		
		System.out.println("Input First Name : ");
		String firstName = inputCustomer.nextLine();
		System.out.print("Input Last Name : ");
		String lastName = inputCustomer.nextLine();
		System.out.print("Input Birthday  : ");
		String birthDate = inputCustomer.nextLine();
		System.out.print("Input Username : ");
		String username = inputCustomer.nextLine();
		System.out.print("Input Password : ");
		String password = inputCustomer.nextLine();
		System.out.print("Input Phone Type : ");
		String phoneType = inputCustomer.nextLine();
		System.out.print("Input Phone Number : ");
		String phoneNumber = inputCustomer.nextLine();
		
		Customer updatecustomer = new Customer(firstName, lastName, dateFormat.parse(birthDate), username, password, phoneType, phoneNumber, customerNumber);
		connector.updateCustomer(updatecustomer);
		
//		Customer inputcustomer = new Customer(firstName, lastName, dateFormat.parse(birthDate), username, password, phoneType, phoneNumber, customernumber);
//		connector.updateCustomer(inputcustomer);
		
		System.out.println("1. Back to Menu CRUD");
		System.out.println("0. Exit");
		System.out.print("\nSilahkan masukkan nomor menu : ");
		
		Scanner pilihan = new Scanner(System.in);
		String pilihmenu = pilihan.nextLine();
		
		if (pilihmenu.equals("1")){
			menuCrud.menuCRUD();
			 	
		} else if (pilihmenu.equals("2")){
			 System.out.println("EXIT");
			 updateCustomer();
			 
		} else {
			 System.out.println("Maaf Pilihan Tidak ada. Silahkan input ulang");
			 updateCustomer();
			 
		}
		
	}
	

}
