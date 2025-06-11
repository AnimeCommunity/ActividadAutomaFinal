package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


import java.util.List;

public class CartPage {
    WebDriver driver;

    @FindBy(css = ".cart_item")
    List<WebElement> cartItems;

    @FindBy(css = ".cart_button")
    List<WebElement> removeButtons;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeAllItems() {
        for (WebElement btn : removeButtons) {
            btn.click();
        }
    }

    public int getItemCount() {
        return cartItems.size();
    }

    public void clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
