package mx.cuartoo.ocr_ife_ine.request;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.util.Log;

import com.google.android.gms.vision.text.TextRecognizer;

import java.util.List;

import mx.cuartoo.ocr_ife_ine.OcrApplication;
import mx.cuartoo.ocr_ife_ine.OcrCallback;
import mx.cuartoo.ocr_ife_ine.models.CredentialType;
import mx.cuartoo.ocr_ife_ine.models.ErrorType;
import mx.cuartoo.ocr_ife_ine.response.OcrResponse;
import mx.cuartoo.ocr_ife_ine.util.Constants;
import mx.cuartoo.ocr_ife_ine.util.Helpers;

/**
 * Created by julionava on 1/5/17.
 */

public class OcrRequest {

    private static final String TAG = OcrRequest.class.getSimpleName();

    private OcrRequestParam param;

    public OcrRequest(Bitmap photoFront){
        param = new OcrRequestParam().setPhotoFront(photoFront);
    }

    public OcrRequest setPhotoBack(Bitmap photoBack){
        param.setPhotoBack(photoBack);
        return this;
    }

    public OcrRequest setCredentialType(CredentialType credentialType){
        param.setCredentialType(credentialType);
        return this;
    }

    public OcrRequest setExtractProfilePhoto(boolean extractProfilePhoto) {
        param.setExtractProfilePhoto(extractProfilePhoto);
        return this;
    }

    public OcrRequest setExtractSignature(boolean extractSignature) {
        param.setExtractSignature(extractSignature);
        return this;
    }

    public OcrRequest setExtractFingerprint(boolean extractFingerprint) {
        param.setExtractFingerprint(extractFingerprint);
        return this;
    }

    public OcrRequest setApiKeyGeocode(String apiKeyGeocode) {
        param.setApiKeyGeocode(apiKeyGeocode);
        return this;
    }

    public OcrRequest setGetDataAddressFromGeocode(boolean getDataAddressFromGeocode) {
        param.setGetDataAddressFromGeocode(getDataAddressFromGeocode);
        return this;
    }

    public void execute(final OcrCallback ocrCallback){

        TextRecognizer textRecognizer = new TextRecognizer.Builder(OcrApplication.getContext()).build();

        if(textRecognizer.isOperational()) {

            if(param.getPhotoFront() != null){

                List<String> originDataDetectedFrontPhoto = Helpers.getInfoFromImage(param.getPhotoFront(), textRecognizer);
                List<String> dataDetectedFrontPhotoLowerCase = Helpers.dataToLowerCase(originDataDetectedFrontPhoto);

                if(!originDataDetectedFrontPhoto.isEmpty()){

                    OcrResponse ocrResponse = new OcrResponse(param.getPhotoFront());
                    ocrResponse.setExtractProfilePhoto(param.extractProfilePhoto());
                    ocrResponse.setExtractFingerprint(param.extractFingerprint());
                    ocrResponse.setExtractSignature(param.extractSignature());

                    if(param.getCredentialType() == null){

                        if(Helpers.isCredentialType(dataDetectedFrontPhotoLowerCase, Constants.FEDERAL)){
                            ocrResponse.setCredentialType(CredentialType.IFE);
                        }else{
                            if(Helpers.isCredentialType(dataDetectedFrontPhotoLowerCase, Constants.NACIONAL)){
                                ocrResponse.setCredentialType(CredentialType.INE);
                            }
                        }

                    }else{
                        ocrResponse.setCredentialType(param.getCredentialType());
                    }

                    if(ocrResponse.getCredentialType() != null){

                        //TODO Continue to detect the data
                        ocrCallback.onOcrSuccess(ocrResponse);

                    }else{
                        ocrCallback.onOcrFailure(ErrorType.COULD_NOT_DETERMINATE_CREDENTIAL_TYPE);
                    }

                }else{
                    ocrCallback.onOcrFailure(ErrorType.NO_DATA_DETECTED_PHOTO_FRONT);
                }

            }else{
                ocrCallback.onOcrFailure(ErrorType.NO_PHOTO_FRONT);
            }

        }else{
            // Note: The first time that an app using a Vision API is installed on a
            // device, GMS will download a native libraries to the device in order to do detection.
            // Usually this completes before the app is run for the first time.  But if that
            // download has not yet completed, then the above call will not detect any text,
            // barcodes, or faces.
            // isOperational() can be used to check if the required native libraries are currently
            // available.  The detectors will automatically become operational once the library
            // downloads complete on device.
            Log.w(TAG, "Detector dependencies are not yet available.");

            // Check for low storage.  If there is low storage, the native library will not be
            // downloaded, so detection will not become operational.
            IntentFilter lowstorageFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
            boolean hasLowStorage = OcrApplication.getContext().registerReceiver(null, lowstorageFilter) != null;

            if (hasLowStorage) {
                Log.w(TAG, "Low Storage");
                ocrCallback.onOcrFailure(ErrorType.LOW_STORAGE);
            }else{
                ocrCallback.onOcrFailure(ErrorType.NOT_OPERATIONAL);
            }
        }

    }


}
