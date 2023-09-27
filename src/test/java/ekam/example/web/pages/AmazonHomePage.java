package ekam.example.web.pages;

import com.testvagrant.ekam.reports.annotations.WebStep;
import com.testvagrant.ekam.atoms.web.WebPage;
import org.openqa.selenium.By;

public class AmazonHomePage extends WebPage {

    @WebStep(keyword = "When", description = "I hit search button")
    public AmazonHomePage search() {
        return this;
    }

}