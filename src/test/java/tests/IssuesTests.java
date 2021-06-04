package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssuesTests {

    private String GITHUB = "https://github.com",
            REPOSITORY = "eroshenkoam/allure-example",
            ISSUE_TITLE = "Issues",
            ARCHEOLOGY_TITLE = "с днем археолога!";

    @Test
    void checkIssuesNameWith() {
        open(GITHUB);

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $(withText(ISSUE_TITLE)).click();
        $("#issue_65_link").shouldHave(text(ARCHEOLOGY_TITLE));

    }


    @Test
    void checkIssuesNameWithSteps() {

        step("Открываем Github", () -> {
            open(GITHUB);
        });

        step("Ищем репозиторий и переходим на него", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").pressEnter();
            $(By.linkText(REPOSITORY)).click();
        });

        step("Кликаем на вкладку Issues", () -> {
            $(withText(ISSUE_TITLE)).click();
        });

        step("Проверяем, что issue 65 имеет название 'с днем археолога!'", () -> {
            $("#issue_65_link").shouldHave(text(ARCHEOLOGY_TITLE));
        });

    }

}
