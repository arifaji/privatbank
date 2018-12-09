package com.sti.privatebank.bisnis;

import java.util.Scanner;

import com.sti.privatebank.data.Database;
import com.sti.privatebank.interfaces.MenuCRUD;

public class Search {
	Connector connector = new Database();
	MenuCRUD menuCrud = new MenuCRUD();
	
	public void searchCustomer() {
		Scanner scan = new Scanner(System.in);
		String uName;
		System.out.println("Cari Data");
		System.out.println("Input Username : ");
		uName = scan.nextLine();
		
		System.out.println("\n\n");
		String sql = "SELECT * FROM customer WHERE username = '"+uName+"'";
		

	}

}
