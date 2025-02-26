package day01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P01_firstTest {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage(); // Seleniumdaki eşdeğeri driver
            page.navigate("https://www.testotomasyonu.com");
            System.out.println(page.title() + "\n" + page.url());


        }
    }
}