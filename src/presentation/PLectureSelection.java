package presentation;

import java.util.Scanner;
import java.util.Vector;

import controller.CIndex;
import controller.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;

public class PLectureSelection {
	private CIndex cIndex;
	private CLecture cLecture;
	
	public PLectureSelection() {
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();

	}
	
	public String findIndexFileName(String message, String parentFileName, Scanner keyboard) {
	    // get IndexVector
	    Vector<VIndex> vIndexVector = cIndex.getIndexVector(parentFileName);

	    // select index
	    System.out.println(message + "코드 입력: ");
	    for (VIndex vIndex: vIndexVector) {
	    	vIndex.show();
	    }
	    String sCode = keyboard.next();
	    int iCode = Integer.parseInt(sCode);
	  

	    // code search
	    int selection = iCode - vIndexVector.get(0).getCode();
	    String fileName = vIndexVector.get(selection).getFileName();
	    System.out.println(fileName);
	    
	    return fileName;
	}
	private VLecture findLecture(String fileName, Scanner keyboard) {
		//get IndexVector
		Vector<VLecture> vLectureVector = cLecture.getLectureVector(fileName);
		
		//select index
		System.out.println("강좌 코드 입력: ");
		for (VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		
		//code search
		int selection = 0 ;
		VLecture vLecture = vLectureVector.get(selection);
		return vLecture;
	}
	public VLecture selectLecture(Scanner keyboard) {
		String campusFileName = this.findIndexFileName("캠퍼스","root",keyboard );
		String collegeFileName = this.findIndexFileName("대학",campusFileName ,keyboard );
		String departmentFileName = this.findIndexFileName("학과",collegeFileName ,keyboard );
		VLecture vLecture =  this.findLecture(departmentFileName, keyboard);
		
		return vLecture;
	}
}
