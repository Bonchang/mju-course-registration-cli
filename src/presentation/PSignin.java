package presentation;
import java.io.*;
import java.util.Scanner;

import controller.CFolderRefresh;
import main.Main;

public class PSignin {
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("이름을 입력하세요: ");
            String name = br.readLine();

            // "data" 폴더가 없으면 생성
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdir();
            }

            // sincheong 파일 생성
            String fileName = "data/sincheong" + name + ".txt";
            FileWriter fw = new FileWriter(fileName);
            fw.write("");
            fw.close();
            
            // basket 파일 생성
            String fileName2 = "data/basket" + name + ".txt";
            FileWriter fw2 = new FileWriter(fileName2);
            fw2.write("");
            fw2.close();

            // Account 파일에 추가
            System.out.print("아이디를 입력하세요: ");
            String id = br.readLine();

            System.out.print("비밀번호를 입력하세요: ");
            String pw = br.readLine();

            BufferedWriter bw = new BufferedWriter(new FileWriter("data/Account.txt", true));
            bw.write("\n");
            bw.write(id + " " + pw + " " + name + "\n");
            bw.close();

            System.out.println("가입이 완료되었습니다.");
            CFolderRefresh.refreshFolder(dataDir.getAbsolutePath());
            
            Main main = new Main();
            main.run();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}