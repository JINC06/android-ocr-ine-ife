package mx.cuartoo.ocr_ife_ine.models;

/**
 * Created by julionava on 1/6/17.
 */

public enum ErrorType {

    NOT_OPERATIONAL("Detector dependencies are not yet available."),
    LOW_STORAGE("Low Storage"),
    NO_PHOTO_FRONT("No photo front to work"),
    NO_DATA_DETECTED_PHOTO_FRONT("No data detected on photo front"),
    COULD_NOT_DETERMINATE_CREDENTIAL_TYPE("Could not determine credential type");

    ErrorType(String description){
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
