package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.androidanimations.library.Techniques
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.viksaa.sssplash.lib.activity.AwesomeSplash
import com.viksaa.sssplash.lib.cnst.Flags
import com.viksaa.sssplash.lib.model.ConfigSplash

class splashActivity2 : AwesomeSplash() {
    private var mInterstitialAd: InterstitialAd? = null
    override fun initSplash(configSplash: ConfigSplash?) {
        MobileAds.initialize(this) {}
        //Customize Circular Reveal
        configSplash?.backgroundColor = R.color.green; //any color you want form colors.xml
        configSplash?.animCircularRevealDuration = 3000; //int ms
        configSplash?.revealFlagX = Flags.REVEAL_RIGHT;  //or Flags.REVEAL_LEFT
        configSplash?.revealFlagY = Flags.REVEAL_BOTTOM; //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash?.logoSplash = R.drawable.ic_baseline_sports_soccer_24; //or any other drawable
        configSplash?.animLogoSplashDuration = 1500; //int ms
        configSplash?.animLogoSplashTechnique = Techniques.DropOut; //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)
        //Customize Title
        configSplash?.titleSplash = "FOOTBALL NEWS";
        configSplash?.titleTextColor = R.color.cyan;
        configSplash?.titleTextSize = 30f; //float value
        configSplash?.animTitleDuration = 1500;
        configSplash?.animTitleTechnique = Techniques.Flash;
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })

    }

    override fun animationsFinished() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                   open()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                   open()
                }

                override fun onAdShowedFullScreenContent() {
                    mInterstitialAd = null
                }
            }

        } else {
           open()
        }
        mInterstitialAd?.show(this)
    }
    fun open(){

        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
        finish()
    }

}