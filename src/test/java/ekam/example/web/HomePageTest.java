package ekam.example.web;

import com.testvagrant.ekam.testBases.testng.WebTest;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;

import ekam.example.web.pages.MyShopifyHomePage;
import org.testng.annotations.Test;

public class HomePageTest extends WebTest {

    @Test(groups = "web", description = "Test case description")
    public void shopifyHomeTest() throws InterruptedException {
        //System.out.println("ADC");
        // 1. Arrange
       Page(MyShopifyHomePage.class)
               .searchItem("shoes");

    }
}