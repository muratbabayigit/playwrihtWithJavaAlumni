import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class P06_pageSelect {
    public static void main(String[] args) throws InterruptedException {
        Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= scrSize.width;
        int height= scrSize.height;
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.setViewportSize(width,height);
        page.navigate("https://testautomationpractice.blogspot.com/");
        page.selectOption("//*[@id='country']","japan");
        Thread.sleep(3500);

        page.close();
        browser.close();playwright.close();


    }
}
