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
		System.out.println("���������������������������� ���� �ȳ�������������������������");
		System.out.println("��  1. ���� ���� �Է�                 ��");
		System.out.println("��  2. ���� ���� ���                 ��");
		System.out.println("��  3. ���� ���� ��ȸ                 ��");
		System.out.println("��  4. ���� ���� ����                 ��");
		System.out.println("��  5. ���� ���� ����                 ��");
		System.out.println("��  6. ���α׷�  ����                 ��");
		System.out.println("����������������������������������������������������������������������������");
		System.out.println("=====> �Է� : ");
		
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

		System.out.println("����������������������������������������������������������������������***  ����ǥ ***����������������������������������������������������������������������");
		System.out.println("��                                                                                   ��");
		System.out.println("���̸�     �й�       ����      ����      ����        ����         ���       ���   ��");
		System.out.println("��===================================================================================��");
		for(School.Student obj : school.list) {
			obj.printOut();
		}
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf("              �� �л� �� : %3d ��     ��ü ��� :  %.2f ��",num, total_avg);
		System.out.println();
	}

	static void search(School school) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("��ȸ�� �й��� �Է��Ͻÿ� =>");
		String search = scan.next();
		
		for(School.Student obj : school.list) {
			if(obj.hakbun.equals(search)) {
				System.out.printf("����������������������������������������������������������������***  %3s�� ����ǥ ***����������������������������������������������������������������", obj.name);
				System.out.println("��                                                                                   ��");
				System.out.println("���̸�     �й�       ����      ����      ����        ����         ���       ���   ��");
				System.out.println("��===================================================================================��");
				obj.printOut();
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
				break;
			}
		}
		
	} // end search()
	
	static void update(School school) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("������ �й��� �Է��Ͻÿ� =>");
		String search = scan.next();
		
		for(School.Student obj : school.list) {
			if(obj.hakbun.equals(search)) {
				obj.update();
				System.out.printf("����������������������������������������������������������***  ������ %3s�� ����ǥ ***��������������������������������������������������������", obj.name);
				System.out.println("��                                                                                   ��");
				System.out.println("���̸�     �й�       ����      ����      ����        ����         ���       ���   ��");
				System.out.println("��===================================================================================��");
				obj.printOut();
				System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
				break;
			}
		}
	} // end update()
	
	static void delete(School school) {
		int j = 0;
		Scanner scan = new Scanner(System.in);
		System.out.printf("������ �й��� �Է��Ͻÿ� =>");
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
