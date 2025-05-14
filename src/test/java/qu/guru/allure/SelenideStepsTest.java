package qu.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideStepsTest {

    private static final String REPOSITORY = "selenide";
    private static final String baseUrl = "https://github.com/";

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск ISUUES на странице репозитория")
    @Owner("Kolyshkin A.S.")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://github.com/")
    @DisplayName("Проверка корректного отображения текста в ISSUES / Лямбда шаги через step")
    void IssuesLambdaStepsTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу", () -> {
            open(baseUrl);
        } );

        step("Ищем репозитрий " + REPOSITORY, ()->{
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем по репозиторию " + REPOSITORY, ()->{
            $("[href='/selenide/selenide']").click();
        });

        step("Проверяем название кпопки ISUUES", ()->{
            $("#issues-tab").shouldHave(text("Issues"));
        });

    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск ISUUES на странице репозитория")
    @Owner("Kolyshkin A.S.")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://github.com/")
    @DisplayName("Проверка корректного отображения текста в ISSUES / Чистый Selenide (с Listener)")
    void IssuesTest(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        open(baseUrl);
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        $("[href='/selenide/selenide']").click();
        $("#issues-tab").shouldHave(text("Issues"));
    }


    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Isuue")
    @Owner("Kolyshkin A.S.")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "test", url = "https://github.com/")
    @DisplayName("Проверка корректного отображения текста в ISSUES / Шаги с аннотацией")
    void githubTestWithWebSteps(){

        WebSteps webSteps = new WebSteps();

        webSteps.openPage(baseUrl)
                .searchRepository(REPOSITORY)
                .repoClick()
                .checkText();
    }
}
