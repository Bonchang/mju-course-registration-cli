
package presentation;

import java.util.Scanner;

import controller.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin {

	public VUserInfo login(Scanner keyboard) {
		System.out.println("===========명지대학교 수강신청 로그인===========");
		System.out.println("1. 로그인  2. 회원가입");
		System.out.print("원하는 항목을 선택하세요: ");
		int Code = keyboard.nextInt();
		if (Code == 1) {
			while (true) {
				System.out.println("===========로그인=========== ");
				System.out.print("ID:  ");
				String userId = keyboard.next();
				System.out.print("PassWord:  ");
				String password = keyboard.next();

				VLogin vLogin = new VLogin();
				vLogin.setUserId(userId);
				vLogin.setPassword(password);

				CLogin cLogin = new CLogin();
				VUserInfo vUserInfo = cLogin.login(vLogin);
				if (vUserInfo == null) {
					System.out.println("Wrong!");
					System.out.println("로그인을 재시도합니다.");
					System.out.println(" ");
				} else {
					System.out.println(vUserInfo.getName() + "님 환영합니다!");
					return vUserInfo;
				}
			}
		}
		if (Code == 2) {
			PSignin pSignin = new PSignin();
			pSignin.run();
		}
		return null;
	}
}
