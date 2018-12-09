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
	private DateFormat dateFormat;
	
	public void createCustomer() throws Exception {
		
//		Scanner inputCustomer = new Scanner(System.in);
//		System.out.println("Input Data Customer");
//		System.out.println("==================");
//		System.out.print("Input First Name : ");
//		String firstName = inputCustomer.nextLine();
//		System.out.print("Input First Name : ");
//		String lastName = inputCustomer.nextLine();
//		System.out.print("Input First Name : ");
//		String birthDate = inputCustomer.nextLine();
//		System.out.print("Input First Name : ");
//		String username = inputCustomer.nextLine();
//		System.out.print("Input First Name : ");
//		String password = inputCustomer.nextLine();
//		System.out.print("Input First Name : ");
//		String phoneType = inputCustomer.nextLine();
//		System.out.print("Input First Name : ");
//		String phoneNumber = inputCustomer.nextLine();
		
		//Customer customer1 = new Customer(0, firstName, lastName, dateFormat.parse(birthDate), username, password, phoneType, phoneNumber)
		//connector.insertCustomer(inputcustomer);
		Customer customer1 = new Customer(0, "luqni", "baeq", dateFormat.parse("1988-12-01"), "agung", "garuda45", "symbian", "08123123123");
		connector.insertCustomer(customer1);
		
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
