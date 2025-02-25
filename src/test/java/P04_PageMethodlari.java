import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class P04_PageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=screenSize.width;
        int height= screenSize.height;
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(10));
        Page page= browser.newPage();

        page.navigate("https://www.testotomasyonu.com");
        page.fill("//*[@class='search-label']","iphone");
        page.keyboard().press("Enter");
        page.hover("//*[@class='lazy']");
        Thread.sleep(3000);
        //System.out.println(page.title());


        page.close();
        browser.close();
        playwright.close();


    }
}
