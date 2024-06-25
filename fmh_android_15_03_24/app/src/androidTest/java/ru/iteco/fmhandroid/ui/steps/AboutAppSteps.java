package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.AboutApplicationPage;

public class AboutAppSteps {
    AboutApplicationPage aboutApp = new AboutApplicationPage();
    public void checkElements() {
        Allure.step("Проверка наличия элементов страницы 'О приложении'");
        aboutApp.backButton.check(matches(isDisplayed()));
        aboutApp.versionNumber.check(matches(isDisplayed()));
        aboutApp.privacyPolicy.check(matches(isDisplayed()));
        aboutApp.termOfUse.check(matches(isDisplayed()));
        aboutApp.companyInfo.check(matches(isDisplayed()));
    }
    public void clickBack() {
        Allure.step("Нажатие на кнопку 'Назад'");
        aboutApp.backButton.perform(click());
    }
}

