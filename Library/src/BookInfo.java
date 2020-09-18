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
		// 책 입고
		Scanner scan = new Scanner(System.in); 
		
		System.out.print("책 바코드 입력 => ");
		bookCode = scan.next();
		if(bookCode.equals("exit"))
			return true;
		
		System.out.print("책 제목 => ");
		title = scan.next();
		
		System.out.print("저자 => ");
		author = scan.next();
		
		System.out.print("출판사 => ");
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
