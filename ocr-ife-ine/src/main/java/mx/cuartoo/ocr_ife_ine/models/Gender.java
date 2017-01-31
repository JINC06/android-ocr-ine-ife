package mx.cuartoo.ocr_ife_ine.models;

/**
 * Created by julionava on 1/6/17.
 */

public enum Gender {

    H("H"),
    M("M");

    Gender(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

}
