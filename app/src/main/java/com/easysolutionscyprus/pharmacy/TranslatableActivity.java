package com.easysolutionscyprus.pharmacy;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.easysolutionscyprus.pharmacy.Language.LanguageConfigurator;
import com.easysolutionscyprus.pharmacy.Settings.LocalePreference;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public abstract class TranslatableActivity extends AppCompatActivity {
    protected LocalePreference localePreference;
    protected AdView adView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        translateActivity();
        setContentView(withLayout());
        configureViews();
        executeOnCreateActions();
        configureToolbar();
        configureAds();
    }

    protected abstract int withLayout();

    protected abstract void executeOnCreateActions();

    protected abstract void configureViews();

    protected abstract void configureToolbar();

    private void translateActivity() {
        localePreference = new LocalePreference(this);
        LanguageConfigurator.setLanguage(getBaseContext(), localePreference.getPreference());
    }

    @SuppressLint("MissingPermission")
    private void configureAds() {
        MobileAds.initialize(this, initializationStatus -> {});
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}