package com.example.login_and_intent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import android.net.Uri;
import android.hardware.Camera.CameraInfo;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {
    static final int REQUEST_PERMISSION_CAMERA = 1001;
    private Button cc;
    private EditText num;
    static final int REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE =
            1002;
    int permissionCount = 0;
    private String t;
    private TextView tt;
    private Button hh;
    private Button ccam;
    String snum;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cc = findViewById(R.id.button4);
        num = findViewById(R.id.editText4);

        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);

                snum = num.getText().toString();
                if(snum.trim().isEmpty()){
                    i.setData(Uri.parse("tel:9986388234"));
                }
                else{
                    i.setData(Uri.parse("tel:"+snum));
                }
                startActivity(i);


            }
        });
        permissionCount = 0;

        if (checkSelfPermission(Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]
                            {Manifest.permission.CAMERA},
                    REQUEST_PERMISSION_CAMERA);
        else
            permissionCount++;

        if (checkSelfPermission
                (Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]
                            {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE);
        else
            permissionCount++;

        ccam = findViewById(R.id.button3);
        ccam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (permissionCount >= 2){
                    startActivity(new Intent(Main2Activity.this, def_cam.class));
            }


            }
        });

        Intent log_scr = getIntent();
       // String message = log_scr.getStringExtra(MainActivity.);
        tt = findViewById(R.id.textView);

        t = log_scr.getStringExtra("edit_user");


        Toast.makeText(getApplicationContext(),"hi! "+t,Toast.LENGTH_SHORT).show();
        tt.setText("hi! "+t);

        hh=findViewById(R.id.button2);
        hh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bb = new Intent(getBaseContext(), MainActivity.class);
               // new_screen.putExtra("edit_user",edit_user);
                startActivity(bb);
            }
        });


    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions,
                grantResults);

        switch (requestCode) {
            case REQUEST_PERMISSION_CAMERA:
            case REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE:
                if (grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)
                    permissionCount++;
            default:
                break;
        }
    }
}
