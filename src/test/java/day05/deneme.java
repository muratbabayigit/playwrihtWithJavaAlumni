package day05;


import org.junit.jupiter.api.Test;
import utilities.BaseTest;

public class deneme extends BaseTest {
    @Test
    public void test(){
        page.navigate("http://www.babayigit.net");
        System.out.println(page.title());
    }
}
