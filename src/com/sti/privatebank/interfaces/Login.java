package com.sti.privatebank.interfaces;

import java.util.Scanner;


public class Login {

public void loginpage() throws Exception {
		
		String username = "admin";
		String password = "admin"; 
		
		MenuMain menumain = new MenuMain();
		
		System.out.print("=========== Silahkan Login =========== \n");
		System.out.print("Username : ");
		Scanner iusr = new Scanner(System.in);
		String usr = iusr.nextLine();
		
		System.out.print("Password : ");
		Scanner ipwd = new Scanner(System.in);
		String pwd = ipwd.nextLine();
		
		if (usr.equals(username) && pwd.equals(password) ){
			System.out.println("=========== Selamat Datang =========== \n ");
			menumain.menuMain();
			System.out.println("======================================= \n ");
		}
		else {
			System.out.println("======================================= \n ");
			System.out.println("------------ Login Gagal ! ------------ \n");
			loginpage();
			System.out.println("======================================= \n ");
		}
		
	}

}
