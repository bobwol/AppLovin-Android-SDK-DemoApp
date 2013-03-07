package com.applovin.sdkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial.MoPubInterstitialListener;

public class MoPubInterstitialActivity extends Activity implements MoPubInterstitialListener {

    MoPubInterstitial interstitial;
    private final String MOPUB_PUBLISHER_ID_INTERSTITIAL = "ebb1b27e85e011e281c11231392559e4";
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mopub_interstitials);

        interstitial = new MoPubInterstitial(this, MOPUB_PUBLISHER_ID_INTERSTITIAL);
        
        Button loadShowButton = (Button) findViewById(R.id.loadshowinterstitial);
        loadShowButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showInterstitialAd();
            }
        });
    }

    public void showInterstitialAd() {
        interstitial.setListener(this);
        interstitial.load();
    }

    public void OnInterstitialLoaded() {
    	if (interstitial.isReady()) interstitial.show();
    	
    	else {
    		Log.e("MoPub", "!!!!!");
    	    Toast.makeText(this, "Interstitial could not be shown. Try reloading.", 
    	            Toast.LENGTH_SHORT).show();
    	}
    }

    public void OnInterstitialFailed() {
        Toast.makeText(this, "No ad available", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onDestroy() {
        interstitial.destroy();
        super.onDestroy();
    }
}
