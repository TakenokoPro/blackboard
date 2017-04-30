package takenoko.tech.blackboardapp.model;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.Paint;

import lombok.Getter;
import lombok.Setter;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

/**
 * Created by たけのこ on 2017/04/30.
 */

public class DrawSurfaceModel {

    @Getter @Setter
    float surfaceX = 0, surfaceY = 0;
    @Getter @Setter
    float penX = 100, penY = 100;
    @Getter @Setter
    float penDx = 8, penDy = 8;
    @Getter
    Paint redLine = new Paint();
    @Getter
    Paint blueLine = new Paint();
    @Getter
    Paint whiteLine = new Paint();
    @Getter
    Paint penLine = new Paint();
    @Getter
    Paint blurPanLine = new Paint();

    public DrawSurfaceModel() {
        redLine.setColor(RED);
        blueLine.setColor(BLUE);
        whiteLine.setColor(WHITE);
        settingPenLine();
    }

    public void settingPenLine() {
        int strokeWidth = 10;
        penLine.setColor(Color.argb(200, 240, 240, 240));
        penLine.setStyle(Paint.Style.STROKE);
        penLine.setStrokeJoin(Paint.Join.ROUND);
        penLine.setStrokeCap(Paint.Cap.ROUND);
        penLine.setStrokeWidth(strokeWidth);
        blurPanLine.set(penLine);
        blurPanLine.setStrokeWidth(strokeWidth/2*3);
        blurPanLine.setMaskFilter(new BlurMaskFilter(strokeWidth*2, BlurMaskFilter.Blur.NORMAL));
    }
}
