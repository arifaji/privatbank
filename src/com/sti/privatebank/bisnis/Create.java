package com.sti.privatebank.bisnis;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sti.privatebank.data.Database;
import com.sti.privatebank.interfaces.MenuCRUD;
import com.sti.privatebank.model.Customer;

public class Create {
	MenuCRUD menuCrud = new MenuCRUD();
	Connector connector = new Database();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public void createCustomer() throws Exception {
		
		Scanner inputCustomer = new Scanner(System.in);
		System.out.println("Input Data Customer");
		System.out.println("==================");
		System.out.print("Input First Name : ");
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
		
		Customer inputcustomer = new Customer(firstName, lastName, dateFormat.parse(birthDate), username, password, phoneType, phoneNumber, 0);
		connector.insertCustomer(inputcustomer);
//		Customer customer2 = new Customer(0, "alex", "zander", dateFormat.parse("2000-04-14"), "alexzander", "P@ssw0rd", "0823232323", "iphone");
//		connector.insertCustomer(customer2);
		
		System.out.println("1. Back to Menu CRUD");
		System.out.println("0. Exit");
		System.out.print("\nSilahkan masukkan nomor menu : ");
		
		Scanner pilihan = new Scanner(System.in);
		String pilihmenu = pilihan.nextLine();
		
		if (pilihmenu.equals("1")){
			menuCrud.menuCRUD();
			 	
		} else if (pilihmenu.equals("2")){
			 System.out.println("EXIT");
			 createCustomer();			 
		} else {
			 System.out.println("Maaf Pilihan Tidak ada. Silahkan input ulang");
			 createCustomer();
		}
	}

}
