package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.BaseLoginPage;

public class BaseClass {

	public static WebDriver driver;
	public org.apache.logging.log4j.Logger logger; // Log4j
	public Properties p;

	@BeforeClass
	@Parameters({ "browser" })
	public void setup(String br) throws InterruptedException, IOException {

		logger = LogManager.getLogger(this.getClass());

		// reading property File
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		switch (br.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=C:\\Users\\91865\\AppData\\Local\\Google\\Chrome\\User Data");
			driver = new ChromeDriver(options);

		}

		// error landing page to delete cookies
		driver.get(p.getProperty("appErrorUrl")); // reading value of URL from properties files
		driver.manage().deleteAllCookies();

		// login to app
		driver.get(p.getProperty("appCorrectUrl")); // reading URL from properties files
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		BaseLoginPage blp = new BaseLoginPage(driver);
		blp.clickGoogleOption();
		Thread.sleep(10);
		blp.clickEmailAddress();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		

		//sourceFile.renameTo(targetFile);
		FileUtils.copyFile(sourceFile, new File(targetFilePath));
		return targetFilePath;

	}

}
