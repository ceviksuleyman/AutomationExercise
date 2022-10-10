package tests.AutoExcercise;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class TC08 {
     /*
     1. Tarayıcıyı başlatın
     2. 'http://automationexercise.com' url'sine gidin
     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     4. 'Ürünler' düğmesine tıklayın
     5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
     6. Ürün listesi görünür
     7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
     8. Kullanıcı, ürün detay sayfasına yönlendirilir
     9. Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
     */

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void test08() {

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(page.homePage.isDisplayed());

        //4. 'Ürünler' düğmesine tıklayın
        page.productsButton.click();

        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(page.allProductPage.isDisplayed());

        //6. Ürün listesi görünür
        int count = 1;
        for (WebElement w : page.allProductsList) {

            System.out.println(count + " -> " + w.getText());
            count++;
        }
        //7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        ReusableMethod.jsScrollClick(page.viewProductList.get(0));


        //8. Kullanıcı, ürün detay sayfasına yönlendirilir
        Assert.assertTrue(page.productInformation.isDisplayed());


        //9. Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
        System.out.println("URUN BILGISI");
        //for (WebElement w : page.productInformationList) {
        //    System.out.println(w.getText());
        //}
        System.out.println("Urun Isim -> " + page.productName.getText());
        System.out.println("Urun Kategori -> " + page.productCategory.getText());
        System.out.println("Urun Fiyati -> " + page.productPrice.getText());
        System.out.println("Urun Bulunabilirlik -> " + page.productAvailability.getText());
        System.out.println("Urun Durum -> " + page.productCondition.getText());
        System.out.println("Urun Marka -> " + page.productBrand.getText());

        Assert.assertTrue(page.productName.isDisplayed()
                && page.productCategory.isDisplayed()
                && page.productPrice.isDisplayed()
                && page.productAvailability.isDisplayed()
                && page.productCondition.isDisplayed()
                && page.productBrand.isDisplayed());

        ReusableMethod.waitFor(2);
        Driver.closeDriver();
    }
}
