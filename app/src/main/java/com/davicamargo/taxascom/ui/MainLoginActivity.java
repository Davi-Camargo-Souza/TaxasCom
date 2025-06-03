package com.davicamargo.taxascom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.davicamargo.taxascom.R;
import com.davicamargo.taxascom.ui.empresa.EmpresaLoginActivity;
import com.davicamargo.taxascom.ui.freelancer.FreeLancerLoginActivity;

public class MainLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void souFreeLancerButtonOnClick(View view){
        var freeLancerIntent = new Intent(this, FreeLancerLoginActivity.class);
        startActivity(freeLancerIntent);
    }

    public void souEmpresaButtonOnClick(View view){
        var empresaIntent = new Intent(this, EmpresaLoginActivity.class);
        startActivity(empresaIntent);
    }
}