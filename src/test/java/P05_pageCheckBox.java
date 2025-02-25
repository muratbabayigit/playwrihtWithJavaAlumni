import com.microsoft.playwright.*;

import java.awt.*;

public class P05_pageCheckBox {
    public static void main(String[] args) throws InterruptedException {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = scrSize.width;
        int height = scrSize.height;

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.setViewportSize(width, height);

        // Sayfayı aç
        page.navigate("https://the-internet.herokuapp.com/checkboxes");

        // İlk checkbox'ı işaretle
        page.check("(//input[@type='checkbox'])[1]");
        Thread.sleep(3000);

        // XPath alırken parantez hatası almış düzelttim*
        page.uncheck("(//input[@type='checkbox'])[2]");

        Thread.sleep(5000);

        // Tarayıcıyı kapat
        page.close();
        browser.close();
        playwright.close();
    }
}
