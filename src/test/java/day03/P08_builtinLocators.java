package day03;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.awt.*;

import static com.microsoft.playwright.options.AriaRole.*;

public class P08_builtinLocators {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int width= screenSize.width;
        int height= screenSize.height;
        page.setViewportSize(width,height);
        page.navigate("https://getir.com");
        System.out.println("Site Başlığı: "+page.title());

        //getByText
        Locator loginText=page.getByText("Giriş yap veya kayıt ol");
        System.out.println("1.TEXT: "+loginText.innerText());

        //getByRole
        //Locator loginText2=page.getByRole(HEADING,new Page.GetByRoleOptions().setName("Giriş yap veya kayıt ol"));
        //System.out.println("2.TEXT: "+loginText2.innerText());
        System.out.println("2.TEXT: "+page.textContent("(//*[@data-testid='title'])[2]"));

        //getByPlaceHolder
        page.getByPlaceholder("Telefon Numarası").fill("905882536358");
        Thread.sleep(2000);


        //getBYTestId
        page.getByTestId("button").last().click();
        Thread.sleep(2000);
        Locator errorMessage=page.getByText("Lütfen geçerli bir telefon numarası gir.");
        System.out.println("ErrorMessage:"+errorMessage.innerText());
       //page.getByTestId("button").nth(5).click();
       //Thread.sleep(2000);
        page.locator("x-details", new Page.LocatorOptions().setHasText("Details"))
                .click();

        page.close();browser.close();playwright.close();



    }
}
