package tests.AutoExcercise;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC12 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    //4. 'Ürünler' düğmesini tıklayın
    //5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
    //6. 'Alışverişe Devam Et' düğmesini tıklayın
    //7. Fareyi ikinci ürünün üzerine getirin ve 'Sepete ekle'yi tıklayın
    //8. 'Sepeti Görüntüle' düğmesini tıklayın
    //9. Her iki ürünün de Sepete eklendiğini doğrulayın
    //10. Fiyatlarını, miktarını ve toplam fiyatını doğrulayın

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase12() throws IOException {
        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(page.homePage.isDisplayed());

        //4. 'Ürünler' düğmesini tıklayın
        page.productsButton.click();

        //5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın

        //ReusableMethod.jsScroll(page.firstProduct);
        //ReusableMethod.waitFor(2);
        ReusableMethod.getActions().moveToElement(page.firstProduct).perform();
        page.firstProductAddToCart.click();


        //6. 'Alışverişe Devam Et' düğmesini tıklayın
        ReusableMethod.waitFor(2);
        page.continueShopping.click();


        //7. Fareyi ikinci ürünün üzerine getirin ve 'Sepete ekle'yi tıklayın

        //ReusableMethod.jsScroll(page.firstProduct);
        //ReusableMethod.waitFor(2);
        ReusableMethod.getActions().moveToElement(page.secondProduct).perform();
        page.secondProductAddToCart.click();


        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        ReusableMethod.waitFor(2);
        page.viewCart.click();

        //9. Her iki ürünün de Sepete eklendiğini doğrulayın
        Assert.assertTrue(page.cartDetails.isDisplayed());
        ReusableMethods.getScreenshotWebElement("firstAndSecondProductInCart", page.cartDetails);


        //10. Fiyatlarını, miktarını ve toplam fiyatını doğrulayın
        System.out.println("urun 1 fiyat -> " + page.firstProductPrice.getText());
        System.out.println("urun 1 miktar -> " + page.firstProductQuantity.getText());
        System.out.println("urun 1 toplam fiyat -> " + page.firstProductTotalPrice.getText());
        System.out.println("urun 2 fiyat -> " + page.secondProductPrice.getText());
        System.out.println("urun 2 miktar -> " + page.secondProductQuantity.getText());
        System.out.println("urun 2 toplam fiyat -> " + page.secondProductTotalPrice.getText());

        Assert.assertTrue(page.firstProductPrice.isDisplayed()
                && page.firstProductQuantity.isDisplayed()
                && page.firstProductTotalPrice.isDisplayed()
                && page.secondProductPrice.isDisplayed()
                && page.secondProductQuantity.isDisplayed()
                && page.secondProductTotalPrice.isDisplayed());


        Driver.closeDriver();
    }
}
