package day03;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.awt.*;

public class P09_OtherLocators {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();

        Dimension scr=Toolkit.getDefaultToolkit().getScreenSize();
        int width= scr.width;
        int height=scr.height;
        page.setViewportSize(width,height);
        page.navigate("https://getir.com");
        System.out.println(page.title()+"\n");
        page.waitForLoadState(LoadState.LOAD);


        //CSS : matching by text
        //1-has-text
        Locator loginText=page.locator("h5:has-text('Giriş yap veya kayıt ol')");
        System.out.println("1.Text Yöntemi: "+loginText.innerText());

        //2-text
        System.out.println("1.Text Yöntemi: "+page.locator("h5:text('Giriş yap veya kayıt ol')").innerText());

        //CSS : elements matching
        Locator loginButton= page.locator("button:has-text('Telefon numarası ile devam et'),button:has-text('login button')");
        System.out.println(loginButton.innerText());

        //Locator LoginBox =page.locator(":nth-match(:text('Giriş Yap'),1");
        Locator LoginBox =page.locator("(//button[@type='button'])[5]");
        Locator LoginBox2 =page.locator("(//button[@type='button'])").nth(4);
        System.out.println(LoginBox.innerText());
        System.out.println(LoginBox2.innerText());





        page.close();browser.close();playwright.close();
    }



}
