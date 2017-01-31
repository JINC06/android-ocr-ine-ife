package mx.cuartoo.ocr_ife_ine.models;

/**
 * Created by julionava on 1/5/17.
 */

public enum CredentialType {

    IFE("IFE"),
    INE("INE");

    private CredentialType(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

}
