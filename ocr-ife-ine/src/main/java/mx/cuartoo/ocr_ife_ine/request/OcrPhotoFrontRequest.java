package mx.cuartoo.ocr_ife_ine.request;

import android.graphics.Bitmap;

/**
 * Created by julionava on 1/5/17.
 */

public class OcrPhotoFrontRequest {

    public static OcrRequest photoFront(Bitmap photoFront){
        return new OcrRequest(photoFront);
    }

}
