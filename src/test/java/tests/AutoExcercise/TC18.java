package tests.AutoExcercise;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseCross;

public class TC18 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' url'sine gidin
    //3. Sol taraftaki çubukta kategorilerin görünür olduğunu doğrulayın
    //4. 'Kadınlar' kategorisine tıklayın
    //5. 'Kadınlar' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
    //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - ÜST ÜRÜNLER' metnini onaylayın
    //7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
    //8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın

    AutoExercisePage page;

    @Test
    public void testCase18() {

        page = new AutoExercisePage();

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("exerciseUrl"));


        //3. Sol taraftaki çubukta kategorilerin görünür olduğunu doğrulayın
        Assert.assertTrue(page.category.isDisplayed());

        //4. 'Kadınlar' kategorisine tıklayın
        ReusableMethod.jsScrollClick(page.womenCategory);

        //5. 'Kadınlar' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
        int womenCategory = ReusableMethod.random().nextInt(page.womenCategoryList.size());
        ReusableMethod.jsScrollClick(page.womenCategoryList.get(womenCategory));

        //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - ÜST ÜRÜNLER' metnini onaylayın
        Assert.assertTrue(page.womenProducts.isDisplayed());

        //7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        page.menCategory.click();


        int menCategory = ReusableMethod.random().nextInt(page.menCategoryList.size());
        ReusableMethod.jsScrollClick(page.menCategoryList.get(menCategory));


        //8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın
        Assert.assertTrue(page.menProducts.isDisplayed());


        Driver.closeDriver();
    }
}
