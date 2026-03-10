package presentation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import valueObject.VUserInfo;

public class PDeletebasket {

	public void run(VUserInfo vUserInfo) throws IOException {
        System.out.println("");

		// TODO Auto-generated method stub
		// 파일 경로 설정
		String filePath = "data/basket" + vUserInfo.getName() + ".txt";

		// 파일 객체 생성
		File file = new File(filePath);
		//목록 생성 
		String SinCheong = "data/basket"+vUserInfo.getName()+ ".txt";
		Scanner SinCheongScanner = new Scanner(new File(SinCheong));
		while (SinCheongScanner.hasNext()) {
			
			int ClassCode = SinCheongScanner.nextInt();
			String ClassName = SinCheongScanner.next();
			String ClassProfessor = SinCheongScanner.next();
			int ClassCredit = SinCheongScanner.nextInt();
			String ClassTime = SinCheongScanner.next();
			System.out.println(ClassCode + " " + ClassName + " "
			+ ClassProfessor + " " + ClassCredit + " " + ClassTime);
		}

		// 입력 스트림 생성
		BufferedReader br = new BufferedReader(new FileReader(file));

		// 출력 스트림 생성
		BufferedWriter bw = new BufferedWriter(new FileWriter(file.getName() + ".tmp"));

		// 사용자에게 삭제할 줄 번호 입력 받기
        System.out.println("");
		System.out.print("몇 번째 줄의 강의를 취소하고 싶으신 가요?");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int lineToRemove = Integer.parseInt(reader.readLine());

		// 파일에서 한 줄씩 읽어오기
		String line;
		int lineNumber = 1;
		while ((line = br.readLine()) != null) {
			// 지우려는 줄이 아니라면, 출력 파일에 해당 줄을 쓰기
			if (lineNumber != lineToRemove) {
				bw.write(line + System.getProperty("line.separator"));
			}
			lineNumber++;
		}

		// 입출력 스트림 닫기
		br.close();
		bw.close();

		// 원본 파일 삭제 후 임시 파일 이름을 원본 파일 이름으로 변경
		file.delete();
		File tempFile = new File(file.getName() + ".tmp");
		tempFile.renameTo(file);
		System.out.print("취소되었습니다.");
        System.out.println("");

	}

}
