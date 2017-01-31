package mx.cuartoo.ocr_ife_ine.request;

import android.graphics.Bitmap;

import mx.cuartoo.ocr_ife_ine.models.CredentialType;

/**
 * Created by julionava on 1/5/17.
 */

public class OcrRequestParam {

    private Bitmap photoFront;
    private Bitmap photoBack;
    private CredentialType credentialType;
    private boolean extractProfilePhoto;
    private boolean extractSignature;
    private boolean extractFingerprint;
    private String apiKeyGeocode;
    private boolean getDataAddressFromGeocode;

    public OcrRequestParam setPhotoFront(Bitmap photoFront) {
        this.photoFront = photoFront;
        this.extractProfilePhoto = false;
        this.extractSignature = false;
        this.extractFingerprint = false;
        this.getDataAddressFromGeocode = false;
        return this;
    }

    public void setPhotoBack(Bitmap photoBack) {
        this.photoBack = photoBack;
    }

    public void setCredentialType(CredentialType credentialType) {
        this.credentialType = credentialType;
    }

    public void setExtractProfilePhoto(boolean extractProfilePhoto) {
        this.extractProfilePhoto = extractProfilePhoto;
    }

    public void setExtractSignature(boolean extractSignature) {
        this.extractSignature = extractSignature;
    }

    public void setExtractFingerprint(boolean extractFingerprint) {
        this.extractFingerprint = extractFingerprint;
    }

    public Bitmap getPhotoFront() {
        return photoFront;
    }

    public Bitmap getPhotoBack() {
        return photoBack;
    }

    public CredentialType getCredentialType() {
        return credentialType;
    }

    public boolean extractProfilePhoto() {
        return extractProfilePhoto;
    }

    public boolean extractSignature() {
        return extractSignature;
    }

    public boolean extractFingerprint() {
        return extractFingerprint;
    }

    public String getApiKeyGeocode() {
        return apiKeyGeocode;
    }

    public void setApiKeyGeocode(String apiKeyGeocode) {
        this.apiKeyGeocode = apiKeyGeocode;
    }

    public boolean isGetDataAddressFromGeocode() {
        return getDataAddressFromGeocode;
    }

    public void setGetDataAddressFromGeocode(boolean getDataAddressFromGeocode) {
        this.getDataAddressFromGeocode = getDataAddressFromGeocode;
    }
}
