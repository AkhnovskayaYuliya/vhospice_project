package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupWindow;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class FilterPage {
    public ViewInteraction pageTitle;
    public ViewInteraction inputCategory;
    public ViewInteraction categoryList;
    public ViewInteraction dateFirst;
    public ViewInteraction dateSecond;
    public ViewInteraction smallCancelButton;
    public ViewInteraction okButton;
    public ViewInteraction filterButton;
    public ViewInteraction cancelButton;
    public ViewInteraction activeCheckBox;
    public ViewInteraction inactiveCheckBox;
    public ViewInteraction errorDate;

    public FilterPage() {
        pageTitle = onView(allOf(withId(R.id.filter_news_title_text_view), withText("Фильтровать новости")));
        categoryList = onView(allOf(withId(R.id.text_input_end_icon), withContentDescription("Показать раскрывающееся меню")));
        dateFirst = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
        dateSecond = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
        smallCancelButton = onView(withId(android.R.id.button2));
        okButton = onView(withId(android.R.id.button1));
        filterButton = onView(withId(R.id.filter_button));
        cancelButton = onView(withId(R.id.cancel_button));
        activeCheckBox = onView(withId(R.id.filter_news_active_material_check_box));
        inactiveCheckBox = onView(withId(R.id.filter_news_inactive_material_check_box));
        inputCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        errorDate = onView(withId(android.R.id.message));
    }

}
