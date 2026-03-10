package main;
import java.util.Scanner;

import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;

public class Main {
	//constructor
	public void run() {
		Scanner keyboard = new Scanner(System.in);
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login(keyboard);
		if (vUserInfo != null) {
			PSugangsincheong vSugangsincheong = new PSugangsincheong();
			vSugangsincheong.run(vUserInfo, keyboard);
		}
		keyboard.close();
				
	}
	public static void main(String[] args) {
		//object name declaration
		//memory allocation
		//invoke constructor
		//object name and memory address binding
		Main main = new Main();   //new == create memory
		main.run();
	}
}
