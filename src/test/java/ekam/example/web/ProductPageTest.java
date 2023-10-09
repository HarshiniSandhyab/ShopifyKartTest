package ekam.example.web;

import com.testvagrant.ekam.testBases.testng.WebTest;

import static com.testvagrant.ekam.commons.LayoutInitiator.*;

import ekam.example.web.pages.MyShopifyHomePage;
import ekam.example.web.pages.MyShopifyProductPage;
import org.testng.annotations.Test;
import io.qameta.allure.TmsLink;

public class ProductPageTest extends WebTest {

    @TmsLink("Test case id")
    @Test(groups = "web", description = "Test case description")
    public void ProductTest() throws InterruptedException {
       Page(MyShopifyHomePage.class).searchItem("shoe");


        // 1. Arrange
        Page(MyShopifyProductPage.class).addAddtionalProduct(3);
        Page(MyShopifyProductPage.class).addToCart();
        Page(MyShopifyProductPage.class).viewingCart();
       //Page(MyShopifyProductPage.class).BuyNow();

        // 2. Act


        // 3. Assert


    }
}