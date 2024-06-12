package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutApplicationPage {
    public ViewInteraction backButton;
    public ViewInteraction versionNumber;
    public ViewInteraction privacyPolicy;
    public ViewInteraction termOfUse;
    public ViewInteraction companyInfo;

    public AboutApplicationPage() {
        backButton = onView(withId(R.id.about_back_image_button));
        versionNumber = onView(withId(R.id.about_version_value_text_view));
        privacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
        termOfUse = onView(withId(R.id.about_terms_of_use_value_text_view));
        companyInfo = onView(withId(R.id.about_company_info_label_text_view));
    }
}
