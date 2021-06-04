package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("IssuesTests")
public class IssuesTests {

    WebSteps steps = new WebSteps();

    private String GITHUB = "https://github.com",
            REPOSITORY = "eroshenkoam/allure-example",
            ISSUE_TITLE = "Issues",
            ARCHEOLOGY_TITLE = "с днем археолога!";

    @Test
    @Story("Проверка текста с простым Selenide")
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
    @Story("Проверка текста через лямбда степы")
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

    @Test
    @Story("Проверка текста через анотации step")
    void checkIssuesNameWithAnnotations() {
        steps.openUrl(GITHUB);
        steps.findRepository(REPOSITORY);
        steps.clickOnTab(ISSUE_TITLE);
        steps.checkTitle(ARCHEOLOGY_TITLE);
    }

}
