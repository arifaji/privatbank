package com.sti.privatebank.bisnis;

import java.util.List;
import java.util.Scanner;

import com.sti.privatebank.data.Database;
import com.sti.privatebank.interfaces.MenuCRUD;
import com.sti.privatebank.model.Customer;

public class Search {
	Connector connector = new Database();
	MenuCRUD menuCrud = new MenuCRUD();
	Customer customer = new Customer();
	
	public void searchCustomer(Customer searchCustomer) throws Exception {
	/*	Scanner scan = new Scanner(System.in);
		String uName;
		System.out.println("Cari Data");
		System.out.println("Input Username : ");
		uName = scan.nextLine();
		
		System.out.println("\n\n");
		String sql = "SELECT * FROM customer WHERE username = '"+uName+"'";	
	*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Cari data berdasarkan ID Customer : ");
		int customerNumber = sc.nextInt();
		searchCustomer.setCustomerNumber(customerNumber);
		List<Customer> selectData = connector.getSearch(searchCustomer);
		if (!selectData.isEmpty()){
			for (Customer sch:selectData) {
				System.out.println("Nama Depan: " + sch.getFirstName());
				System.out.println("Nama Belakang: "+ sch.getLastName());
				System.out.println("Tanggal Lahir" + sch.getBirthDate());
				System.out.println("User Name : " + sch.getUsername());
				System.out.println("password : "+ sch.getPassword());
				System.out.println("phone Type" + sch.getPhoneType());
				System.out.println("Phone Number" + sch.getPhoneNumber());
				getBack();
			}	
		} else {
			System.out.println("data was not found");
			getBack();
		}
	}
	public void getBack () throws Exception {
		System.out.println("1. Back to Menu CRUD");
		System.out.println("2. Search Again");
		System.out.print("\nSilahkan masukkan nomor menu : ");
		
		Scanner pilihan = new Scanner(System.in);
		String pilihmenu = pilihan.nextLine();
		
		if (pilihmenu.equals("1")){
			menuCrud.menuCRUD();
			 	
		} else if (pilihmenu.equals("2")){
			 searchCustomer(customer);
			 
		} else {
			 System.out.println("Maaf Pilihan Tidak ada. Silahkan input ulang");
			 getBack();
		}
		
		
	}

}
