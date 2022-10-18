package Final_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Sla_review {
	static WebDriver d;
	@BeforeTest
	public void browserlaunch() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\selinium crome driver\\chromedriver.exe");
		d=new ChromeDriver();
		d.get("https://www.softlogicsys.in/");
		PageFactory.initElements(d,sla_locators.class);
		
	}
	
	@Test(priority = 0,enabled =true)
	public static void traning_dropdown() throws InterruptedException {
		d.manage().window().maximize();
		Thread.sleep(7000);
		
		sla_locators.Traningcourse.click();
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(sla_locators.searchbox));
		sla_locators.searchbox.sendKeys("software testing"+Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(sla_locators.heading));
		sla_locators.heading.click();
		sla_locators.name.sendKeys("nowfil");
		wait.until(ExpectedConditions.visibilityOf(sla_locators.email));
		sla_locators.email.sendKeys("123123@gmail.com");
		wait.until(ExpectedConditions.visibilityOf(sla_locators.comment));
		sla_locators.comment.sendKeys("way of definition is so good ");
		sla_locators.sendComment.click();
		Thread.sleep(3000);
		d.navigate().back();
		d.navigate().back();
		sla_locators.pagenumber.click();
		wait.until(ExpectedConditions.elementToBeClickable(sla_locators.manualtestingdetails));
		sla_locators.manualtestingdetails.click();
		Thread.sleep(3000);
		System.out.println("Class timing and modes of code");
		System.out.println(d.findElement(By.xpath("//*[@id=\"post-2785\"]/div/div/div[1]/div/div/div[3]/div/div/div/div[2]")).getText());
		sla_locators.homekey.click();
	}
	@Test(priority = 1,enabled =true)
	public static void maincourses() throws InterruptedException {
		d.manage().window().maximize();
		
		JavascriptExecutor executor = (JavascriptExecutor) d;
	    executor.executeScript("arguments[0].click();", sla_locators.studentReview);
	    System.out.println("**********************************One of the student Review about Sla institution**********************************");
	    System.out.println("===================================================================================================================");
	    String text= d.findElement(By.xpath("//*[@id=\"post-2160\"]/div/div/div/div/div/div[2]/div/p[3]")).getText();
	    System.out.println(text);
	    sla_locators.homekey.click();
	    executor.executeScript("arguments[0].click();", sla_locators.InterviewQuestion);
	    WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(100));
	   // Thread.sleep(3000);
	    wait.until(ExpectedConditions.elementToBeClickable(sla_locators.cQuestion));
	    sla_locators.cQuestion.click();
	    sla_locators.name.sendKeys("nowfil");
		wait.until(ExpectedConditions.visibilityOf(sla_locators.email));
		sla_locators.email.sendKeys("123123@gmail.com");
		wait.until(ExpectedConditions.visibilityOf(sla_locators.comment));
		sla_locators.comment.sendKeys("way of definition is so good ");
		sla_locators.sendComment.click();
		d.navigate().back();
		d.navigate().back();
		sla_locators.homekey.click();
	   
	}
	@Test(priority = 2,enabled = true)
	public static void company() {
		int i=1;
		int j=1;
		d.manage().window().maximize();
		JavascriptExecutor executor = (JavascriptExecutor) d;
	    executor.executeScript("arguments[0].click();", sla_locators.aboutus);
	    List<WebElement> list=d.findElements(By.xpath("//*[@id=\"post-154\"]/div/div[7]/div/div/div/div[2]/div/ul/li"));
	    System.out.println("Softlogic Principles from Company drop down");
	    System.out.println("===========================================");
	    for (WebElement pricipals : list) {
			System.out.println(i+++")"+pricipals.getText());
		}
	    System.out.println();
	    System.out.println();
	    d.navigate().back();
	    executor.executeScript("arguments[0].click();", sla_locators.whysoftlogic);
	   List<WebElement>List2= d.findElements(By.xpath("//*[@id=\"post-2125\"]/div/div[3]/div[1]/div/div/div/div/ul/li"));
	   System.out.println("softlogic-- credentials");
	    for (WebElement Points : List2) {
	    	
			System.out.println(j+++")"+Points.getText());
		}
	    System.out.println();
	    System.out.println();
	    d.navigate().back();
		
	}
	@Test(priority = 3,enabled =true)
	public void masterPrograms() {
		d.manage().window().maximize();
		JavascriptExecutor executor = (JavascriptExecutor) d;
	    executor.executeScript("arguments[0].click();", sla_locators.diplomacourse);
	    System.out.println("About diplomo course");
	   String about= d.findElement(By.xpath("//*[@id=\"post-7287\"]/div/div[3]/div/div/div/div/div/p[1]")).getText();
	   System.out.println(about);
	   System.out.println();
	   System.out.println();
	}
	@Test(priority = 4)
	public void contact() {
		d.manage().window().maximize();
		sla_locators.Contact.click();
		String contactdetails=d.findElement(By.xpath("//*[@id=\"post-2151\"]/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div/p[1]")).getText();
		System.out.println("Contact details of k.k nager branch");
		System.out.println(contactdetails);
	}
	@AfterTest
	public static void closebrowser() {
		d.quit(); 
	}

}
