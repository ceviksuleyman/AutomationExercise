package tests.AutoExcercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TC24 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    //4. Sepete ürün ekleyin
    //5. 'Sepet' düğmesini tıklayın
    //6. Sepet sayfasının görüntülendiğini doğrulayın
    //7. Ödemeye Devam Et'e tıklayın
    //8. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //9. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
    //10. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
    //11. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
    //12.'Sepet' düğmesini tıklayın
    //13. 'Ödemeye Devam Et' düğmesini tıklayın
    //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
    //15. Yorum metni alanına açıklama girin ve 'Sipariş Ver'i tıklayın
    //16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
    //17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
    //18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
    //19. 'Faturayı İndir' düğmesine tıklayın ve faturanın başarıyla indirildiğini doğrulayın.
    //20. 'Devam' düğmesini tıklayın
    //21. 'Hesabı Sil' düğmesini tıklayın
    //22. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase24() throws IOException {

        //'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //Ana sayfanın başarıyla görünür olduğunu doğrulayın
        ReusableMethod.getSoftAssert().assertTrue(page.homePage.isDisplayed(), "Anasayfa goruntulenemedi");

        //4. Sepete ürün ekleyin
        int urun = ReusableMethod.random().nextInt(page.addToCartList.size());
        while (urun == 0) {

            urun = ReusableMethod.random().nextInt(page.addToCartList.size());
        }
        ReusableMethod.jsScrollClick(page.addToCartList.get(urun));

        //5. 'Sepet' düğmesini tıklayın
        page.viewCart.click();

        //6. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(page.cartPage.isDisplayed());

        //7. Ödemeye Devam Et'e tıklayın
        page.proceedToCheckout.click();

        //8. 'Kaydol / Giriş Yap' düğmesine tıklayın
        page.checkoutRegisterLogin.click();


        //9. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        //10. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        //11. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        page.newUserName.sendKeys("Ayse Can");
        page.newUserEmail.sendKeys(ReusableMethod.getFaker().internet().emailAddress());
        page.signUpButton.click();

        //for (int i = 0; i < exPage.gender.size(); i++) {
        //    exPage.gender.get(i).click();
        //}
        for (WebElement gender : page.gender) {
            gender.click();
            ReusableMethod.waitFor(2);
        }

        page.passwordNewSignup.sendKeys(ReusableMethod.getFaker().internet().password());

        //d
        List<WebElement> days = ReusableMethod.select(page.day).getOptions();
        int index = ReusableMethod.random().nextInt(days.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(days.size());
        }
        ReusableMethod.select(page.day).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.day).getFirstSelectedOption().getText());


        //m
        List<WebElement> months = ReusableMethod.select(page.month).getOptions();
        index = ReusableMethod.random().nextInt(months.size());
        while (index == 0) {
            index = ReusableMethod.random().nextInt(months.size());
        }
        ReusableMethod.select(page.month).selectByIndex(index);
        System.out.println(ReusableMethod.select(page.month).getFirstSelectedOption().getText());


        //y
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
        System.out.println(ReusableMethod.select(page.country).getFirstSelectedOption().getText());
        String country = ReusableMethod.select(page.country).getFirstSelectedOption().getText();

        ReusableMethod.jsScroll(page.state);
        ReusableMethod.getActions()
                .click(page.state).sendKeys("Uskudar").sendKeys(Keys.TAB)
                .sendKeys("Istanbul").sendKeys(Keys.TAB)
                .sendKeys("34").sendKeys(Keys.TAB)
                .sendKeys("1234567899").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        ReusableMethod.getSoftAssert().assertTrue(page.accountCreated.isDisplayed(), "Hesap Olusturuldu goruntulenemedi");

        page.countinue.click();

        ReusableMethod.getSoftAssert().assertTrue(page.loggedInAs.isDisplayed(), "Kullanici adi oturum acti ifadesi gorunmedi");

        //12.'Sepet' düğmesini tıklayın
        page.cartButton.click();

        //13. 'Ödemeye Devam Et' düğmesini tıklayın
        page.proceedToCheckout.click();

        //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        Assert.assertTrue(page.addressDetailsControl.isDisplayed() && page.reviewYourOrder.isDisplayed());

        //15. Yorum metni alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        ReusableMethod.jsScrollClick(page.commentAdd);
        page.commentAdd.sendKeys(ReusableMethod.getFaker().random().toString());
        page.placeOrder.click();


        //16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        page.nameOnCard.sendKeys("Ayse Can");
        page.cardNumber.sendKeys(ReusableMethod.getFaker().number().digits(16));
        page.cvc.sendKeys(ReusableMethod.getFaker().number().digits(3));
        page.expiryMonth.sendKeys(ReusableMethod.dateMonth());
        page.expiryYear.sendKeys(ReusableMethod.dateYear());


        //17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        page.payAndConfirmOrder.click();


        //18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        Assert.assertTrue(page.placedSuccessfully.isDisplayed());


        //19. 'Faturayı İndir' düğmesine tıklayın ve faturanın başarıyla indirildiğini doğrulayın.
        page.downloadInvoice.click();
        ReusableMethod.waitFor(3);
        //1.yol
        Path filePath = Path.of("C:\\Users\\cevik\\Downloads\\invoice.txt");
        String invoice = Files.readString(Path.of(filePath.toString()));
        System.out.println(invoice);
        //2.yol
        String filePaths = "C:\\Users\\cevik\\Downloads\\invoice.txt";
        Assert.assertTrue(Files.exists(Paths.get(filePaths)));


        //20. 'Devam' düğmesini tıklayın
        page.countinue.click();


        //21. 'Hesabı Sil' düğmesini tıklayın
        page.deleteAccount.click();


        //22. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        Assert.assertTrue(page.deleted.isDisplayed());

        Driver.closeDriver();
    }
}
