package presentation;

import java.util.Date;
import java.text.SimpleDateFormat;

public class PConsoleClock {

	public void run() {
		// TODO Auto-generated method stub
		
            // 현재 시간 가져오기
            Date currentTime = new Date();
            
            // 시간을 원하는 형식으로 포맷팅
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            String formattedTime = formatter.format(currentTime);
            
            // 콘솔에 시간 출력

            System.out.print( "현재시간: " + formattedTime);
            
        
		
	}
}

