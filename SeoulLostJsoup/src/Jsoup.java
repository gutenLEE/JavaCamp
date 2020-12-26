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
	
	 //크롤링 할 URL
    private String base_url;
    
    public Jsoup() {
    	super();
    	
    	System.setProperty(Web_Driver_id, Web_Driver_Path);
    	
    	this.driver = new ChromeDriver();
    	base_url = "https://finding.eseoul.go.kr/admin/find_list.jsp";
    }
    
    public void crawl() {
    	
    	   try {
               //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
               driver.get(base_url);
               
               String source = driver.getPageSource();
               //System.out.println(source);
               
				
               WebElement pages = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span"));
               List<WebElement> a_tags = pages.findElements(By.className("gray"));	
               
               for(int j = 0; j < 5; j++) {
					for(int i = 0; i < 9; i++) {
						
						System.out.println("i => " + i);
						
						tableCrawl();
						// 페이지 index가 있는 a 태그만 선택
						List<WebElement> web = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span")).findElements(By.className("gray"));
						web.get(i).click();
						
						Thread.sleep(200);
					}
					// 페이징을 담당하는 구역의 전체 a 태그 선택 -> 전체 a 태그들 중 마지막 a태그는 다음 페이지 링크
					List<WebElement> web = driver.findElements(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span/a"));
					web.get(web.size() - 1).click();
					System.out.println("=================");
               }
               

           } catch (Exception e) {
               e.printStackTrace();
           } 
    }
    
	// table -> tr 클릭 메서드
	public void tableCrawl() {

		try {
			
			// 테이블 row수 구하기
			WebElement web = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[2]"));
			List<WebElement> trList = web.findElements(By.xpath("tbody/tr"));
			final int ROWS = trList.size();
			
			
			for(int i = 0; i < ROWS; i++) {
				
				WebElement anchor = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[2]/tbody/tr["+ (i + 1) +"]/td[4]/span/a"));
				anchor.click();
				Thread.sleep(2000);
				
				// 내용물 크롤링
				
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
