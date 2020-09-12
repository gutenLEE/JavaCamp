import java.util.Scanner;

public class Grade_test {
	
	// Stack Area [ main, process_input, process_output ] 
	// static Ű���尡 ������ �ڵ����� �޸𸮿� �Ҵ�.
	
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
		// new => Grade Ŭ������ �޸𸮿� �÷���
		// Heap Area [ method Area�� non-static zone �ּҰ� heap Area�� ��ϵȴ�]
		// ���� �ڵ�� method area�� �ִ�.
		// obj ���� heap area�� �Ҵ�� �ּҰ� ����.
		
		arr[Grade.cnt] = new Grade();
		arr[Grade.cnt].createScore();
		validateData(arr);
		arr[Grade.cnt].getGrade();
		Grade.cnt++;
		
	}
	
	static void process_output(Grade arr[]) {
		System.out.println("��� ��� Grade.cnt =>" + Grade.cnt); // ����� �ڵ�
		
		System.out.println("����������������������������������������������������������������������***  ����ǥ ***����������������������������������������������������������������������");
		System.out.println("��                                                                                   ��");
		System.out.println("���̸�     �й�       ����      ����      ����        ����         ���       ���   ��");
		System.out.println("��===================================================================================��");
		
		// ȣ��� ������ �ʱ�ȭ 
		Grade.total_avg = 0;
		
		for(int i = 0; i < Grade.cnt; i++) {
			arr[i].readGradeSheet();
			Grade.total_avg += arr[i].avg;
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
	
	static boolean validateData(Grade arr[]) {
		// ����� �ڵ�
		System.out.println("Grade.cnt =>" + Grade.cnt);

		for(int i = 0; i < Grade.cnt; i++) {
			// ����� �ڵ�
			System.out.println("arr[i].studentCode =>" + arr[i].studentCode);
			System.out.println("arr[Grade.cnt] =>" + arr[Grade.cnt].studentCode );
			
			if(arr[i].studentCode.contentEquals(arr[Grade.cnt].studentCode)) {
				System.out.println("�ߺ� �й� ����");
				return true;
			}
		}
		System.out.println("���� ��� ����");
		return false;
	}
	
	static void search(Grade arr[]) {
		
		boolean F = false;
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("��ȸ�� �й��� �Է��ϼ��� =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			if(arr[i].studentCode.contentEquals(search)) {
				arr[i].searchGradeSheet();
				F = true;
				break; 
			}
		}

		if(F == false)
			System.out.println("�й��� �������� �ʽ��ϴ�.");
	}
	
	static void update(Grade arr[]) {
		
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �й��� �Է��ϼ��� =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			if(arr[i].studentCode.contentEquals(search)) {
				
				arr[i].updateGradeSheet();
				arr[i].getGrade();
				System.out.println("���� �Ϸ�");
				break;
			}
		}
	}
	
	static void delete(Grade arr[]) {
		
		int index = 0;
		String search;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �й��� �Է��ϼ��� =>");
		search = scan.next();
		
		for(int i = 0; i < Grade.cnt; i++) {
			
			System.out.println("���� ��� Grade.cnt =>" + Grade.cnt); // ����� �ڵ�
			
			// find 'studentCode' that user input.
			if(arr[i].studentCode.contentEquals(search)) {
				index = i;
				System.out.println("���� �Ϸ�");
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
