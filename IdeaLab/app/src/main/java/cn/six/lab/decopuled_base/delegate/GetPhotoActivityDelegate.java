package cn.six.lab.decopuled_base.delegate;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import cn.six.lab.decopuled_base.ActivityDelegate;
import cn.six.lab.decopuled_base.ZConstants;

/**
 * Created by songzhw on 2017-01-28
 */

public class GetPhotoActivityDelegate extends ActivityDelegate {
    private IGetPhoteResult listener;

    public GetPhotoActivityDelegate(Activity activity, IGetPhoteResult listener) {
        super(activity);
        this.listener = listener;
    }

    public void goGetPhoto() {
        Intent it = new Intent(Intent.ACTION_PICK);
        it.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(it, ZConstants.REQ_GET_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ZConstants.REQ_GET_PHOTO) {
            if (resultCode == Activity.RESULT_OK) {
                Uri contentURI = data.getData();
                System.out.println("szw contentURI = " + contentURI);
                String result;
                Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
                if (cursor == null) {
                    result = contentURI.getPath(); // Source is Dropbox or other similar local file path
                } else {
                    cursor.moveToFirst();
                    int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    result = cursor.getString(idx);
                    cursor.close();
                }
                listener.onGotPhoto(result);
            }
        }
    }

    public interface IGetPhoteResult {
        void onGotPhoto(String uri);
    }
}
