import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// 메소드에서 return을 활용하면 true, false를 굳이 사용하지 않아도 된다!

public class Grade_hash {
	
	static int choice;
	
	public static void main(String[] args) {
		
		HashMap<String, Grade> hashtable = new HashMap<String, Grade>();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			
			printMenu();
			choice = scan.nextInt();
			
			if(choice == 1) { 
				performInput(hashtable);
			}
			else if(choice == 2) {
				performOutput(hashtable);
			}
			else if(choice == 3) {
				search(hashtable);
			}
			else if(choice == 4) {
				update(hashtable);
			}
			else if(choice == 5) {
				delete(hashtable);
			}
			else if(choice == 6) {
				System.out.println("finished");
				break;
			}
		} // end while(true)
	}
	
	static void performInput(HashMap<String, Grade> hashtable) {
		
		Grade grade = new Grade();
		grade.createScore();
		
		
		// teacher 중복 코드 검사.
		/*
		 *containKey() 활용
		 if(hashmap.containsKey(grade.studentCode)){
		 	System.out.println("/n 학번 입력 오류 !");
		 	return;
		 }
		 
		 * get key 없을때 null 리턴 활용!
		 if(hashmap.get(grade.studentCode) != null){
		 	System.out.println("중복");
		 	return;
		 }
		 
		 */
	
		for( String key : hashtable.keySet()) {
			if(grade.studentCode.equals(key)) {
				System.out.println("중복 학번");
				return; 
			}
		}
		
		System.out.println("디버깅" + grade.toString());
		hashtable.put(grade.studentCode, grade);
		hashtable.get(grade.studentCode).getGrade();
		Grade.cnt++;
		
	}
	
	static void performOutput(HashMap<String, Grade> hashtable) {
		System.out.println("출력 블록 Grade.cnt =>" + Grade.cnt); // 디버깅 코드
		
		// 예외처리
		 if(hashtable.isEmpty())
			 System.out.println("출력할 성적 정보가 없습니다");
		
		 
	
		 
		System.out.println("┌──────────────────────────────────***  성적표 ***──────────────────────────────────┐");
		System.out.println("│                                                                                   │");
		System.out.println("│이름     학번       영어      국어      수학        총점         평균       등급   │");
		System.out.println("│===================================================================================│");
		
		// 호출될 때마다 초기화 
		Grade.total_avg = 0;
		
		/*
		 
		 * keySet()으로 출력하기
		 
		Set<String> keySet = hashtable.keySet();
		Iterator <String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
			
			String key = keyIterator.next();
			Grade grade = hashtable.get(key);
			grade.readGradeSheet();
			Grade.total_avg += grade.avg;
		}
		*/
		
		// values()로 출력하기
		Collection<Grade> valueCollec = hashtable.values();
		// for( String studentCode : hashtable.values()){
		//		hashtable.get(studentCode).readGradeSheet();
		// }
		
		
		 //Iterator()로 출력하기 => key 와value를 쌍으로 구하는 것.
		/*
		Set entrySet = hashtable.entrySet();
		
		if(entrySet.size() == 0){
			sout("no data");
			return;
		}
		
		Iterator it_entry = entrySet.iterator();     =====> 순차적으로 읽어 올 수 있도록 iterator() 메서드 사용.
		 
		 while(it_entry.hasNext()){
		 				  ┌> e: key, value 들어 있음.	
		 		Map.Entry e = (Map.Entry) it_entry.next();      => Map.Entry (클래스 안에 또다른 클래스 정의할 때)
		 		Sungjuk obj = (Sungjuk)e.getValue(); : 값 읽어옴
		 		e.getKey(); : 키 읽어옴
		 }
		*/
		
		for(Grade obj : valueCollec) {
			obj.readGradeSheet();
			Grade.total_avg += obj.avg;
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
	
	static void search(HashMap<String, Grade> hashtable) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("조회할 학번을 입력하세요 =>");
		search = scan.next();
		
		
		 
			/*   선생님의 코드.
			 Grade obj = hashmap.get(hakbun);
			 if(obj != null){
			 	아래 출력 진행.
			 }
			 * */ 
		
		hashtable.get(search).searchGradeSheet();
	}
	
	static void update(HashMap<String, Grade> hashtable) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정할 학번을 입력하세요 =>");
		search = scan.next();
		// if != null 수정, else 수정할 학번 없음. 
		hashtable.get(search).updateGradeSheet();
		hashtable.get(search).getGrade();
		System.out.println("수정 완료.");
	}
	
	static void delete(HashMap<String, Grade> hashtable) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 학번을 입력하세요 =>");
		search = scan.next();
		
		hashtable.remove(search);
		System.out.println("삭제 완료");

		
		// scan.close(); 하면 왜 NoSuchElement가 발생하는거지?
		
		
		
		
		
//		arr.remove(search); => Unlikely argument type String for remove(Object) on a Collection<Grade>
		
		
		/*
		 public boolean remove(Object o)
			Removes the first occurrence of the specified element from this list, if it is present. 
			If the list does not contain the element, it is unchanged. 
			More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). 
			Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
			Specified by:
			remove in interface Collection<E>
			Specified by:
			remove in interface List<E>
			Overrides:
			remove in class AbstractCollection<E>
			Parameters:
			o - element to be removed from this list, if present
			Returns:
			true if this list contained the specified element
		 */
	}
}

// 하나의 메서드는 하나의 기능만 수행하는 것이 좋다. 
