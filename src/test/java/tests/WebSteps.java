package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем Github")
    public void openUrl(String url) {
        open(url);
    }

    @Step("Ищем репозиторий и переходим на него")
    public void findRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").pressEnter();
        $(By.linkText(repository)).click();
    }

    @Step("Кликаем на вкладку Issues")
    public void clickOnTab(String tab) {
        $(withText(tab)).click();
    }

    @Step("Проверяем, что issue 65 имеет название 'с днем археолога!'")
    public void checkTitle(String title) {
        $("#issue_65_link").shouldHave(text(title));
    }
}
