package qu.guru.allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Кликаем по репозиторию {repo}")
    public WebSteps repoClick(){
        $("[href='/selenide/selenide']").click();
        return this;
    }

    @Step("Проверяем текст на кнопке ISUUES")
    public WebSteps checkText(){
        $("#issues-tab").shouldHave(text("Issues"));
        return this;
    }

    @Step("Открываем главную страницу {url}")
    public WebSteps openPage(String url){
        open(url);
        return this;
    }

    @Step("Ищем репозиторий {repo}")
    public WebSteps searchRepository(String repo){
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(repo).pressEnter();
        return this;
    }
}
