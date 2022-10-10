package tests.AutoExcercise;

import io.netty.util.internal.ReflectionUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.security.Key;

public class TC16 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    //4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
    //5. E-postayı, şifreyi doldurun ve 'Giriş' düğmesini tıklayın
    //6. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
    //7. Sepete ürün ekleyin
    //8. 'Sepet' düğmesini tıklayın
    //9. Sepet sayfasının görüntülendiğini doğrulayın
    //10. Ödemeye Devam Et'e tıklayın
    //11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
    //12. Açıklama metin alanına açıklama girin ve 'Sipariş Ver'i tıklayın
    //13. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
    //14. 'Öde ve Siparişi Onayla' düğmesine tıklayın
    //15. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
    //16. 'Hesabı Sil' düğmesini tıklayın
    //17. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase16() {

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(page.homePage.isDisplayed());

        //4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
        page.loginAndSignup.click();

        //5. E-postayı, şifreyi doldurun ve 'Giriş' düğmesini tıklayın
        page.loginEmail.sendKeys(ConfigReader.getProperty("autoEmail"));
        page.loginPassword.sendKeys(ConfigReader.getProperty("autoPassword"));
        page.loginButton.click();

        //6. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        Assert.assertTrue(page.loggedInAs.isDisplayed());

        //7. Sepete ürün ekleyin
        int urunSize = ReusableMethod.random().nextInt(page.addToCartList.size());
        ReusableMethod.jsScrollClick(page.addToCartList.get(urunSize));

        //8. 'Sepet' düğmesini tıklayın
        page.viewCart.click();

        //9. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(page.cartPage.isDisplayed());

        //10. Ödemeye Devam Et'e tıklayın
        page.proceedToCheckout.click();

        //11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        Assert.assertTrue(page.addressDetailsControl.isDisplayed() && page.reviewYourOrder.isDisplayed());

        //12. Açıklama metin alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        page.commentAdd.sendKeys(ReusableMethod.getFaker().random().toString());
        page.placeOrder.click();

        //13. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        //14. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        ReusableMethod.getActions().
                click(page.nameOnCard).sendKeys(ReusableMethod.getFaker().name().fullName()).
                sendKeys(Keys.TAB).
                sendKeys(ReusableMethod.getFaker().number().digits(16)).
                sendKeys(Keys.TAB).
                sendKeys(ReusableMethod.getFaker().number().digits(3)).
                sendKeys(Keys.TAB).
                sendKeys(ReusableMethod.dateMonth()).
                sendKeys(Keys.TAB).
                sendKeys(ReusableMethod.dateYear()).
                sendKeys(Keys.TAB).
                click(page.payAndConfirmOrder).
                perform();

        //15. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        Assert.assertTrue(page.placedSuccessfully.isDisplayed());

        //16. 'Hesabı Sil' düğmesini tıklayın
        //page.deleteAccount.click();

        //17. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

        Driver.closeDriver();
    }
}
