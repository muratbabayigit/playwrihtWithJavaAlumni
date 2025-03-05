package utilities;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.awt.*;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    void setup() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.setViewportSize(width, height);
    }

    @AfterEach
    void teardown() {
        browser.close();
        playwright.close();
    }
}
