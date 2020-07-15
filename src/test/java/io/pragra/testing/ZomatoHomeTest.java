package io.pragra.testing;

import com.sun.deploy.security.SelectableSecurityManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.awt.windows.ThemeReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ZomatoHomeTest {
    WebDriver webDriver;

    @Parameters("browser")
    @BeforeSuite
    public void setUp(String browser){
        if(browser.equalsIgnoreCase("CHROME")){
            System.setProperty("webdriver.chrome.driver","C:/Users/sukhp/Downloads/chromedriver_win32/chromedriver.exe");
            webDriver = new ChromeDriver();
//            webDriver.get("https://zoom.us");
//        }
//        else if(browser.equalsIgnoreCase("FIREFOX")){
//            System.setProperty("webdriver.gecko.driver","C:/Users/sukhp/Downloads/geckodriver-v0.26.0-win64/geckodriver.exe");
//        webDriver= new FirefoxDriver();
       }
    }

    @Parameters("siteUrl")
    @BeforeTest
    public void setUp2(String url) {
        webDriver.get(url);
    }

//    @Test
//    public void testSample() throws InterruptedException {
//        String title = webDriver.getTitle();
//        System.out.println(title);
////        Assert.assertTrue(title.contains("NCR"));
////        WebElement community = webDriver.findElement(By.cssSelector("div[name='For Foodies']>nav>a:nth-child(2)"));
////        community.click();
//
//        Thread.sleep(3000);
////        System.out.println(webDriver.getCurrentUrl());
////        Assert.assertEquals("https://community.zomato.com/",webDriver.getCurrentUrl());
//        WebElement elm = webDriver.findElement(By.xpath("//div[@class ='searchContainer']//input[contains(@placeholder,'cuisine')]"));
//        elm.sendKeys("Momos");
//        Thread.sleep(2000);
//        elm.clear();
//        elm.sendKeys("Dal makhani");
////        System.out.println(elm.getAttribute("class"));
////        System.out.println(elm.getCssValue("font-family"));
//
//        WebElement elm1 = webDriver.findElement(By.xpath("//div[@class='searchContainer']//i[2]"));
//        elm1.click();
//        Thread.sleep(2000);
//
//        WebElement elm2 = webDriver.findElement(By.xpath("//div [@class='searchContainer']//div[@aria-label ='search button']"));
//        Thread.sleep(2000);
//        elm2.click();
//
//        //(JavascriptExecutor) webDriver).executeScript("$(arguement[0]).hide()",elm);
//   }
//

//    @Test
//    public void homeTest() throws InterruptedException {
//        //webDriver.get("https://semantic-ui.com/modules/dropdown.html");
//        //WebElement country = webDriver.findElement(By.xpath("//select[@id='country']"));
//        webDriver.get("https://pragra.co/sel.html");
////        WebElement cars = webDriver.findElement(By.xpath("//select[@name='cars']"));
////      Select select = new Select(cars);
////
////
////        if(select.isMultiple()){
////            System.out.println("Yes it is");
//
//        WebElement chcbx = webDriver.findElement(By.xpath("//input[@type='checkbox' and @value ='java']"));
//       // Select select = new Select(chcbx);
//       if(!chcbx.isSelected()){
//           chcbx.click();
//       }
//       Thread.sleep(5000);
//
//
//        }

    @Test(enabled = false)
    public void test() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.findElement(By.id("truste-consent-button")).click();

        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).pause(1000).click(webDriver.findElement(By.linkText("Contact Sales"))).build().perform();
        Thread.sleep(3000);
    }
    @Test(enabled = false)
    public void homeTest1() throws InterruptedException {
        webDriver.findElement(By.xpath("//div[@aria-labelledby='country-dropdown-label']")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.id("country-uk")).click();
        Thread.sleep(5000);
        //webDriver.findElement(By.xpath("//div[@class ='states-container']//a[@href ='https://www.zomato.com/london']")).click();
        webDriver.findElement(By.xpath("//a[contains(@href,'london')]")).click();
        WebElement hh = webDriver.findElement(By.xpath("//a[contains(@href,'london')]"));
        WebElement search = webDriver.findElement(By.xpath("//div[@class='searchContainer']//input[contains(@placeholder,'cuisine')]"));
        Thread.sleep(5000);
        search.sendKeys("Noodles");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//div[@aria-label='search button']")).click();
        String web = webDriver.getCurrentUrl();
        System.out.println(web);
//       String web1= search.getAttribute("class");
//        System.out.println(web1);
//        hh.sendKeys("manchester");
//        hh.click();
    }
    @Test
    public void advanceActions() throws InterruptedException, IOException {
//        webDriver.navigate().to("https://www.cn.ca/en/");
//        WebElement industryLink = webDriver.findElement(By.id("ctl06__17a25f08a1f01b_repMainNav_topLevelLink_0"));
//        WebElement grain = webDriver.findElement(By.id("ctl06__17a25f08a1f01b_repMainNav_repSecondLevel_0_secondLevelLink_6"));
//        WebElement grainplan = webDriver.findElement(By.id("ctl06__17a25f08a1f01b_repMainNav_repSecondLevel_0_repThirdLevel_6_thirdLevelLink_0"));
       Actions actions = new Actions(webDriver);
       webDriver.navigate().to("https://pragra.co/sel.html");
       webDriver.manage().window().maximize();
       WebElement dclickButton = webDriver.findElement(By.id("dblclik"));
       Thread.sleep(5000);
        ((JavascriptExecutor) webDriver).executeScript("window.scroll(0,200);");

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();",dclickButton);
       actions.doubleClick(dclickButton).build().perform();
       Thread.sleep(5000);

       webDriver.switchTo().alert().accept();
       Thread.sleep(5000);

       WebElement draggable = webDriver.findElement(By.id("draggable"));
       WebElement droppable = webDriver.findElement(By.id("droppable"));

        System.out.println(draggable.getText());

       actions.dragAndDrop(draggable,droppable).build().perform();
       File screenshot = droppable.getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Paths.get("screen.png"));



       //webDriver.switchTo().alert().dismiss();
//        actions.moveToElement(industryLink).pause(2000).moveToElement(grain).pause(2000).moveToElement(grainplan).click().build().perform();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        webDriver.quit();
    }
}
