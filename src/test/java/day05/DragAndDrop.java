package day05;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= screenSize.width;
        int height = screenSize.height;

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.setViewportSize(width,height);
        page.navigate("https://the-internet.herokuapp.com/drag_and_drop");

        //DragAndDrop
        Thread.sleep(2000);
        page.locator("#column-a").dragTo(page.locator("#column-b"));

        Thread.sleep(2000);

        //manual taşıma
        page.locator("#column-a").hover();
        page.mouse().down();
        page.locator("#column-b").hover();
        page.mouse().up();
        Thread.sleep(2000);



        page.close();browser.close();playwright.close();
    }
}
