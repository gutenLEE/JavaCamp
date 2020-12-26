import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jsoup {

	public static void main(String[] args) {
		
		Jsoup selTest = new Jsoup();
        selTest.crawl();

	}


	// WebDriver
	public WebDriver driver;
	
	//properties
	public static final String Web_Driver_id = "webdriver.chrome.driver";
	public static final String Web_Driver_Path = "C:\\JavaTPC\\sw\\chromedriver_win32\\chromedriver.exe";
	
	 //ũ�Ѹ� �� URL
    private String base_url;
    
    public Jsoup() {
    	super();
    	
    	System.setProperty(Web_Driver_id, Web_Driver_Path);
    	
    	this.driver = new ChromeDriver();
    	base_url = "https://finding.eseoul.go.kr/admin/find_list.jsp";
    }
    
    public void crawl() {
    	
    	   try {
               //get page (= ���������� url�� �ּ�â�� ���� �� request �� �Ͱ� ����)
               driver.get(base_url);
               
               String source = driver.getPageSource();
               //System.out.println(source);
               
				
               WebElement pages = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span"));
               List<WebElement> a_tags = pages.findElements(By.className("gray"));	
               
               for(int j = 0; j < 5; j++) {
					for(int i = 0; i < 9; i++) {
						
						System.out.println("i => " + i);
						
						tableCrawl();
						// ������ index�� �ִ� a �±׸� ����
						List<WebElement> web = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span")).findElements(By.className("gray"));
						web.get(i).click();
						
						Thread.sleep(200);
					}
					// ����¡�� ����ϴ� ������ ��ü a �±� ���� -> ��ü a �±׵� �� ������ a�±״� ���� ������ ��ũ
					List<WebElement> web = driver.findElements(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span/a"));
					web.get(web.size() - 1).click();
					System.out.println("=================");
               }
               

           } catch (Exception e) {
               e.printStackTrace();
           } 
    }
    
	// table -> tr Ŭ�� �޼���
	public void tableCrawl() {

		try {
			
			// ���̺� row�� ���ϱ�
			WebElement web = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[2]"));
			List<WebElement> trList = web.findElements(By.xpath("tbody/tr"));
			final int ROWS = trList.size();
			
			
			for(int i = 0; i < ROWS; i++) {
				
				WebElement anchor = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[2]/tbody/tr["+ (i + 1) +"]/td[4]/span/a"));
				anchor.click();
				Thread.sleep(2000);
				
				// ���빰 ũ�Ѹ�
				
				driver.navigate().back();
				//
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(anchor.getText());
		
		// /html/body/form[2]/table/tbody/tr[5]/td/table[2]/tbody/tr[1]/td[4]/span/a
	}
    
}
