package takenoko.tech.blackboardapp.util;

import android.content.Context;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by たけのこ on 2017/05/06.
 */

public class UtilStrage {

    /** 保存するファイル名 */
    private final static String FILE_NAME = "StoreDto.obj";
    // File imageFile = new File(activity.getFilesDir().getAbsolutePath()+"/cache.jpg");

    public static void store(Context context, Serializable object) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE));
            out.writeObject(object);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object load(Context context) {
        Object retObj = null;
        try {
            ObjectInputStream in = new ObjectInputStream(context.openFileInput(FILE_NAME));
            retObj = in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retObj;
    }
}
