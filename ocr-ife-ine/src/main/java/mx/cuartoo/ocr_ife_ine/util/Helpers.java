package mx.cuartoo.ocr_ife_ine.util;

import android.graphics.Bitmap;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by julionava on 1/6/17.
 */

public class Helpers {

    public static final String TAG = Helpers.class.getSimpleName();

    /**
     * Get info from a image using ocr vision
     * @param image
     * @param textRecognizer
     * @return
     */
    public static List<String> getInfoFromImage(Bitmap image, TextRecognizer textRecognizer) {

        List<String> data = new ArrayList<>();

        // imageBitmap is the Bitmap image you're trying to process for text
        if (image != null && textRecognizer != null) {

            Frame imageFrame = new Frame.Builder()
                    .setBitmap(image)
                    .build();

            SparseArray<TextBlock> textBlocks = textRecognizer.detect(imageFrame);

            for (int i = 0; i < textBlocks.size(); i++) {
                TextBlock textBlock = textBlocks.get(textBlocks.keyAt(i));
                data.add(textBlock.getValue());
            }

        }

        return data;
    }

    /**
     * To lower case
     * @param originDataDetectedFrontPhoto
     * @return
     */
    public static List<String> dataToLowerCase(List<String> originDataDetectedFrontPhoto) {
        List<String> data = new ArrayList<>();
        for (String s : originDataDetectedFrontPhoto) {
            data.add(s);
        }
        return data;
    }

    /**
     * Find text in a string
     * @param input
     * @param regex
     * @return
     */
    private static boolean findText(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    /**
     * Search text on a list of data
     * @param data
     * @param dataToSearch
     * @return
     */
    private static boolean findTextOnList(List<String> data, String dataToSearch) {
        for (String s : data) {
            if(findText(s, dataToSearch)){
                return true;
            }
        }
        return false;
    }

    private static List<Integer> findTextOnListAndGetPossiblesPositions(List<String> data, String dataToSearch){
        List<Integer> possiblePositions = new ArrayList<>();
        int index = 0;
        for (String s : data) {
            if(findText(s, dataToSearch)){
                possiblePositions.add(index);
            }
            index++;
        }
        return possiblePositions;
    }

    /**
     *
     * @deprecated
     * @version 1.0
     * @param data
     * @param credentialType
     * @return
     */
    public static boolean isCredentialType(List<String> data, String credentialType) {

        if (credentialType != null && !credentialType.isEmpty()) {

            int lengthDataToSearch = credentialType.length();
            while (lengthDataToSearch > Constants.LIMIT_TO_FIND_TYPE_CREDENTIAL) {
                String dataTrim = credentialType.substring(0, lengthDataToSearch);
                if(findTextOnList(data, dataTrim)){
                    return true;
                }else{
                    lengthDataToSearch--;
                }
            }

        }
        return false;
    }

    

}
