import java.util.Scanner;

public class Grade_test {
	
	// Stack Area [ main, process_input, process_output ] 
	// static 키워드가 붙으면 자동으로 메모리에 할당.
	
	static int Max = 100;
	static int choice;
	
	public static void main(String[] args) {
	
		Grade arr [] = new Grade[Max];
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			printMenu();
			choice = scan.nextInt();
			
			if(choice == 1) { 
				process_input(arr);
			}
			if(choice == 2) {
				process_output(arr);
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
	
	static void process_input(Grade arr[]) {
		// new => Grade 클래스를 메모리에 올려라
		// Heap Area [ method Area의 non-static zone 주소가 heap Area에 기록된다]
		// 기계어 코드는 method area에 있다.
		// obj 에는 heap area에 할당된 주소가 담긴다.
		
		arr[Grade.cnt] = new Grade();
		arr[Grade.cnt].createScore();
		validateData(arr);
		arr[Grade.cnt].getGrade();
		Grade.cnt++;
		
	}
	
	static void process_output(Grade arr[]) {
		System.out.println("출력 블록 Grade.cnt =>" + Grade.cnt); // 디버깅 코드
		
		System.out.println("┌──────────────────────────────────***  성적표 ***──────────────────────────────────┐");
		System.out.println("│                                                                                   │");
		System.out.println("│이름     학번       영어      국어      수학        총점         평균       등급   │");
		System.out.println("│===================================================================================│");
		
		// 호출될 때마다 초기화 
		Grade.total_avg = 0;
		
		for(int i = 0; i < Grade.cnt; i++) {
			arr[i].readGradeSheet();
			Grade.total_avg += arr[i].avg;
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
	
	static boolean validateData(Grade arr[]) {
		// 디버깅 코드
		System.out.println("Grade.cnt =>" + Grade.cnt);

		for(int i = 0; i < Grade.cnt; i++) {
			// 디버깅 코드
			System.out.println("arr[i].studentCode =>" + arr[i].studentCode);
			System.out.println("arr[Grade.cnt] =>" + arr[Grade.cnt].studentCode );
			
			if(arr[i].studentCode.contentEquals(arr[Grade.cnt].studentCode)) {
				System.out.println("중복 학번 존재");
				return true;
			}
		}
		System.out.println("성적 등록 성공");
		return false;
	}
	
	static void search(Grade arr[]) {
		
		boolean F = false;
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("조회할 학번을 입력하세요 =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			if(arr[i].studentCode.contentEquals(search)) {
				arr[i].searchGradeSheet();
				F = true;
				break; 
			}
		}

		if(F == false)
			System.out.println("학번이 존재하지 않습니다.");
	}
	
	static void update(Grade arr[]) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정할 학번을 입력하세요 =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			if(arr[i].studentCode.contentEquals(search)) {
				
				arr[i].updateGradeSheet();
				arr[i].getGrade();
				System.out.println("수정 완료");
				break;
			}
		}
	}
	
	static void delete(Grade arr[]) {
		
		int index = 0;
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 학번을 입력하세요 =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			System.out.println("삭제 블록 Grade.cnt =>" + Grade.cnt); // 디버깅 코드
			
			// find 'studentCode' that user input.
			if(arr[i].studentCode.contentEquals(search)) {
				index = i;
				System.out.println("삭제 완료");
			}
		}
		// after delete, to reorganize the index of array.
		for(int i = index; i < Grade.cnt; i++) {
			arr[i] = arr[i + 1];
		}
		// after one element of array, down the length of array
		Grade.cnt -= 1;
	}
	
}

// 질문 search 변수가 반복적으로 선언되고 있는데 한번만 선언할 수 없나?
