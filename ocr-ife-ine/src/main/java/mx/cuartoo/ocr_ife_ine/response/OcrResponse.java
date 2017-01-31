package mx.cuartoo.ocr_ife_ine.response;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.cuartoo.ocr_ife_ine.models.CredentialType;
import mx.cuartoo.ocr_ife_ine.models.Gender;
import mx.cuartoo.ocr_ife_ine.models.Image;

/**
 * Created by julionava on 1/6/17.
 */

public class OcrResponse {

    private Bitmap photoFront;
    private Bitmap photoBack;
    private CredentialType credentialType;
    private boolean extractProfilePhoto;
    private boolean extractSignature;
    private boolean extractFingerprint;
    private List<Image> images;

    private Gender gender;

    private String firstName;
    private String middleName;
    private String fullName;

    private String lastName;
    private String secondSurname;
    private String fullSurnames;

    private String personName;

    private String voterKey;
    private String birthdate;
    private Date birthdateDate;
    private String fullAddress;
    private String curp;

    private int age;
    private Integer currentAge;

    private String folioIneIfe;

    public OcrResponse(Bitmap photoFront) {
        this.photoFront = photoFront;
        this.extractProfilePhoto = false;
        this.extractSignature = false;
        this.extractFingerprint = false;
        this.images = new ArrayList<>();
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Bitmap getPhotoFront() {
        return photoFront;
    }

    public void setPhotoFront(Bitmap photoFront) {
        this.photoFront = photoFront;
    }

    public Bitmap getPhotoBack() {
        return photoBack;
    }

    public void setPhotoBack(Bitmap photoBack) {
        this.photoBack = photoBack;
    }

    public CredentialType getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(CredentialType credentialType) {
        this.credentialType = credentialType;
    }

    public boolean isExtractProfilePhoto() {
        return extractProfilePhoto;
    }

    public void setExtractProfilePhoto(boolean extractProfilePhoto) {
        this.extractProfilePhoto = extractProfilePhoto;
    }

    public boolean isExtractSignature() {
        return extractSignature;
    }

    public void setExtractSignature(boolean extractSignature) {
        this.extractSignature = extractSignature;
    }

    public boolean isExtractFingerprint() {
        return extractFingerprint;
    }

    public void setExtractFingerprint(boolean extractFingerprint) {
        this.extractFingerprint = extractFingerprint;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getFullSurnames() {
        return fullSurnames;
    }

    public void setFullSurnames(String fullSurnames) {
        this.fullSurnames = fullSurnames;
    }

    public String getVoterKey() {
        return voterKey;
    }

    public void setVoterKey(String voterKey) {
        this.voterKey = voterKey;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Date getBirthdateDate() {
        return birthdateDate;
    }

    public void setBirthdateDate(Date birthdateDate) {
        this.birthdateDate = birthdateDate;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFolioIneIfe() {
        return folioIneIfe;
    }

    public void setFolioIneIfe(String folioIneIfe) {
        this.folioIneIfe = folioIneIfe;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(Integer currentAge) {
        this.currentAge = currentAge;
    }
}
