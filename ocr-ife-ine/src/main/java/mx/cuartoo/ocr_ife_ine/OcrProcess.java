package mx.cuartoo.ocr_ife_ine;

import android.graphics.Bitmap;

import mx.cuartoo.ocr_ife_ine.request.OcrRequest;

/**
 * Created by julionava on 1/5/17.
 */

public class OcrProcess {

    public static OcrRequest setPhotoFront(Bitmap photoFront) {
        return new OcrRequest(photoFront);
    }

}
