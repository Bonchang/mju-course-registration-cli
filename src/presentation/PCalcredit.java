package presentation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.Main;
import valueObject.VUserInfo;

public class PCalcredit {

	public void run(VUserInfo vUserInfo) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 File file = new File("data/sincheong"+vUserInfo.getName()+ ".txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));

	        String line;
	        int sum = 0;
	        while ((line = br.readLine()) != null) {
	            String[] arr = line.split(" ");
	            sum += Integer.parseInt(arr[3]);
	        }

	        System.out.println("신청하신 과목들의 학점은 총 " + sum + "입니다.");
	        br.close();
	}

}
