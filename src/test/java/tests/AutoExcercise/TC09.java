package tests.AutoExcercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;


public class TC09 {
    /*
      1. Tarayıcıyı başlatın
      2. 'http://automationexercise.com' url'sine gidin
      3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
      4. 'Ürünler' düğmesine tıklayın
      5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
      6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
      7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
      8. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
      */

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase09() {

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(page.homePage.isDisplayed());

        //4. 'Ürünler' düğmesine tıklayın
        page.productsButton.click();

        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(page.allProductPage.isDisplayed());

        //6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        int productListSize = ReusableMethod.random().nextInt(page.allProductsList.size());
        ReusableMethod.getActions()
                .click(page.searchProduct)
                .sendKeys(page.allProductsList.get(productListSize).getText())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        Assert.assertTrue(page.searchedProducts.isDisplayed());


        //8. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
        System.out.println("Aranan URUNLER");
        for (WebElement w : page.searchedProductNames) {

            System.out.println("Aranan URUN -> " + w.getText());

            Assert.assertTrue(w.isDisplayed());
        }

    }
}
