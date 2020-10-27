import java.util.ArrayList;
import java.util.Scanner;

//메소드에서 return을 활용하면 true, false를 굳이 사용하지 않아도 된다!

public class Grade_test {
	
	static int choice;
	
	public static void main(String[] args) {
		
		Grade obj = new Grade();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			printMenu();
			choice = scan.nextInt();
			
			if(choice == 1) { 
				performInput(obj);
			}
			if(choice == 2) {
				performOutput(obj);
			}
			if(choice == 3) {
				search(obj);
			}
			if(choice == 4) {
				update(obj);
			}
			if(choice == 5) {
				delete(obj);
			}
			if(choice == 6) {
				System.out.println("finished");
				break;
			}
		} // end while(true)
		scan.close();
	}
	
	static void performInput(Grade obj) {
		
		obj.InsertSungjuk();
		
	}
	
	static void performOutput(Grade obj) {
		obj.readGradeSheet();
	}

	static void printMenu() {
		System.out.println("");
		System.out.println("┌───────────성적 관리 안내───────────┐");
		System.out.println("│  1. 성적 정보 입력                 │");
		System.out.println("│  2. 성적 정보 출력                 │");
		System.out.println("│  3. 성적 정보 조회                 │");
		System.out.println("│  4. 성적 정보 수정                 │");
		System.out.println("│  5. 성적 정보 삭제                 │");
		System.out.println("│  6. 프로그램  종료                 │");
		System.out.println("└────────────────────────────────────┘");
		System.out.println("=====> 입력 : ");
	}
	
	static void validateData(ArrayList <Grade> arr) {
	
	}
	
	static void search(Grade obj) {
		obj.searchGradeSheet();
	}
	
	static void update(Grade obj) {
		obj.updateGradeSheet();
	}
	
	static void delete(Grade obj) {
		obj.delete();
	}
}

//하나의 메서드는 하나의 기능만 수행하는 것이 좋다. 
