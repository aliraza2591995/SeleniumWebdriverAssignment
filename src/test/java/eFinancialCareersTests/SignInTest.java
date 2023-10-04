package eFinancialCareersTests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SignInTest extends BaseTest {
    @Test
    public void testSignIn() {
        homepage.clickSignIn();
        assertEquals(homepage.getOverlayText(), "Welcome to your next opportunity", "Didn't clicked signIn button correctly");
        homepage.enterEmail("aliomessi.19@gmail.com");
        homepage.enterPassword("Aliraza.10");
    }
}