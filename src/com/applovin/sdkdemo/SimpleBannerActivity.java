/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinSdk;

/**
 * This is the most basic example of how to add an ad.
 * 
 * @author Basil Shikin
 * @since 1.1
 */
public class SimpleBannerActivity
        extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        AppLovinSdk.initializeSdk(this);

        //
        // PLEASE NOTE:
        //
        // (1) simple_banner.xml includes following view:
        //
        // <com.applovin.views.AppLovinAdView
        // android:layout_width="fill_parent"
        // android:layout_height="wrap_content" />
        //
        // (2) AndroidManifest.xml includes following lines:
        //
        // <uses-permission android:name="android.permission.INTERNET"/>
        // . . .
        // <application>
        // . . .
        // <meta-data android:value="YOUR_SDK_KEY_HERE"
        // android:name="APPLOVIN_SDK_KEY" />
        // </application>
        //
        setContentView(R.layout.simple_banner);

        AppLovinAdView ad = (AppLovinAdView) findViewById(R.id.ALadview);
        ad.loadNextAd();
    }

    public void buttonHandler(View v)
    {
        String clicked = ((Button) v).getText().toString();
        Class targetActivity = null;

        if (clicked.equals("AppLovin Interstitial"))
        {
            targetActivity = ShowInterstitialActivity.class;
        }
        else if (clicked.equals("AdMob Mediation"))
        {
            targetActivity = AdMobMediationActivity.class;
        }
        else if (clicked.equals("MoPub Mediation (Banner)")) {
            targetActivity = MoPubBannerActivity.class;
        }
        else if (clicked.equals("MoPub Mediation (Interstitial)")) {
            targetActivity = MoPubInterstitialActivity.class;
        }
        else if (clicked.equals("AdWhirl Mediation")) {
            targetActivity = AdWhirlIntegrationDemo.class;
        }

        Intent i = new Intent(this, targetActivity);
        startActivity(i);
    }
}
