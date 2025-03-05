package day06;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;

import java.util.List;

public class P17_MultipleWindow extends BaseTest {
    @Test
    public void tets(){
        page.navigate("https://demoqa.com/browser-windows");
        page.waitForLoadState(LoadState.LOAD);

        Page popup=page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
                p-> p.context().pages().size()==2),()->{page.getByText("New Window").first().click();});

        List<Page>pages=popup.context().pages();
        System.out.println(popup.title());
        System.out.println(page.title());
        System.out.println(pages.size());

    }


}
