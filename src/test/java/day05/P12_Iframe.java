package day05;

import com.microsoft.playwright.*;

import java.awt.*;

public class P12_Iframe {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= screenSize.width;
        int height = screenSize.height;

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://babayigit.net/test/iframe/");

        //Iframe içine geçiş yapalım
        FrameLocator iframe= page.frameLocator("#testIframe");
        Thread.sleep(2000);
        iframe.locator("body").clear();
        Thread.sleep(2000);
        iframe.locator("body").fill("Ne yaparsan yap AŞK ile yap");
        Thread.sleep(2000);

        System.out.println(page.locator("h1").innerText());

        page.close();browser.close();playwright.close();


    }
}
