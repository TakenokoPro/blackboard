package takenoko.tech.blackboardapp.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by たけのこ on 2017/04/30.
 */

public class EnhCanvas {

    @Getter @Setter
    Path touchPath = new Path();
    @Getter @Setter
    private static ArrayList<Bitmap> bitmaps = new ArrayList();
    @Getter @Setter
    private static ArrayList<Canvas> canvases = new ArrayList<>();

    public EnhCanvas() {}

    public void addCanvas(int width, int height) {
        bitmaps.add(Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888));
        canvases.add(new Canvas(getBitmap(getLength()-1)));
        getCanvas(getLength()-1).drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public static Bitmap getBitmap(int i) {
        return bitmaps.get(i);
    }

    public Canvas getCanvas(int i) {
        return canvases.get(i);
    }

    public int getLength() {
        return bitmaps.size();
    }
}
