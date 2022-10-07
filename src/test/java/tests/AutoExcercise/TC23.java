package tests.AutoExcercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.List;

public class TC23 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    //4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
    //5. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
    //6. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
    //7. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
    //8. Sepete ürün ekleyin
    //9. 'Sepet' düğmesini tıklayın
    //10. Sepet sayfasının görüntülendiğini doğrulayın
    //11. Ödemeye Devam Et'e tıklayın
    //12. Teslimat adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
    //13. Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
    //14. 'Hesabı Sil' düğmesini tıklayın
    //15. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase23() {


        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));


        ReusableMethod.getSoftAssert().assertTrue(page.homePage.isDisplayed(), "Anasayfa goruntulenemedi");


        ReusableMethod.jsScrollClick(page.loginAndSignIn);


        ReusableMethod.getSoftAssert().assertTrue(page.newUserSignupPage.isDisplayed(), "Yeni Kullanci Kaydi goruntulenemedi");


        page.newUserName.sendKeys("Ayse Can");
        page.newUserEmail.sendKeys(ReusableMethod.getFaker().internet().emailAddress());
        page.signUpButton.click();


        ReusableMethod.getSoftAssert().assertTrue(page.accountInformation.isDisplayed(), "Hesap Bilgilerini Girin goruntulenemedi");


        for (WebElement gender : page.gender) {
            gender.click();
            ReusableMethod.waitFor(2);
        }


        page.passwordNewSignup.sendKeys(ReusableMethod.getFaker().internet().password());


        List<WebElement> days = ReusableMethod.select(page.day).getOptions();
        int index = ReusableMethod.random().nextInt(days.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(days.size());
        }
        ReusableMethod.select(page.day).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.day).getFirstSelectedOption().getText());


        List<WebElement> months = ReusableMethod.select(page.month).getOptions();
        index = ReusableMethod.random().nextInt(months.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(months.size());
        }
        ReusableMethod.select(page.month).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.month).getFirstSelectedOption().getText());


        List<WebElement> years = ReusableMethod.select(page.year).getOptions();
        index = ReusableMethod.random().nextInt(years.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(years.size());
        }
        ReusableMethod.select(page.year).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.year).getFirstSelectedOption().getText());


        ReusableMethod.getActions()
                .click(page.newsLetter).sendKeys(Keys.TAB)
                .click(page.partners).sendKeys(Keys.TAB)
                .sendKeys("Ayse").sendKeys(Keys.TAB)
                .sendKeys("Can").sendKeys(Keys.TAB)
                .sendKeys("Techpro").sendKeys(Keys.TAB)
                .sendKeys("Turkiye/Ankara").sendKeys(Keys.TAB)
                .sendKeys("Turkiye/Istanbul").sendKeys(Keys.TAB).perform();

        List<WebElement> countries = ReusableMethod.select(page.country).getOptions();
        index = ReusableMethod.random().nextInt(countries.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(countries.size());
        }
        ReusableMethod.select(page.country).selectByIndex(index);
        String country = ReusableMethod.select(page.country).getFirstSelectedOption().getText();
        System.out.println(ReusableMethod.select(page.country).getFirstSelectedOption().getText());

        ReusableMethod.jsScroll(page.state);
        ReusableMethod.getActions()
                .click(page.state).sendKeys("Uskudar").sendKeys(Keys.TAB)
                .sendKeys("Istanbul").sendKeys(Keys.TAB)
                .sendKeys(ReusableMethod.getFaker().address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys("9433545455").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        ReusableMethod.getSoftAssert().assertTrue(page.accountCreated.isDisplayed(), "Hesap Olusturuldu goruntulenemedi");


        page.countinue.click();


        ReusableMethod.getSoftAssert().assertTrue(page.loggedInAs.isDisplayed(), "Kullanici adi oturum acti ifadesi gorunmedi");

    }
}
