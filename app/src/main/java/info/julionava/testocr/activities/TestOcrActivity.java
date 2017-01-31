package info.julionava.testocr.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import info.julionava.testocr.R;
import info.julionava.testocr.databinding.ActivityTestOcrBinding;

public class TestOcrActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int TAKE_FRONT_PICTURE = 1;
    public static final int TAKE_BACK_PICTURE = 2;

    private ActivityTestOcrBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_ocr);

        mBinding.containerFrontPhoto.setOnClickListener(this);
        mBinding.containerBackPhoto.setOnClickListener(this);
        mBinding.btnApplyOcr.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.container_front_photo:
                takePicture(TAKE_FRONT_PICTURE);
                break;
            case R.id.container_back_photo:
                takePicture(TAKE_BACK_PICTURE);
                break;
            case R.id.btn_apply_ocr:
                applyOcr();
                break;
        }
    }

    private void takePicture(int takeFrontPicture) {

    }

    private void applyOcr(){

    }


}
