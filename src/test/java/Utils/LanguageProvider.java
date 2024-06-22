package Utils;

import org.testng.annotations.DataProvider;

public class LanguageProvider {

    @DataProvider(name = "languageProvider")
    public Object[][] provideLanguages(){
        return new Object[][] {
                {"ქართული"},
                {"მეგრული"},
                {"სვანური"}
        };
    }
}
