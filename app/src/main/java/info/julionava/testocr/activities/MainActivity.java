package info.julionava.testocr.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import info.julionava.testocr.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    public MainActivity $this = MainActivity.this;

    TextView mTvResponse;
    ImageView mImgPhoto;

    Bitmap mCurrentPhoto;

    private int TWO_SECONDS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvResponse = (TextView) findViewById(R.id.tv_response);
        mImgPhoto = (ImageView) findViewById(R.id.img_foto);
    }


    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.ife_anverso:
                mCurrentPhoto= BitmapFactory.decodeResource(getBaseContext().getResources(),
                        R.drawable.ife_anverso);
                mImgPhoto.setImageBitmap(mCurrentPhoto);
                mImgPhoto.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new GetInfoFromImageAsyncTask().execute();
                    }
                }, TWO_SECONDS);
                return true;

            case R.id.ife_reverso:
                mCurrentPhoto= BitmapFactory.decodeResource(getBaseContext().getResources(),
                        R.drawable.ife_reverso);
                mImgPhoto.setImageBitmap(mCurrentPhoto);
                mImgPhoto.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new GetInfoFromImageAsyncTask().execute();
                    }
                }, TWO_SECONDS);
                return true;

            case R.id.ife_reverso_vertical:
                mCurrentPhoto= BitmapFactory.decodeResource(getBaseContext().getResources(),
                        R.drawable.ife_reverso_vertical);
                mImgPhoto.setImageBitmap(mCurrentPhoto);
                mImgPhoto.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new GetInfoFromImageAsyncTask().execute();
                    }
                }, TWO_SECONDS);
                return true;

            case R.id.ine_anverso:
                mCurrentPhoto= BitmapFactory.decodeResource(getBaseContext().getResources(),
                        R.drawable.ine_anverso);
                mImgPhoto.setImageBitmap(mCurrentPhoto);
                mImgPhoto.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new GetInfoFromImageAsyncTask().execute();
                    }
                }, TWO_SECONDS);
                return true;

            case R.id.ine_reverso:
                mCurrentPhoto= BitmapFactory.decodeResource(getBaseContext().getResources(),
                        R.drawable.ine_reverso);
                mImgPhoto.setImageBitmap(mCurrentPhoto);
                mImgPhoto.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new GetInfoFromImageAsyncTask().execute();
                    }
                }, TWO_SECONDS);


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class GetInfoFromImageAsyncTask extends AsyncTask<Void, Void, String>{

        private ProgressDialog mProgressDialog;

        @Override
        protected void onPreExecute() {
            mProgressDialog = new ProgressDialog($this);
            mProgressDialog.setMessage(getString(R.string.getting_info));
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected String doInBackground(Void... params) {
            String result = "";

            // imageBitmap is the Bitmap image you're trying to process for text
            if(mCurrentPhoto != null) {

                TextRecognizer textRecognizer = new TextRecognizer.Builder($this).build();

                if(!textRecognizer.isOperational()) {
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
                    boolean hasLowStorage = registerReceiver(null, lowstorageFilter) != null;

                    if (hasLowStorage) {
                        Toast.makeText(MainActivity.this, "Low Storage", Toast.LENGTH_LONG).show();
                        Log.w(TAG, "Low Storage");
                    }
                }


                Frame imageFrame = new Frame.Builder()
                        .setBitmap(mCurrentPhoto)
                        .build();

                SparseArray<TextBlock> textBlocks = textRecognizer.detect(imageFrame);

                for (int i = 0; i < textBlocks.size(); i++) {
                    TextBlock textBlock = textBlocks.get(textBlocks.keyAt(i));

                    Log.i(TAG, "---------------------------------------------------------------");
                    Log.i(TAG, textBlock.getValue());
                    Log.i(TAG, "---------------------------------------------------------------");
                    Log.i(TAG, "Largo: "+textBlock.getValue().length());
                    for (char c : textBlock.getValue().toCharArray()) {
                        Log.i(TAG, String.valueOf(c)+" "+((int) c));
                    }
                    Log.i(TAG, "---------------------------------------------------------------");
                    // Do something with value
                    result += "["+i+"]\n";
                    result += textBlock.getValue();
                    result += "\n\n";
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            mTvResponse.setText(s);
            mProgressDialog.dismiss();
        }

    }



}
