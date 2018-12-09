package com.sti.privatebank.bisnis;

import java.util.List;
import java.util.Scanner;

import com.sti.privatebank.data.Database;
import com.sti.privatebank.interfaces.MenuCRUD;
import com.sti.privatebank.model.Customer;


public class View {
	
	Connector connector = new Database();
	MenuCRUD menuCrud = new MenuCRUD();
	
	public void viewCustomer () throws Exception {
		List<Customer> list = connector.getList();
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
		}
		
		System.out.println("1. Back to Menu CRUD");
		System.out.println("0. Exit");
		System.out.print("\nSilahkan masukkan nomor menu : ");
		
		Scanner pilihan = new Scanner(System.in);
		String pilihmenu = pilihan.nextLine();
		
		if (pilihmenu.equals("1")){
			menuCrud.menuCRUD();
			 	
		} else if (pilihmenu.equals("2")){
			 System.out.println("EXIT");
			 viewCustomer();
			 
		} else {
			 System.out.println("Maaf Pilihan Tidak ada. Silahkan input ulang");
			 viewCustomer();
			 
		}
		
	}

}
