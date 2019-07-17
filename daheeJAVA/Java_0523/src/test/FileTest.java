package test;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		
		File f = new File("C:\\myJava\\pen.jpg");
		
		//존재하고 있는지 확인 boolean타입 반환
		// ! 논리부정을 붙여서 존재하고 있지않다면 출력 있다면 다음코드로 넘어감
		if(!f.exists()) {
			System.out.println("저장하신 폴더에 파일이 존재하지 않습니다.");
			return;
		}
		//경로이름 출력
		System.out.println(f.getAbsolutePath());
		
		//파일 이동
		File reDir = new File("C:\\yourJava");
		//파일이동할 폴더가 없으면 폴더 생성 있으면 그냥 넘어감
		reDir.mkdir();
		
		//파일생성
		//File(파일생성할 경로, "파일이름")
		File newFile = new File(reDir, "myBin.jpg");
		
		//파일이동 f파일을 newFile에 설정한 경로와 새로운 이름으로 생성된다.
		f.renameTo(newFile);
		
		//newFile
		if(newFile.exists()) {
			System.out.println("이동 성공");
		} else {
			System.out.println("이동 실패");
		}
	}

}
