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

    @Test
    void checkIssuesName() {

         step("Открываем Github", () -> {
             open("https://github.com");
                 });

        step("Ищем репозиторий и переходим на него", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").pressEnter();
            $(By.linkText("eroshenkoam/allure-example")).click();
                });

        step("Кликаем на вкладку Issues", () -> {
            $(withText("Issues")).click();
                });

        step("Проверяем, что issue 65 имеет название 'с днем археолога!'", () -> {
            $("#issue_65_link").shouldHave(text("с днем археолога!"));
                });

    }

}
