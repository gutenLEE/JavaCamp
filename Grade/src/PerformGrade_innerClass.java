import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class PerformGrade_innerClass {

	public static void main(String[] args) {
		
		School school = new School();
		
		while(true) {
			
			int choice = printMenu();
			
			if(choice == 1) { 
				inputSchool(school);
			}
			if(choice == 2) {
				printSchool(school);
			}
			if(choice == 3) {
				search(school);
			}
			if(choice == 4) {
				update(school);
			}
			if(choice == 5) {
				delete(school);
			}
			if(choice == 6) {
				System.out.println("finished");
				break;
			}
		} // end while(true)
		
	}

	static int printMenu() {
		
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
		
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		return choice;
	}
	
	static void inputSchool(School school) {
		school.addInfo();
	}
	
	static void printSchool(School school) {
		
		int num = school.getStudentNum();
		double total_avg = school.getTotalAvg();

		System.out.println("┌──────────────────────────────────***  성적표 ***──────────────────────────────────┐");
		System.out.println("│                                                                                   │");
		System.out.println("│이름     학번       영어      국어      수학        총점         평균       등급   │");
		System.out.println("│===================================================================================│");
		for(School.Student obj : school.list) {
			obj.printOut();
		}
		System.out.println("└───────────────────────────────────────────────────────────────────────────────────┘");
		System.out.printf("              총 학생 수 : %3d 명     전체 평균 :  %.2f 점",num, total_avg);
		System.out.println();
	}

	static void search(School school) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("조회할 학번을 입력하시오 =>");
		String search = scan.next();
		
		for(School.Student obj : school.list) {
			if(obj.hakbun.equals(search)) {
				System.out.printf("┌───────────────────────────────***  %3s의 성적표 ***───────────────────────────────┐", obj.name);
				System.out.println("│                                                                                   │");
				System.out.println("│이름     학번       영어      국어      수학        총점         평균       등급   │");
				System.out.println("│===================================================================================│");
				obj.printOut();
				System.out.println("└───────────────────────────────────────────────────────────────────────────────────┘");
				break;
			}
		}
		
	} // end search()
	
	static void update(School school) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("수정할 학번을 입력하시오 =>");
		String search = scan.next();
		
		for(School.Student obj : school.list) {
			if(obj.hakbun.equals(search)) {
				obj.update();
				System.out.printf("┌────────────────────────────***  수정된 %3s의 성적표 ***───────────────────────────┐", obj.name);
				System.out.println("│                                                                                   │");
				System.out.println("│이름     학번       영어      국어      수학        총점         평균       등급   │");
				System.out.println("│===================================================================================│");
				obj.printOut();
				System.out.println("└───────────────────────────────────────────────────────────────────────────────────┘");
				break;
			}
		}
	} // end update()
	
	static void delete(School school) {
		int j = 0;
		Scanner scan = new Scanner(System.in);
		System.out.printf("삭제할 학번을 입력하시오 =>");
		String search = scan.next();
		
		for(School.Student obj : school.list) {
			if(obj.hakbun.equals(search)) {
				school.removeInfo(j);
				break;
			}
			j++;
		}
	}
}
