package com.applovin.sdkdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.mopub.mobileads.MoPubView;

public class MoPubBannerActivity extends Activity
{
    private EditText mSearchText;
    private Button mSearchButton;
    private MoPubView mBanner;
    private final String MOPUB_PUBLISHER_ID_BANNER = "db94da4085d311e295fa123138070049";

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mopub_banners);

        mBanner = (MoPubView) findViewById(R.id.bannerview);
        mBanner.setAdUnitId(MOPUB_PUBLISHER_ID_BANNER);
        mBanner.loadAd();

        mSearchText = (EditText) findViewById(R.id.searchtext);
        mSearchButton = (Button) findViewById(R.id.searchbutton);
        mSearchButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager imm
                = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mSearchText.getWindowToken(), 0);
                mBanner.setKeywords(mSearchText.getText().toString());
                mBanner.loadAd();
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        mBanner.destroy();
        super.onDestroy();
    }
}