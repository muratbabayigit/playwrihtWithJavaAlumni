import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class P05_pageCheckBox {

    public static void main(String[] args) throws InterruptedException {
        Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= scrSize.width;
        int height= scrSize.height;
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.setViewportSize(width,height);
        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        page.check("(//*[@type='checkbox'])[1]");
        Thread.sleep(3000);
        //page.mouse().wheel(0,500);
        // page.uncheck("((//*[@type='checkbox'])[2]");

       // page.click("//*[@class='rct-icon rct-icon-uncheck'])[1]");
        Thread.sleep(5000);



        page.close();
        browser.close();
        playwright.close();
    }
}
