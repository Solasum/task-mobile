package akai.com.akaimobiletask;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button loginActivityButton;
    private EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        loginActivityButton = (Button) findViewById(R.id.mainButton);
        loginActivityButton.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       goToLoginActivity();
                                                   }
                                               });

        textField = (EditText) findViewById(R.id.mainText);
        textField.setEnabled(false);

        SharedPreferences settings = getSharedPreferences("login", Context.MODE_PRIVATE);
        String myString = settings.getString("editable", "defaultvalue");
        if(myString.equals("true"))
        {
            textField.setEnabled(true);
            settings.edit().remove("editable").commit();
        }

    }

    private void goToLoginActivity() {
        Intent moveOnToMainActivityIntent = new Intent(this, LoginActivity.class);
        onPause();
        startActivity(moveOnToMainActivityIntent);
        finish();
    }
}
