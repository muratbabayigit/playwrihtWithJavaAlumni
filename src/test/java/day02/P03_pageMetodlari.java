package day02;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;

public class P03_pageMetodlari {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //setHeadless(true): hiç pencere açmadan testi tamamlar
        //setHeadless(false): browser açarak testi tamamlar
        Page page = browser.newPage();
        page.navigate("https://www.babayigit.net/test");
        page.setViewportSize(width, height);
        Thread.sleep(3000);
        System.out.println(page.title());
        page.navigate("https://www.testotomasyonu.com");
        Thread.sleep(3000);
        System.out.println(page.title());
        page.goBack();
        page.reload();
        Thread.sleep(3000);
        System.out.println(page.title());
        page.goForward();
        Thread.sleep(3000);
        System.out.println(page.title());
        page.goBack();
        page.click("//*[@data-id='login']");
        Thread.sleep(3000);
        System.out.println(page.title());

        page.close();
        browser.close();
        playwright.close();

    }
}
