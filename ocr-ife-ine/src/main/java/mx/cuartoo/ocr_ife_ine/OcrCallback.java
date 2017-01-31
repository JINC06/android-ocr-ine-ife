package mx.cuartoo.ocr_ife_ine;

import mx.cuartoo.ocr_ife_ine.models.ErrorType;
import mx.cuartoo.ocr_ife_ine.response.OcrResponse;

/**
 * Created by julionava on 1/5/17.
 */

public interface OcrCallback {

    void onOcrSuccess(OcrResponse ocrResponse);
    void onOcrFailure(ErrorType errorType);

}
