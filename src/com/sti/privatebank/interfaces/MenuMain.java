package com.sti.privatebank.interfaces;

import java.util.Scanner;


public class MenuMain {
	public void menuMain() throws Exception {
		
		MenuCRUD menuCrud = new MenuCRUD();
		
		System.out.print("------------ Daftar  Menu ------------\n");
		System.out.println("1. Account Number");
		System.out.println("0. exit");
		System.out.print("\nSilahkan masukkan nomor menu : ");
		
		Scanner xmnu = new Scanner(System.in);
		String mnu = xmnu.nextLine();
		
		if (mnu.equals("1")){
			 System.out.println("=============== Menu 1 =============== \n ");
			 menuCrud.menuCRUD();
			 
		} else if (mnu.equals("0")){
			 System.out.println("=============== Menu 0 =============== \n ");
			 	
		} else {
			 System.out.println("-------- Menu Tidak Tersedia --------- \n \n");
			 menuMain();
		    }
	}

}
