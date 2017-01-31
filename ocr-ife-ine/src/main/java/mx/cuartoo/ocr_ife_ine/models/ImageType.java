package mx.cuartoo.ocr_ife_ine.models;

/**
 * Created by julionava on 1/6/17.
 */

public enum ImageType {

    PROFILE_PICTURE("Profile picture"),
    SIGNATURE("Signature"),
    FINGERPRINT("Fingerprint");

    ImageType(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

}
