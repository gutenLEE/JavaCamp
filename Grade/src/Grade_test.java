import java.util.ArrayList;
import java.util.Scanner;


// 메소드에서 return을 활용하면 true, false를 굳이 사용하지 않아도 된다!

public class Grade_test {

	
	static int choice;
	
	public static void main(String[] args) {
		
		ArrayList <Grade> arr = new ArrayList<Grade>();
//		Grade arr [] = new Grade[Max];
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			printMenu();
			choice = scan.nextInt();
			
			if(choice == 1) { 
				performInput(arr);
			}
			if(choice == 2) {
				performOutput(arr);
			}
			if(choice == 3) {
				search(arr);
			}
			if(choice == 4) {
				update(arr);
			}
			if(choice == 5) {
				delete(arr);
			}
			if(choice == 6) {
				System.out.println("finished");
				break;
			}
		}
	}
	
	static void performInput(ArrayList <Grade> arr) {

		
		// **중복 시 return하면 이 함수는 return줄 아래로는 수행되지 않는다!!!!**
		arr.add(Grade.cnt, new Grade());
		arr.get(Grade.cnt).createScore();
		validateData(arr);
		arr.get(Grade.cnt).getGrade();
		Grade.cnt++;
		
	}
	
	static void performOutput(ArrayList <Grade> arr) {
		System.out.println("출력 블록 Grade.cnt =>" + Grade.cnt); // 디버깅 코드
		
		// 예외처리
		if(Grade.cnt == 0) {
			System.out.println("출력할 성적 정보가 없습니다");
			return;
		}
		
		System.out.println("┌──────────────────────────────────***  성적표 ***──────────────────────────────────┐");
		System.out.println("│                                                                                   │");
		System.out.println("│이름     학번       영어      국어      수학        총점         평균       등급   │");
		System.out.println("│===================================================================================│");
		
		// 호출될 때마다 초기화 
		Grade.total_avg = 0;
		
		for(int i = 0; i < Grade.cnt; i++) {
			arr.get(i).readGradeSheet();
			Grade.total_avg += arr.get(i).avg;
		}
		System.out.println();
		System.out.printf("              총 학생 수 : %3d 명     전체 평균 :  %.2f 점", Grade.cnt, Grade.getTotalAvg());
		
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
		// 디버깅 코드
		System.out.println("Grade.cnt =>" + Grade.cnt);

		for(int i = 0; i < Grade.cnt; i++) {
			// 디버깅 코드
			System.out.println("arr[i].studentCode =>" + arr.get(i).studentCode);
			System.out.println("arr[Grade.cnt] =>" + arr.get(i).studentCode );
			
			if(arr.get(i).studentCode.contentEquals(arr.get(Grade.cnt).studentCode)) {
				System.out.println("중복 학번 존재");
				arr.remove(Grade.cnt);
				Grade.cnt--;
				return;
			}
		}
		System.out.println("성적 등록 성공");
	}
	
	static void search(ArrayList <Grade> arr) {
		
		boolean F = false;
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("조회할 학번을 입력하세요 =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			if(arr.get(i).studentCode.contentEquals(search)) {
				arr.get(i).searchGradeSheet();
				F = true;
				break; // 여기를 return으로 바꾸면 굳이 true, false를 사용할 필요가 없다!!!
			}
		}
		if(F == false)
			System.out.println("학번이 존재하지 않습니다.");
	}
	
	static void update(ArrayList <Grade> arr) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정할 학번을 입력하세요 =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			if(arr.get(i).studentCode.contentEquals(search)) {
				
				arr.get(i).updateGradeSheet();
				arr.get(i).getGrade();
				System.out.println("수정 완료");
				break;
			}
		}
	}
	
	static void delete(ArrayList <Grade> arr) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 학번을 입력하세요 =>");
		search = scan.next();
		
		arr.remove(search);
		System.out.println("삭제 완료");
		// after one element of array, down the length of array
		Grade.cnt -= 1;
	}
	
}

