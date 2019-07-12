package com.example.login_and_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button log;
    private EditText username,pass;
    public String edit_user,edit_pas;
    public String EXTRA_MESSAGE = "hey! you are now logged in....";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log= findViewById(R.id.button);
        username=findViewById(R.id.editText2);
        pass=findViewById(R.id.editText);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_user=username.getText().toString();
                edit_pas = pass.getText().toString();
                Toast.makeText(getApplicationContext(),edit_user,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),edit_pas,Toast.LENGTH_SHORT).show();
                if(edit_user.equals("vk") && edit_pas.equals("123456")){

                    Intent new_screen = new Intent(getBaseContext(), Main2Activity.class);
                    new_screen.putExtra("edit_user",edit_user);
                    startActivity(new_screen);

                    //EXTRA_MESSAGE=edit_user;
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrng credentias",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
