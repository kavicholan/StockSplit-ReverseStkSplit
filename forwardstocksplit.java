import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class forwardstocksplit {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ic.drivewealth.io/netIC/acct_profile.aspx");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("ICLogin_UserName")).sendKeys("sbala");
		driver.findElement(By.id("ICLogin_Password")).sendKeys("drvw@clear43");
		driver.findElement(By.id("ICLogin_LoginButton")).click();

		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"ctl00_ICMenun2\"]/table/tbody/tr/td[1]"));
		action.moveToElement(btn).perform();
		driver.findElement(By.xpath("//*[text()='SPLITS & SPIN OFFS']")).click();
		WebElement add = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContentHolder_btnAdd\"]"));
		add.click();

		driver.switchTo().frame("externalSite"); // BY frame name
		WebElement ReOrg = driver.findElement(By.xpath("//select[@name='ddlReorg']"));

		Select se = new Select(ReOrg);
		 //se.selectByValue("S"); // For Stock Split
		se.selectByValue("R"); // For Reverse Stksplit
		driver.findElement(By.xpath("//*[@id=\"txtSec\"]")).sendKeys("ABC", Keys.TAB); //intsymbol
		 driver.findElement(By.xpath("//*[@id=\"txtDt1\"]")).sendKeys("12/21/2022",Keys.TAB); // Enter Effective date
		 driver.findElement(By.xpath("//*[@id=\"txtDt2\"]")).sendKeys("12/23/2022",Keys.TAB); //Enter Posting date
		 driver.findElement(By.xpath("//*[@id=\"txtSec3\"]")).sendKeys("ABC", Keys.TAB); //Split/Stock symbol
		 driver.findElement(By.id("txtQty")).sendKeys("1"); //fromqty
		 driver.findElement(By.id("txtTQty")).sendKeys("1"); //toqty
		driver.findElement(By.id("txtCash")).sendKeys("1"); //cash/sh
		driver.findElement(By.id("txtCil")).sendKeys("1"); //cash in lieu
		driver.findElement(By.id("btnSave")).click(); //save
		  
		 //driver.close();
		 
	}

}
