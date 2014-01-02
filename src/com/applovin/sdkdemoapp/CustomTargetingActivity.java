/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemoapp;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinTargetingData;

/**
 * This is the most basic example of how to add an ad.
 * 
 * @author David Anderson
 * @since 4.0.1
 */
public class CustomTargetingActivity
        extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );

        AppLovinSdk.initializeSdk( this );

        AppLovinSdk sdk = AppLovinSdk.getInstance( this );
        AppLovinTargetingData targeting = sdk.getTargetingData();

        //
        // Set carrier current device is on.
        //
        targeting.setCarrier( "tmobile" );

        //
        // Set a two-character ISO 3166-1 country code of the device.
        //
        targeting.setCountry( "US" );
        //
        // Set the year of birth of the current user.
        //
        targeting.setBirthYear( 1978 );

        //
        // Set the gender of the current user. Use GENDER_MALE and GENDER_FEMALE
        // constants of this class or pass 'm' or 'f' directly.
        //
        targeting.setGender( AppLovinTargetingData.GENDER_MALE );

        //
        // Set the location of the current user.
        //
        Location location = new Location( "user" );
        targeting.setLocation( location );

        //
        // Set the language of the current user. Language is expressed as
        // two-character ISO 639-1 language code.
        //
        targeting.setLanguage( "EN" );

        //
        // Set keywords for the application.
        //
        targeting.setKeywords( "applovin", "test", "demo", "example" );

        //
        // Set interests for the user.
        //
        targeting.setInterests( "books", "games", "pizza" );

        //
        // Clear all saved targeting data.
        //

        // targeting.clearData();


        //
        // We set targeting parameters before loading the layout
        // so that they go up in the first ad request.
        //
        setContentView( R.layout.custom_targeting_demo );
    }
}
