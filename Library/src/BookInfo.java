import java.util.Scanner;

public class BookInfo extends Book implements Lendable {
	
	String author, company, borrower;
	byte state;
	
	public BookInfo(String bookCode, String title, String author, String company){
		super(bookCode,title);
		this.author = author;
		this.company = company;
		this.state = '0';
		this.borrower = "0";
	}
	
	@Override
	public boolean input() {
		// å �԰�
		Scanner scan = new Scanner(System.in); 
		
		System.out.print("å ���ڵ� �Է� => ");
		bookCode = scan.next();
		if(bookCode.equals("exit"))
			return true;
		
		System.out.print("å ���� => ");
		title = scan.next();
		
		System.out.print("���� => ");
		author = scan.next();
		
		System.out.print("���ǻ� => ");
		company = scan.next();
		
		return false;
	}

	@Override
	public void output() {
		
		System.out.println(bookCode);
		System.out.println(title);
		System.out.println(author);
		System.out.println(company);
		
	}

}
