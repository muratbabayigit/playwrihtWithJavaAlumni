import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import utilities.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AutomationExerciseSignUp extends BaseTest {
@Test
    public void Test() throws InterruptedException {
    Faker faker=new Faker();
    page.navigate("https://automationexercise.com/");
    page.getByText(" Signup / Login").click();
    page.getByPlaceholder("Name").fill(faker.name().fullName());
    page.getByPlaceholder("Email Address").nth(1).fill(faker.internet().emailAddress());
    page.locator("(//button[@type='submit'])[2]").click();

    page.locator("#id_gender1").click();
    page.locator("#password").fill(faker.internet().password(8,15,true,true,true));
    page.selectOption("#days","5");
    page.selectOption("#months","May");
    page.selectOption("#years","1980");
    page.locator("#newsletter").check();
    page.locator("#first_name").fill(faker.name().firstName());
    page.locator("#last_name").fill(faker.name().lastName());
    page.locator("#address1").fill(faker.address().fullAddress());
    page.selectOption("#country","Canada");
    page.locator("#state").fill(faker.address().state());
    page.locator("#city").fill(faker.address().city());
    page.locator("#zipcode").fill(faker.address().zipCode());
    page.locator("#mobile_number").fill(""+faker.phoneNumber());
    page.getByText("Create Account").click();
   // Locator onayText=page.getByText("Account Created!");
   // Assertions.assertEquals("ACCOUNT CREATED!",onayText.innerText());
    Assertions.assertEquals("ACCOUNT CREATED!",page.getByText("Account Created!").innerText());

    assertThat(page.getByText("Account Created!")).containsText("Created");
    Thread.sleep(2500);





}
}
