package com.sti.privatebank.interfaces;

import java.util.Scanner;

import com.sti.privatebank.bisnis.Create;
import com.sti.privatebank.bisnis.Delete;
import com.sti.privatebank.bisnis.Update;
import com.sti.privatebank.bisnis.View;

public class MenuCRUD {
	public void menuCRUD () throws Exception {
		
		MenuMain menumain = new MenuMain();
		View menuView = new View();
		Create menuCreate = new Create();
		Update menuUpdate = new Update();
		Delete menuDelete = new Delete();
		
		System.out.println("1. Input Data Customer");
		System.out.println("2. View Data Customer");
		System.out.println("3. Update Data Customer");
		System.out.println("4. Delete Data Customer");
		System.out.println("0. Back to Main Menu");
		System.out.print("\nSilahkan masukkan nomor menu : ");
		
		Scanner pilihan = new Scanner(System.in);
		String pilihmenu = pilihan.nextLine();
		
		if (pilihmenu.equals("1")){
			 System.out.println("============= Input Data ============= \n ");
			 menuCreate.createCustomer();
			 	
		} else if (pilihmenu.equals("2")){
			 System.out.println("============= View Data ============== \n ");
			 menuView.viewCustomer();
			 
		} else if (pilihmenu.equals("3")){
			 System.out.println("============ Upate Data ============ \n ");
			 menuUpdate.updateCustomer();
			 //menuCRUD();
			 
		} else if (pilihmenu.equals("4")){
			 System.out.println("============ Delete Data ============ \n ");
			 menuDelete.deleteCustomer();
		
		} else if (pilihmenu.equals("0")){
			System.out.println("====================================== \n ");			
			menumain.menuMain();
			 	
		} else {
			 System.out.println("--------- Menu Tidak Tersedia -------- \n");
			 menuCRUD();
		}
	}
}
