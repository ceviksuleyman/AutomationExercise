package tests.AutoExcercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class TC17 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    //4. Sepete ürün ekleyin
    //5. 'Sepet' düğmesini tıklayın
    //6. Sepet sayfasının görüntülendiğini doğrulayın
    //7. Belirli bir ürüne karşılık gelen 'X' düğmesini tıklayın
    //8. Ürünün sepetten çıkarıldığını doğrulayın

    AutoExercisePage page = new AutoExercisePage();

    @Test
    public void testCase17() {
        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(page.homePage.isDisplayed());

        //4. Sepete ürün ekleyin
        int product = ReusableMethod.random().nextInt(page.addToCartList.size());
        ReusableMethod.jsScrollClick(page.addToCartList.get(product));

        //5. 'Sepet' düğmesini tıklayın
        page.viewCart.click();

        //6. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(page.cartPage.isDisplayed());

        //7. Belirli bir ürüne karşılık gelen 'X' düğmesini tıklayın
        page.productRemove.click();

        //8. Ürünün sepetten çıkarıldığını doğrulayın
        ReusableMethod.visibilityOfWait(page.cartIsEmpty);
        Assert.assertTrue(page.cartIsEmpty.isDisplayed());


        ReusableMethod.waitFor(1);
        Driver.closeDriver();
    }
}
