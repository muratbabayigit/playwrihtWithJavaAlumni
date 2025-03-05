package day05;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.awt.*;

public class P14_DropDown {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= screenSize.width;
        int height = screenSize.height;

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.setViewportSize(width,height);
        page.navigate("https://www.ebay.com");

        Locator selectCategory=page.getByLabel("Select a category for search");
        Thread.sleep(3000);

        //selectByValue
        selectCategory.selectOption("1");
        Thread.sleep(3000);

        //SelectByLabel
        selectCategory.selectOption(new SelectOption().setLabel("Travel"));
        Thread.sleep(3000);


        page.close();browser.close();playwright.close();

    }
}
