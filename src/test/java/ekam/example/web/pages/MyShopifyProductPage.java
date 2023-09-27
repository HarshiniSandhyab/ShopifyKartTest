package ekam.example.web.pages;

import com.testvagrant.ekam.reports.annotations.WebStep;
import com.testvagrant.ekam.atoms.web.WebPage;
import org.openqa.selenium.By;

public class MyShopifyProductPage extends WebPage {

    private By plusButton = query("//button[@name='plus']");

    private By minusButton = queryByName("minus");
    private By addToCartButton = query("//button[@name='add']");
    private By BuyNowButton = queryByText("Buy it now");
    private By InCart = query("//span[text()=\"Cart\"]");
    private By totalInCart = query("//div[@class=\"cart-count-bubble\"]/span[1]");


    @WebStep(keyword = "When", description = "I hit search button")
    public MyShopifyProductPage addAddtionalProduct(int total) throws InterruptedException {
        for (int i = 0; i < total; i++) {
            Thread.sleep(3000);
            element(plusButton).click();
            }
            return this;
    }
//    @WebStep(keyword = "When", description = "I click on minus icon")
//    public MyShopifyProductPage removeExcessProduct(int total) {
//        for (int i = 0; i < total; i++) {
//            element(minusButton).click();
//        }
//        return this;
//    }
//public MyShopifyProductPage addToCart() {
//    element(addToCartButton).click();
//    return this;
//
//}

    public MyShopifyProductPage BuyNow() throws InterruptedException {
        element(BuyNowButton).waitUntilDisplayed().click();
        Thread.sleep(3000);
        return this;
    }
}



