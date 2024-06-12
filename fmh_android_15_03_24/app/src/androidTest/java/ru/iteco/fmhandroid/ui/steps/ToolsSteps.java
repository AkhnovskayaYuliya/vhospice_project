package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.ToolbarPage;

public class ToolsSteps {
    ToolbarPage tools = new ToolbarPage();

    public void exit() {
        Allure.step("Выход из приложения");
        tools.personButton.perform(click());
        tools.exitButton.perform(click());
    }
    public void clickButterfly() {
        Allure.step("Нажатие на кнопку перехода во вкладку 'Главное - жить любя'");
        tools.butterflyButton.perform(click());
    }
    public void clickNavigationButton() {
        Allure.step("Нажатие на кнопку ≡");
        tools.navigationButton.perform(click());
    }
    public void checkButtons() {
        Allure.step("Проверка отображения 'Главная','Новости','О приложении'");
        tools.aboutAppButton.check(matches(isDisplayed()));
        tools.newsButton.check(matches(isDisplayed()));
        tools.mainButton.check(matches(isDisplayed()));
    }
    public void clickNews() {
        Allure.step("Нажатие на 'Новости'");
        tools.newsButton.perform(click());
    }
    public void clickMain() {
        Allure.step("Нажатие на 'Главная страница'");
        tools.mainButton.perform(click());
    }
    public void clickAboutApp() {
        Allure.step("Нажатие на 'О приложении'");
        tools.aboutAppButton.perform(click());
    }

}
