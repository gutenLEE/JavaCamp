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
	

	public void checkOut(String borrower) {
		
		this.state = '1';
		this.borrower = borrower;
	
		System.out.printf("대출완료 : [ %6s ] [ %6s ] \n",title, author);
	}
	
	public void checkIn(String borrower) {
		
		this.state = '0';
		this.borrower = "0";
		
		System.out.printf("반납완료 : [ %6s ] [ %6s ] \\n", title, author);
	}
	
	@Override
	public void output() {
		
		System.out.printf(" %3s         %8s          %5s          %5s \n", bookCode, title, author, company);
		
	}
	public void output(byte state) {
		System.out.printf(" %3s         %8s          %5s          %5s        %5s \n", 
																bookCode, title, author, company, borrower);
	}


}
		