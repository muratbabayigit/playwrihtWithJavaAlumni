package day03;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P07_elementBilgisiAlma {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= screenSize.width;
        int height= screenSize.height;
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://www.testotomasyonu.com");
      System.out.println(page.textContent(".heading-lg"));
      // Locator topText=page.getByText(" Top Selling Products  ");
      // System.out.println(topText.innerText());

      // System.out.println(page.getByText(" Top Selling Products  "));
        Thread.sleep(4500);
        page.waitForLoadState();
        page.pdf(new Page.PdfOptions().setPath(Paths.get("C:\\Users\\murat\\OneDrive\\Masaüstü\\play\\P07.pdf")));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("C:\\Users\\murat\\OneDrive\\Masaüstü\\play\\P07.png")).setFullPage(true));

        page.click(".menu-icon-text");
        System.out.println(page.innerText("#submitlogin"));
        System.out.println(page.innerHTML("#submitlogin"));
        if (page.isVisible("#submitlogin")){
            System.out.println("Sing In Butonu göründü!");
        }else{
            System.out.println("Sing In Butonu görünmedi!");
        }
        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        if (page.isChecked("(//input[@type='checkbox'])[1]")){
            System.out.println("CheckBox1 Zaten İşaretli");
        }else{
            page.check("(//input[@type='checkbox'])[1]");
            System.out.println("CheckBox1 İşaretlendi");
        }
        if (page.isChecked("(//input[@type='checkbox'])[2]")){
            System.out.println("CheckBox2 Zaten İşaretli");
        }else{
            page.check("(//input[@type='checkbox'])[2]");
            System.out.println("CheckBox2 İşaretlendi");
        }



        page.close();browser.close();playwright.close();
    }
}
