package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;


import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;

public class NewsPage {
    DataHelper dataHelper = new DataHelper();
    public ViewInteraction pageTitle;
    public ViewInteraction sortNewsButton;
    public ViewInteraction filterNewsButton;
    public ViewInteraction panelButton;
    public ViewInteraction expandSeparateNewsButton;
    public ViewInteraction newsDescription;
    public ViewInteraction separateNews;
    public ViewInteraction newsList;
    public ViewInteraction dateOfSeparateNews;
    public ViewInteraction nameOfSeparateNews;
    public ViewInteraction updateButton;


    public NewsPage() {
        pageTitle = onView(allOf(withText("Новости"), withParent(withParent(withId(R.id.container_list_news_include)))));
        sortNewsButton = onView(withId(R.id.sort_news_material_button));
        filterNewsButton = onView(withId(R.id.filter_news_material_button));
        panelButton = onView(withId(R.id.edit_news_material_button));
        newsList = onView(withId(R.id.news_list_recycler_view));
        dateOfSeparateNews = onView(withId(R.id.news_item_date_text_view));
        nameOfSeparateNews = onView(withId(R.id.news_item_title_text_view));
        expandSeparateNewsButton = onView(withId(R.id.view_news_item_image_view));
        separateNews = onView(withId(R.id.news_list_recycler_view));
        newsDescription = onView(dataHelper.withIndex(withId(R.id.news_item_description_text_view), 0));
        updateButton = onView(withId(R.id.news_retry_material_button));

}


}


