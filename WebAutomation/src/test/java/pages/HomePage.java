package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class HomePage {
    WebDriver driver;

    @FindBy(css = ".inventory_item")
    List<WebElement> products;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartButton;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addRandomProductToCart() {
        Random rand = new Random();
        WebElement product = products.get(rand.nextInt(products.size()));
        product.findElement(By.tagName("button")).click();
    }

    public void addMultipleProductsToCart(int count) {
        for (int i = 0; i < count && i < products.size(); i++) {
            products.get(i).findElement(By.tagName("button")).click();
        }
    }

    public void goToCart() {
        cartButton.click();
    }

    public void logout() {
        menuButton.click();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        logoutButton.click();
    }
}
