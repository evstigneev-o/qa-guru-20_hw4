package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/*
Разработайте следующий автотест:

 - Откройте страницу Selenide в Github

 - Перейдите в раздел Wiki проекта

 - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions

 - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
 */

public class SoftAssertionsTest {

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        //Configuration.headless = true;

    }

    @Test
    public void SoftAssertionsShouldHaveJUnit5Examples() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("soft");
        $(byText("SoftAssertions")).click();
        $(".markdown-body").$("#user-content-3-using-junit5-extend-test-class").parent().sibling(0).shouldHave(Condition.text("@Test"));
    }
}
