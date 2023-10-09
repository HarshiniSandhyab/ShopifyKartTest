package ekam.example.web.pages;

import com.testvagrant.ekam.reports.annotations.WebStep;
import com.testvagrant.ekam.atoms.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyShopifyHomePage extends WebPage {
    private By homeLink = queryByText("Home");
    private By catalogLink = queryByText("Catalog");
    private By contactLink = queryByText("Contact");

    private By searchLink = queryByClass(".modal__toggle-open.icon.icon-search");

    private By setSearch = queryByClass(".search__input.field__input");

    private By allLinks = queryByClass("predictive-search__item-content");


    @WebStep(keyword = "When", description = "I hit home link")
    public MyShopifyHomePage homeLink() {
        element(homeLink).click();
        return this;
    }

    @WebStep(keyword = "When", description = "I hit catalog link")
    public MyShopifyHomePage catalogLink() {
        element(catalogLink).click();
        String title = driver.getTitle();
        System.out.println("title after clicking catalog link is" + title);
        return this;
    }

    @WebStep(keyword = "When", description = "I hit contact link")
    public MyShopifyHomePage contactLink() {
        element(contactLink).click();
        return this;
    }

    @WebStep(keyword = "When", description = "I hit search link")
    public MyShopifyHomePage searchItem(String text) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchLinkelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[local-name()='svg' and @class=\"modal__toggle-open icon icon-search\"]")));
        searchLinkelement.click();
        WebElement textbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"Search-In-Modal\"]")));
        textbox.sendKeys(text);
        Thread.sleep(3000);
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//ul[@id = 'predictive-search-results-list']//li"));
        int totalSuggestions = allSuggestions.size();
        System.out.println(totalSuggestions);
        for (int i = 0; i < totalSuggestions; i++) {
            //Thread.sleep(3000);
            try {
                WebDriverWait toWait = new WebDriverWait(driver, 10);
                WebElement elementToClick = toWait.until(ExpectedConditions.elementToBeClickable(allSuggestions.get(i)));
                elementToClick.click();
            } catch (Exception e) {
               // System.out.println("Encountered StaleElementReferenceException. Retrying...");
                driver.findElements(By.xpath("//ul[@id = 'predictive-search-results-list']//li"));
                totalSuggestions=allSuggestions.size();
            }
//            WebDriverWait toWait = new WebDriverWait(driver, 10);
//            WebElement elementToClick = toWait.until(ExpectedConditions.elementToBeClickable(allSuggestions.get(i)));
            //elementToClick.click();
        }

            //System.out.println("total items are "+allSuggestions.get(i).getText());
            //}
            return this;


    }
}

       // System.out.println("size is"+listSize);
        //WebElement firstElement=driver.findElement(By.xpath("//li[@id=\"predictive-search-option-1\"]"));
        //firstElement.click();
        /*for(int i=0;i<listSize;i++)
        {
            System.out.println();
        }*/

         //System.out.println(allData);
       //for (WebElement allSuggestions : allData)
           //System.out.println(allSuggestions.getText());
        //WebElement allSuggestions = driver.findElement(By.xpath("//div[@id='predictive-search-results']/ul"));
        //div[@id='predictive-search-results']/ul
        /*List<WebElement> listOfSuggestions = allsugg.findElements(By.tagName("li"));
             for (WebElement listOfSuggestion : listOfSuggestions) {
                 System.out.println(listOfSuggestion.getText());
             }

        System.out.println(listOfSuggestions);*/
        //allsugg.get(0).click();
//        for(int i=0;i<elementCollection(allLinks).count();i++)
//        {
//            //System.out.println(elementCollection(allLinks).count());
//            elementCollection(allLinks).get().get(0).click();
//            String title=driver.getTitle();
//            System.out.println("title after clicking one the first option is"+title);
//        }
