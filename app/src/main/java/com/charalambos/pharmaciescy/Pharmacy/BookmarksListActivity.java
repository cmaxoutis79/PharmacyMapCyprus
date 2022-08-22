package com.charalambos.pharmaciescy.Pharmacy;

import com.charalambos.pharmaciescy.Bookmarks.Bookmarks;
import com.charalambos.pharmaciescy.Pharmacy.internal.MyFilter;
import com.charalambos.pharmaciescy.Settings.Settings;

public class BookmarksListActivity extends AbstractListActivity {
    @Override
    protected String withTitle() {
        return "Αγαπημένα φαρμακεία";
    }

    @Override
    protected MyFilter buildFilter(Settings settings, Bookmarks bookmarks) {
        return new MyFilter.PharmacyFilterBuilder()
                .setDistrictsFilter(settings.getSelectedDistrictsPreference())
                .withBookmarksOnly(bookmarks)
                .build();
    }
}
