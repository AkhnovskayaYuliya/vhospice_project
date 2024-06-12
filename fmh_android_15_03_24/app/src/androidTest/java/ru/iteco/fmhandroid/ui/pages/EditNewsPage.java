package ru.iteco.fmhandroid.ui.pages;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;

public class EditNewsPage {
    DataHelper dataHelper = new DataHelper();
    public ViewInteraction pageTitle;
    public ViewInteraction category;
    public ViewInteraction newsTitle;
    public ViewInteraction publicationDate;
    public ViewInteraction okButton;
    public ViewInteraction smallCancelButton;
    public ViewInteraction time;
    public ViewInteraction toggle;
    public ViewInteraction timeError;
    public ViewInteraction manualInputHours;
    public ViewInteraction manualInputMinutes;
    public ViewInteraction description;
    public ViewInteraction switcher;
    public ViewInteraction saveButton;
    public ViewInteraction cancelButton;
    public ViewInteraction errorMessage;

    public EditNewsPage() {
        pageTitle = onView(withId(R.id.custom_app_bar_title_text_view));
        category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        newsTitle = onView(withId(R.id.news_item_title_text_input_edit_text));
        publicationDate = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        okButton = onView(withId(android.R.id.button1));
        smallCancelButton = onView(withId(android.R.id.button2));
        time = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        toggle = onView(allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")),
        withContentDescription("Чтобы ввести время, перейдите в режим ввода текста.")));
        manualInputMinutes = onView(allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                dataHelper.childAtPosition(allOf(withClassName(is("android.widget.RelativeLayout")),
                        dataHelper.childAtPosition(withClassName(is("android.widget.TextInputTimePickerView")), 1)), 3)));
        manualInputHours = onView(allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                dataHelper.childAtPosition(allOf(withClassName(is("android.widget.RelativeLayout")),
                        dataHelper.childAtPosition(withClassName(is("android.widget.TextInputTimePickerView")), 1)), 0)));
        timeError = onView(withText("Указано недопустимое время."));
        description = onView(withId(R.id.news_item_description_text_input_edit_text));
        switcher = onView(withId(R.id.switcher));
        saveButton = onView(withId(R.id.save_button));
        cancelButton = onView(withId(R.id.cancel_button));
        errorMessage = onView(withId(R.id.message));
    }
}
