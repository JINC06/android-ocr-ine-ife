package mx.cuartoo.ocr_ife_ine.models;

import android.graphics.Bitmap;

/**
 * Created by julionava on 1/6/17.
 */

public class Image {

    private Bitmap image;
    private ImageType imageType;

    public Image(Bitmap image, ImageType imageType) {
        this.image = image;
        this.imageType = imageType;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }
}
