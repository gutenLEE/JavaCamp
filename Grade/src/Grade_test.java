import java.util.ArrayList;
import java.util.Scanner;


// �޼ҵ忡�� return�� Ȱ���ϸ� true, false�� ���� ������� �ʾƵ� �ȴ�!

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

		
		// **�ߺ� �� return�ϸ� �� �Լ��� return�� �Ʒ��δ� ������� �ʴ´�!!!!**
		arr.add(Grade.cnt, new Grade());
		arr.get(Grade.cnt).createScore();
		validateData(arr);
		arr.get(Grade.cnt).getGrade();
		Grade.cnt++;
		
	}
	
	static void performOutput(ArrayList <Grade> arr) {
		System.out.println("��� ��� Grade.cnt =>" + Grade.cnt); // ����� �ڵ�
		
		// ����ó��
		if(Grade.cnt == 0) {
			System.out.println("����� ���� ������ �����ϴ�");
			return;
		}
		
		System.out.println("����������������������������������������������������������������������***  ����ǥ ***����������������������������������������������������������������������");
		System.out.println("��                                                                                   ��");
		System.out.println("���̸�     �й�       ����      ����      ����        ����         ���       ���   ��");
		System.out.println("��===================================================================================��");
		
		// ȣ��� ������ �ʱ�ȭ 
		Grade.total_avg = 0;
		
		for(int i = 0; i < Grade.cnt; i++) {
			arr.get(i).readGradeSheet();
			Grade.total_avg += arr.get(i).avg;
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
	
	static void search(ArrayList <Grade> arr) {
		
		boolean F = false;
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("��ȸ�� �й��� �Է��ϼ��� =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			if(arr.get(i).studentCode.contentEquals(search)) {
				arr.get(i).searchGradeSheet();
				F = true;
				break; // ���⸦ return���� �ٲٸ� ���� true, false�� ����� �ʿ䰡 ����!!!
			}
		}
		if(F == false)
			System.out.println("�й��� �������� �ʽ��ϴ�.");
	}
	
	static void update(ArrayList <Grade> arr) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �й��� �Է��ϼ��� =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			if(arr.get(i).studentCode.contentEquals(search)) {
				
				arr.get(i).updateGradeSheet();
				arr.get(i).getGrade();
				System.out.println("���� �Ϸ�");
				break;
			}
		}
	}
	
	static void delete(ArrayList <Grade> arr) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �й��� �Է��ϼ��� =>");
		search = scan.next();
		
		arr.remove(search);
		System.out.println("���� �Ϸ�");
		// after one element of array, down the length of array
		Grade.cnt -= 1;
	}
	
}

