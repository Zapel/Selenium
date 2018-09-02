package PageObjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CustomerRegistrationTests extends TestBase {
    @Test
    public void canRegisterCustomer() {
        String email = "adam"+System.currentTimeMillis()+"@smith.me";
        driver.get("http://localhost/litecart/en/create_account");
        driver.findElement(By.name("firstname")).sendKeys("Adam");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("address1")).sendKeys("Hidden Place");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("New City");

        new Select(driver.findElement(By.name("country_code"))).selectByValue("US");

        //wait.until((WebDriver d) -> d.findElement(By.cssSelector("select[name=zone_code] option[value=KS]")));
        new Select (driver.findElement(By.name("zone_code"))).selectByValue("KS");

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div/form/div[6]/div[1]/div/input")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+0123456789");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div/form/div[7]/div[1]/div/input")).sendKeys("qwerty");
        driver.findElement(By.name("confirmed_password")).sendKeys("qwerty");
        driver.findElement(By.name("create_account")).click();
    }
}
