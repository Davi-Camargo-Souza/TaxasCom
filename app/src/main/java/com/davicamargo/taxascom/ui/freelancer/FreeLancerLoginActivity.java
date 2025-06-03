package com.davicamargo.taxascom.ui.freelancer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.Typeface;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.davicamargo.taxascom.R;

public class FreeLancerLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_free_lancer_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cadastrarSeButtonOnClick(View view){
        var cadastrarSeIntent = new Intent(this, FreeLancerCadastroActivity.class);
        startActivity(cadastrarSeIntent);
    }

    public void verSenhaButtonOnClick(View view){
        var senhaInput = (EditText) findViewById(R.id.senhaLoginInput);
        var verSenhaButton = (ImageButton) view;

        var tag = verSenhaButton.getTag();
        var senhaVisivel = tag != null && Boolean.parseBoolean(tag.toString());

        if (senhaVisivel){

            senhaInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            senhaInput.setTypeface(Typeface.DEFAULT);
            verSenhaButton.setImageResource(R.drawable.ic_eye);
            verSenhaButton.setTag("false");
        } else {
            senhaInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            senhaInput.setTypeface(Typeface.DEFAULT);
            verSenhaButton.setImageResource(R.drawable.ic_eye_off);
            verSenhaButton.setTag("true");
        }
        senhaInput.setSelection(senhaInput.getText().length());
    }
}