package tests.AutoExcercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseCross;

public class TC19 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. 'Ürünler' düğmesine tıklayın
    //4. Markaların sol taraftaki çubukta göründüğünü doğrulayın
    //5. Herhangi bir marka adına tıklayın
    //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın
    //7. Sol taraftaki çubukta başka bir marka bağlantısına tıklayın
    //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın

    AutoExercisePage page;

    @Test
    public void testCase19() {

        page = new AutoExercisePage();

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));


        //3. 'Ürünler' düğmesine tıklayın
        page.productsButton.click();

        //4. Markaların sol taraftaki çubukta göründüğünü doğrulayın
        Assert.assertTrue(page.brands.isDisplayed());

        //5. Herhangi bir marka adına tıklayın
        int brand = ReusableMethod.random().nextInt(page.brandNamesList.size());
        ReusableMethod.jsScrollClick(page.brandNamesList.get(brand));


        //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın
        Assert.assertTrue(page.brandProductPage.isDisplayed());


        //7. Sol taraftaki çubukta başka bir marka bağlantısına tıklayın
        int brand2 = ReusableMethod.random().nextInt(page.brandNamesList.size());
        page.brandNamesList.remove(brand); // sonraki secimde ayni markayi secmemesi icin
        ReusableMethod.jsScrollClick(page.brandNamesList.get(brand2));


        //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın
        Assert.assertTrue(page.brandProductPage.isDisplayed());


        Driver.closeDriver();
    }
}
