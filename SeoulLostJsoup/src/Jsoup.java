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
						//Thread.sleep(1000);
						//WebElement pages2 = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span"));
						//driver.get(base_url);
						//System.out.println(driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span/a["+ i +"]")).getText());
						
/*						List<WebElement> web = driver.findElements(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span/a"));*/
						
						List<WebElement> web = driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span")).findElements(By.className("gray"));
						web.get(i).click();
						//System.out.println(driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span")).findElements(By.className("gray")));
						//Thread.sleep(200);
						/*
						 * driver.findElement(By.xpath("/html/body/form[2]/table/" +
						 * "tbody/tr[5]/td/table[3]/tbody/" + "tr[3]/td/table/tbody/tr[2]/td/" +
						 * "span/a["+ i +"][@onclick='javascript: navigation("+ i
						 * +"); return false;']")).click();
						 */
						
						
						/*
						 * driver.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]/" +
						 * "td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span/" +
						 * "a[@onclick='navigation("+ i +")']")).click();
						 */
						
						
						//driver.navigate().back();
					}
					List<WebElement> web = driver.findElements(By.xpath("/html/body/form[2]/table/tbody/tr[5]/td/table[3]/tbody/tr[3]/td/table/tbody/tr[2]/td/span/a"));
					web.get(web.size() - 1).click();
					System.out.println("=================");
               }
               
				/*
				 * WebElement web = driver.findElement(By.xpath("/html/body/form[2]"));
				 * WebElement tableElem = web.findElement(By.xpath("/html/body/form[2]/table"));
				 * WebElement trElem =
				 * tableElem.findElement(By.xpath("/html/body/form[2]/table/tbody/tr[5]"));
				 * WebElement elem = trElem.findElement(By.xpath(
				 * "/html/body/form[2]/table/tbody/tr[5]/td/table[2]"));
				 * //System.out.println(elem);
				 * 
				 * 
				 * List<WebElement> elems = elem.findElements(By.className("btl2"));
				 * 
				 * for(WebElement el : elems) {
				 * 
				 * //System.out.println(el.getText()); List<WebElement> cols =
				 * el.findElements(By.tagName("td"));
				 * 
				 * //cols.get(3).click(); //System.out.println(cols.get(3).getText()); }
				 */
               
           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               driver.close();
           }
    }
    
}
