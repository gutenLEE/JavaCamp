import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// �޼ҵ忡�� return�� Ȱ���ϸ� true, false�� ���� ������� �ʾƵ� �ȴ�!

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
		
		
		// teacher �ߺ� �ڵ� �˻�.
		/*
		 *containKey() Ȱ��
		 if(hashmap.containsKey(grade.studentCode)){
		 	System.out.println("/n �й� �Է� ���� !");
		 	return;
		 }
		 
		 * get key ������ null ���� Ȱ��!
		 if(hashmap.get(grade.studentCode) != null){
		 	System.out.println("�ߺ�");
		 	return;
		 }
		 
		 */
	
		for( String key : hashtable.keySet()) {
			if(grade.studentCode.equals(key)) {
				System.out.println("�ߺ� �й�");
				return; 
			}
		}
		
		System.out.println("�����" + grade.toString());
		hashtable.put(grade.studentCode, grade);
		hashtable.get(grade.studentCode).getGrade();
		Grade.cnt++;
		
	}
	
	static void performOutput(HashMap<String, Grade> hashtable) {
		System.out.println("��� ��� Grade.cnt =>" + Grade.cnt); // ����� �ڵ�
		
		// ����ó��
		 if(hashtable.isEmpty())
			 System.out.println("����� ���� ������ �����ϴ�");
		
		 
	
		 
		System.out.println("����������������������������������������������������������������������***  ����ǥ ***����������������������������������������������������������������������");
		System.out.println("��                                                                                   ��");
		System.out.println("���̸�     �й�       ����      ����      ����        ����         ���       ���   ��");
		System.out.println("��===================================================================================��");
		
		// ȣ��� ������ �ʱ�ȭ 
		Grade.total_avg = 0;
		
		/*
		 
		 * keySet()���� ����ϱ�
		 
		Set<String> keySet = hashtable.keySet();
		Iterator <String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
			
			String key = keyIterator.next();
			Grade grade = hashtable.get(key);
			grade.readGradeSheet();
			Grade.total_avg += grade.avg;
		}
		*/
		
		// values()�� ����ϱ�
		Collection<Grade> valueCollec = hashtable.values();
		// for( String studentCode : hashtable.values()){
		//		hashtable.get(studentCode).readGradeSheet();
		// }
		
		
		 //Iterator()�� ����ϱ� => key ��value�� ������ ���ϴ� ��.
		/*
		Set entrySet = hashtable.entrySet();
		
		if(entrySet.size() == 0){
			sout("no data");
			return;
		}
		
		Iterator it_entry = entrySet.iterator();     =====> ���������� �о� �� �� �ֵ��� iterator() �޼��� ���.
		 
		 while(it_entry.hasNext()){
		 				  ��> e: key, value ��� ����.	
		 		Map.Entry e = (Map.Entry) it_entry.next();      => Map.Entry (Ŭ���� �ȿ� �Ǵٸ� Ŭ���� ������ ��)
		 		Sungjuk obj = (Sungjuk)e.getValue(); : �� �о��
		 		e.getKey(); : Ű �о��
		 }
		*/
		
		for(Grade obj : valueCollec) {
			obj.readGradeSheet();
			Grade.total_avg += obj.avg;
		}
		
		System.out.println();
		System.out.printf("              �� �л� �� : %3d ��     ��ü ��� :  %.2f ��", Grade.cnt, Grade.getTotalAvg());
		
	}

	static void printMenu() {
		System.out.println("");
		System.out.println("���������������������������� ���� �ȳ�������������������������");
		System.out.println("��  1. ���� ���� �Է�                 ��");
		System.out.println("��  2. ���� ���� ���                 ��");
		System.out.println("��  3. ���� ���� ��ȸ                 ��");
		System.out.println("��  4. ���� ���� ����                 ��");
		System.out.println("��  5. ���� ���� ����                 ��");
		System.out.println("��  6. ���α׷�  ����                 ��");
		System.out.println("����������������������������������������������������������������������������");
		System.out.println("=====> �Է� : ");
	}
	
	static void validateData(ArrayList <Grade> arr) {
		// ����� �ڵ�
		System.out.println("Grade.cnt =>" + Grade.cnt);

		for(int i = 0; i < Grade.cnt; i++) {
			// ����� �ڵ�
			System.out.println("arr[i].studentCode =>" + arr.get(i).studentCode);
			System.out.println("arr[Grade.cnt] =>" + arr.get(i).studentCode );
			
			if(arr.get(i).studentCode.contentEquals(arr.get(Grade.cnt).studentCode)) {
				System.out.println("�ߺ� �й� ����");
				arr.remove(Grade.cnt);
				Grade.cnt--;
				return;
			}
		}
		System.out.println("���� ��� ����");
	}
	
	static void search(HashMap<String, Grade> hashtable) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("��ȸ�� �й��� �Է��ϼ��� =>");
		search = scan.next();
		
		
		 
			/*   �������� �ڵ�.
			 Grade obj = hashmap.get(hakbun);
			 if(obj != null){
			 	�Ʒ� ��� ����.
			 }
			 * */ 
		
		hashtable.get(search).searchGradeSheet();
	}
	
	static void update(HashMap<String, Grade> hashtable) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �й��� �Է��ϼ��� =>");
		search = scan.next();
		// if != null ����, else ������ �й� ����. 
		hashtable.get(search).updateGradeSheet();
		hashtable.get(search).getGrade();
		System.out.println("���� �Ϸ�.");
	}
	
	static void delete(HashMap<String, Grade> hashtable) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �й��� �Է��ϼ��� =>");
		search = scan.next();
		
		hashtable.remove(search);
		System.out.println("���� �Ϸ�");

		System.out.println(hashtable.get(search));
//		scan.close();//�ϸ� �� NoSuchElement�� �߻��ϴ°���? => Ű����� �ϳ� �ۿ� ���⶧���� ���α׷����� Ű���� �Է��� close �ع����� �ٽ� ����� �� ����.
		
		
		
		
		
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

// �ϳ��� �޼���� �ϳ��� ��ɸ� �����ϴ� ���� ����. 
