package mx.cuartoo.ocr_ife_ine;

import android.app.Application;
import android.content.Context;

/**
 * Created by julionava on 1/6/17.
 */

public class OcrApplication extends Application {

    //** Instance of the current application. */
    private static OcrApplication instance;

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}
