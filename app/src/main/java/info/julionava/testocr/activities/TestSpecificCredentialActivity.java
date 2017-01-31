package info.julionava.testocr.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import info.julionava.testocr.R;
import info.julionava.testocr.models.TypeTest;

public class TestSpecificCredentialActivity extends AppCompatActivity {

    public static final String TYPE_TEST = "TYPE_TEST";

    private Bitmap photoFront;
    private Bitmap photoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_specific_credential);

        setUpData((TypeTest) getIntent().getExtras().getSerializable(TYPE_TEST));
    }

    private void setUpData(TypeTest typeTest) {
        switch (typeTest){
            case IFE_B:
                photoFront = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ife_anverso);
                photoBack = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ife_reverso);
                break;
            case IFE_C:
                photoFront = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ife_anverso);
                photoBack = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ife_reverso);
                break;
            case INE_D:
                photoFront = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ine_anverso);
                photoBack = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ine_reverso);
                break;
            case INE_E:
                photoFront = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ine_anverso);
                photoBack = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ine_reverso);
                break;
        }


    }


}
