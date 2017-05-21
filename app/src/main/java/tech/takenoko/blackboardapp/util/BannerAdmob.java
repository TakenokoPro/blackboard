package tech.takenoko.blackboardapp.util;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import tech.takenoko.blackboardapp.MainActivity;
import tech.takenoko.blackboardapp.R;

import static tech.takenoko.blackboardapp.util.Debuger.admobDebug;

/**
 * Created by たけのこ on 2017/05/14.
 */

public class BannerAdmob {

    final static String log = "----BannerAdmob----";

    static AdView mAdView;

    public static void setup(final Context context) {
        mAdView = (AdView) ((MainActivity)context).findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
        //        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .build();
        Log.i(log, "isTestDevice: " + adRequest.isTestDevice(context));
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                admobDebug(i, log);
            }
            @Override
            public void onAdLoaded() {
                Log.i(log, "onAdLoaded");
            }
        });
    }
}
