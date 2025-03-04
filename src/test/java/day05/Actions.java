package day05;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

import java.awt.*;

public class Actions {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= screenSize.width;
        int height = screenSize.height;

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.setViewportSize(width,height);
        page.navigate("https://www.ebay.com");
        page.getByPlaceholder("Search for anything").fill("bicycle");
        Thread.sleep(2000);


        //Enter tuşuna basalım
       // page.getByPlaceholder("Search for anything").press("Enter");

        page.keyboard().press("Enter");
        Thread.sleep(2000);
        page.goBack();

        page.getByText("register").first().click();
        //Birden fazla seçenek varsa first() ilkini, last() sonuncusunu, nth(indexNo) ile elemente ulaşabiliriz
        Thread.sleep(3000);


        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        //page.waitForLoadState(LoadState.LOAD);
        if (page.locator("(//input[@type='checkbox'])[1]").isChecked()){
            System.out.println("checkbox zaten işaretli");
        }else{
            page.locator("(//input[@type='checkbox'])[1]").check();
        }

        if (page.locator("(//input[@type='checkbox'])[2]").isChecked()){
            System.out.println("checkbox2 zaten işaretli");
        }else{
            page.locator("(//input[@type='checkbox'])[2]").check();
        }


        Thread.sleep(3000);







        page.close();
        browser.close();
        playwright.close();

    }
}
