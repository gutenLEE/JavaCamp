import java.util.ArrayList;
import java.util.Scanner;

//�޼ҵ忡�� return�� Ȱ���ϸ� true, false�� ���� ������� �ʾƵ� �ȴ�!

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

//�ϳ��� �޼���� �ϳ��� ��ɸ� �����ϴ� ���� ����. 
