package tests.AutoExcercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC13 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    //4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'yi tıklayın
    //5. Ürün detayının açıldığını doğrulayın
    //6. Miktarı 4'e yükseltin
    //7. 'Sepete ekle' düğmesini tıklayın
    //8. 'Sepeti Görüntüle' düğmesini tıklayın
    //9. Ürünün sepet sayfasında tam miktarıyla görüntülendiğini doğrulayın

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase13() throws IOException {

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(page.homePage.isDisplayed());

        //4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'yi tıklayın
        int viewProductSize = ReusableMethod.random().nextInt(page.viewProductList.size());
        ReusableMethod.jsScrollClick(page.viewProductList.get(viewProductSize));

        //5. Ürün detayının açıldığını doğrulayın
        Assert.assertTrue(page.productDetails.isDisplayed());

        //6. Miktarı 4'e yükseltin
        page.productQuantity.click();
        ReusableMethod.waitFor(2);
        page.productQuantity.clear();
        ReusableMethod.waitFor(2);
        page.productQuantity.sendKeys("4");

        //7. 'Sepete ekle' düğmesini tıklayın
        page.addToCartPrdctDtls.click();

        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        page.viewCart.click();

        //9. Ürünün sepet sayfasında tam miktarıyla görüntülendiğini doğrulayın
        System.out.println("Sepetteki Urun Miktari -> " + page.quantityInCart.getText());
        Assert.assertTrue(page.quantityInCart.isDisplayed());
        ReusableMethods.getScreenshotWebElement("SepetUrunDetayi", page.cartDetails); //ekran goruntusu

        Driver.closeDriver();
    }
}
