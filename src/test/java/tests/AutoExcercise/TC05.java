package tests.AutoExcercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class TC05 {

     /*
      1. Tarayıcıyı başlatın
      2. 'http://automationexercise.com' url'sine gidin
      3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
      4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
      5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
      6. Adı ve kayıtlı e-posta adresini girin
      7. 'Kaydol' düğmesini tıklayın
      8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
     */

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase05() {

        //'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.homePage.isDisplayed(), "Anasayfa goruntulenemedi");

        //'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        page.loginAndSignup.click();

        //'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Assert.assertTrue(page.newUserSignup.isDisplayed());

        //Adı ve kayıtlı e-posta adresini girin
        page.newUserName.sendKeys(ConfigReader.getProperty("autoUserName"));
        page.newUserEmail.sendKeys(ConfigReader.getProperty("autoEmail"));

        //'Kaydol' düğmesini tıklayın
        page.signUpButton.click();

        //'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
        Assert.assertTrue(page.emailAlreadyExist.isDisplayed());

        Driver.closeDriver();
    }
}
