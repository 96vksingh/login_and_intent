package com.example.login_and_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import android.os.Bundle;

public class def_cam extends AppCompatActivity {
    static final int ID_ACT_CAMERA = 20001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_def_cam);

        issueCameraIntent();
    }

    private void issueCameraIntent() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, ID_ACT_CAMERA);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ID_ACT_CAMERA && resultCode == RESULT_OK) {
            Bitmap b = (data.getExtras()).getParcelable("data");

            ImageView iv = (ImageView)findViewById(R.id.imageView);
            iv.setImageBitmap(b);
        }
    }
}
