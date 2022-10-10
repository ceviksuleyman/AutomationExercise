package tests.AutoExcercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class TC21 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. 'Ürünler' düğmesine tıklayın
    //4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
    //5. 'Ürünü Görüntüle' düğmesine tıklayın
    //6. 'Yorumunuzu Yazın'ın görünür olduğunu doğrulayın
    //7. Adı, e-posta adresini ve incelemeyi girin
    //8. 'Gönder' düğmesini tıklayın
    //9. 'İncelemeniz için teşekkür ederiz' başarı mesajını doğrulayın.

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase21() {

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //3. 'Ürünler' düğmesine tıklayın
        page.productsButton.click();

        //4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(page.allProductPage.isDisplayed());

        //5. 'Ürünü Görüntüle' düğmesine tıklayın
        int viewProductSize = ReusableMethod.random().nextInt(page.viewProductList.size());
        ReusableMethod.jsScrollClick(page.viewProductList.get(viewProductSize));

        //6. 'Yorumunuzu Yazın'ın görünür olduğunu doğrulayın
        Assert.assertTrue(page.writeYourReview.isDisplayed());

        //7. Adı, e-posta adresini ve incelemeyi girin
        page.writeYourReviewNameBox.sendKeys(ConfigReader.getProperty("autoUserName"));
        page.writeYourReviewEmailBox.sendKeys(ConfigReader.getProperty("autoEmail"));
        page.addReviewHereBox.sendKeys(ReusableMethod.getFaker().random().toString());


        //8. 'Gönder' düğmesini tıklayın
        page.submitReview.click();



        //9. 'İncelemeniz için teşekkür ederiz' başarı mesajını doğrulayın.
        Assert.assertTrue(page.thankYouReview.isDisplayed());


        Driver.closeDriver();
    }
}
