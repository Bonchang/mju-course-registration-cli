package presentation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import presentation.PDeletebasket;
import presentation.PCalcredit;
import presentation.PConsoleClock;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {

    private PLectureSelection pLectureSelection;
    private PLectureBasket pMiridamgiBasket;
    private PLectureBasket pSincheongBasket;

    public PSugangsincheong() {
        this.pLectureSelection = new PLectureSelection();
        this.pMiridamgiBasket = new PLectureBasket();
        this.pSincheongBasket = new PLectureBasket();
    }

    public void run(VUserInfo vUserInfo, Scanner keyboard) {

        VLecture vLecture = null;
        boolean bRunning = true;
        System.out.println(" ");

        while (bRunning) {
        	PConsoleClock consoleclock = new PConsoleClock();
    		System.out.println("");
    		consoleclock.run();
    		System.out.println("");
			System.out.println("==============================명지대학교 수강신청 시스템==============================  ");
            System.out.println("1. 강좌선택 2. 미리 담기 3. 수강신청 4. 미리담기 삭제 5. 수강신청 취소 6. 수강학점 조회 0. 종료");
    		System.out.print("원하시는 메뉴의 번호를 입력하세요: ");
            String sCode = keyboard.next();
            int iCode = Integer.parseInt(sCode);

            switch (iCode) {
                //강좌선택 
                case 1:
                    vLecture = this.pLectureSelection.selectLecture(keyboard);
                    System.out.println("미리담기: 1, 수강신청: 2");
                    String sChoice = keyboard.next();
                    int iChoice = Integer.parseInt(sChoice);
                    switch (iChoice) {
                        case 1:
                            pMiridamgiBasket.add(vLecture);
                            pMiridamgiBasket.show();
                            System.out.println("미리담기에 담았습니다. ");
                            // basket.txt에 저장
                            saveBasketToFile(pMiridamgiBasket, "data/basket"+vUserInfo.getName()+ ".txt", true);
                            System.out.println("");
                            break;

                        case 2:
                            pSincheongBasket.add(vLecture);
                            pSincheongBasket.show();
                            saveBasketToFile(pSincheongBasket, "data/sincheong"+vUserInfo.getName()+ ".txt", true);
                            System.out.println("신청되었습니다. ");
                            System.out.println("");
                            break;

                        default:
                            break;
                    }
                    break;
                //미리담기     
                case 2:
                    
                    System.out.println("신청: 1, 확인: 2");
                    String sChoice2 = keyboard.next();
                    int iChoice2 = Integer.parseInt(sChoice2);
                    switch (iChoice2) {
                        case 1:
                        	vLecture = this.pLectureSelection.selectLecture(keyboard);
                            pMiridamgiBasket.add(vLecture);
                            pMiridamgiBasket.show();
                            System.out.println("미리담기에 담았습니다. ");
                            saveBasketToFile(pMiridamgiBasket, "data/basket"+vUserInfo.getName()+ ".txt", false);
                            System.out.println("");
                            break;
                        case 2:
                        	 System.out.println("신청 목록입니다. ");
                             System.out.println("");

                             String fileName = "data/basket" + vUserInfo.getName() + ".txt";

                             try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                                 String line;
                                 while ((line = br.readLine()) != null) {
                                     System.out.println(line);
                                 }
                             } catch (IOException e) {
                                 System.out.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
                             }
                    }

                    break;
                // 수강신청 
                case 3:
                    
                    System.out.println("신청: 1, 확인: 2");
                    String sChoice3 = keyboard.next();
                    int iChoice3 = Integer.parseInt(sChoice3);
                    switch (iChoice3) {
                        case 1:
                        	vLecture = this.pLectureSelection.selectLecture(keyboard);
                            pSincheongBasket.add(vLecture);
                            pSincheongBasket.show();
                            System.out.println("신청되었습니다. ");
                            System.out.println("");
                         // Sincheong.txt에 저장
                            saveBasketToFile(pSincheongBasket, "data/sincheong"+vUserInfo.getName()+ ".txt", false);
                            break;
                        case 2:
                            System.out.println("신청 목록입니다. ");
                            System.out.println("");

                            String fileName = "data/sincheong" + vUserInfo.getName() + ".txt";

                            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                                String line;
                                while ((line = br.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (IOException e) {
                                System.out.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
                            }
                    }
                    break;
                // 미리담기 삭제
                case 4:
                	
                	if (vUserInfo != null) {
        				PDeletebasket pdeletebasket = new PDeletebasket();
        				try {
							pdeletebasket.run(vUserInfo);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        			}
                	
                	
                    break;
                    
                //수강신청 삭제 
                case 5:
                	if (vUserInfo != null) {
        				PDeletelecture pdeletelecture = new PDeletelecture();
        				try {
							pdeletelecture.run(vUserInfo);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        			}
                	break;
                	
                    
                    
                    
                //수강학점 조회 
                case 6:
                	if (vUserInfo != null) {
        				PCalcredit pcalcredit = new PCalcredit();
        				try {
							pcalcredit.run(vUserInfo);
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        			}
                	break;
                //종료
                case 0:
                    System.out.println("--------종료-------- ");
                    bRunning = false;
                    break;

                default:
                	System.out.println("다시 입력하세요. :");
                    break;

            }
        }
    }
    //미리담기 저장 
    private void saveBasketToFile(PLectureBasket basket, String filename, boolean append) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename, append));
            Vector<VLecture> lectureVector = basket.getVLectureVector();
            for (VLecture vLecture : lectureVector) {
                writer.println(vLecture.getCode() + " " + vLecture.getTitle() + " " + vLecture.getLecturer()
                        + " " + vLecture.getCredit() + " " + vLecture.getTime());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 미리담기 불러오기
    private void loadBasketFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            System.out.println("--- 미리담기 내용 ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            System.out.println("-------------------");
        } catch (IOException e) {
            System.out.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
