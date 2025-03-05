package day06;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;

import java.nio.file.Paths;

public class P18_ScreenShot extends BaseTest {
@Test
    public void screenshotTest() throws InterruptedException {
    page.navigate("https://www.babayigit.net");
    Thread.sleep(2000);

    //TümSayfanın fotosunu alma
    String dosyaYolu="src/test/java/utilities/1.png";
    String dosyaYolu2="src/test/java/utilities/2.png";
    String dosyaYolu3="src/test/java/utilities/3.png";
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(dosyaYolu)).setFullPage(true));
    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(dosyaYolu2)));

    Locator object=page.locator("//*[text()='Wise Quarter']");
    object.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(dosyaYolu3)));

}
}
