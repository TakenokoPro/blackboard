package tech.takenoko.blackboardapp.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import tech.takenoko.blackboardapp.MainActivity;
import tech.takenoko.blackboardapp.R;
import tech.takenoko.blackboardapp.activity.SubActivity;
import tech.takenoko.blackboardapp.model.EnhCanvasModel;

import static tech.takenoko.blackboardapp.util.Debuger.admobDebug;

/**
 * Created by たけのこ on 2017/05/15.
 */

public class InterstitialAdmob {

    final static String log = "----InterAdmob----";

    private static InterstitialAd mInterstitialAd;
    private static AdRequest adRequest;

    public static void setup(final Context context) {
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(context.getString(R.string.banner_ad_save_id));
        adRequest = new AdRequest.Builder()
        //        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)  // エミュレーター
                .build();
        Log.i(log, "isTestDevice: " + adRequest.isTestDevice(context));
    }
    public static void showInterstitial(SubActivity activity) {
        Log.i(log, "showInterstitial: " + mInterstitialAd.isLoaded());
        mInterstitialAd.setAdListener(new OnAdListener(activity));
        mInterstitialAd.loadAd(adRequest);
    }
    private static void startMainActivity(SubActivity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
    private static class OnAdListener extends AdListener {

        private SubActivity activity;

        public OnAdListener(SubActivity activity) {
            this.activity = activity;
        }
        @Override
        public void onAdOpened() {
            Log.i(log, "onAdOpened");
        }
        @Override
        public void onAdClosed() {
            Log.i(log, "onAdClosed");
            mInterstitialAd = null;
            adRequest = null;
            EnhCanvasModel.clean();
            startMainActivity(activity);
        }
        @Override
        public void onAdFailedToLoad(int i) {
            Log.i(log, "onAdFailedToLoad");
            admobDebug(i, log);
            mInterstitialAd = null;
            adRequest = null;
            EnhCanvasModel.clean();
            startMainActivity(activity);
        }
        @Override
        public void onAdLoaded() {
            Log.i(log, "onAdLoaded");
            mInterstitialAd.show();
        }
        @Override
        public void onAdLeftApplication() {
            Log.i(log, "onAdLeftApplication");
        }
    }
}
