package tests.AutoExcercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class TC06 {
       /*
      1. Tarayıcıyı başlatın
      2. 'http://automationexercise.com' url'sine gidin
      3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
      4. 'Bize Ulaşın' düğmesine tıklayın
      5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
      6. Adı, e-posta adresini, konuyu ve mesajı girin
      7. Dosya yükle
      8. 'Gönder' düğmesini tıklayın
      9. Tamam düğmesine tıklayın
      10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
      11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
    */

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase06() {
        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(page.homePage.isDisplayed());

        //4. 'Bize Ulaşın' düğmesine tıklayın
        page.contactUsButton.click();

        //5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        Assert.assertTrue(page.getInTouch.isDisplayed());

        //6. Adı, e-posta adresini, konuyu ve mesajı girin
        page.contactUsNameBox.sendKeys(ConfigReader.getProperty("autoUserName"));
        page.contactUsEmailBox.sendKeys(ConfigReader.getProperty("autoEmail"));
        page.contactUsSubjectBox.sendKeys(ReusableMethod.getFaker().toString().toLowerCase());
        page.contactUsMessageBox.sendKeys(ReusableMethod.getFaker().toString());

        //7. Dosya yükle
        page.uploadFile.sendKeys("C:\\Users\\cevik\\IdeaProjects\\AutoExerciseTestNG\\src\\resources\\redCar.png");

        //8. 'Gönder' düğmesini tıklayın
        page.contactUsSubmit.click();

        //9. Tamam düğmesine tıklayın
        Driver.getDriver().switchTo().alert().accept();

        //10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        Assert.assertTrue(page.submittedSuccessfullyMessage.isDisplayed());

        //11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        page.returnHomePage.click();
        Assert.assertTrue(page.homePage.isDisplayed());

        ReusableMethod.waitFor(2);
        Driver.closeDriver();
    }
}
