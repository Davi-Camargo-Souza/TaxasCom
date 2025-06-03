package com.davicamargo.taxascom.ui.freelancer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.davicamargo.taxascom.R;
import com.davicamargo.taxascom.data.entities.Freelancer;
import com.davicamargo.taxascom.ui.MainActivity;
import com.davicamargo.taxascom.ui.common.BaseCadastroActivity;

import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class FreeLancerCadastroActivity extends BaseCadastroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_free_lancer_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviarCadastroFreelancerButtonOnClick(View view){
        var nomeInput = (EditText) findViewById(R.id.nomeCadastroInput);
        var emailInput = (EditText) findViewById(R.id.emailCadastroInput);
        var senhaInput = (EditText) findViewById(R.id.senhaCadastroInput);
        var confirmacaoSenhaInput = (EditText) findViewById(R.id.confirmacaoSenhaCadastroInput);
        var dataNascimentoInput = (EditText) findViewById(R.id.dtaNascimentoCadastroInput);

        List<EditText> inputs = new ArrayList<>();
        inputs.add(nomeInput);
        inputs.add(emailInput);
        inputs.add(senhaInput);
        inputs.add(confirmacaoSenhaInput);
        inputs.add(dataNascimentoInput);

        var camposEstaoPreenchidos = camposEstaoPreenchidos(inputs);
        if (!camposEstaoPreenchidos)
            return;

        FreelancerViewModel viewModel = new ViewModelProvider(this).get(FreelancerViewModel.class);

        viewModel.verificarEmail(emailInput.getText().toString(), existe -> {
            runOnUiThread(() -> {
                if (existe) {
                    exibirMensagemErro("Email já cadastrado!");
                } else {
                    var freelancer = new Freelancer(
                            nomeInput.getText().toString(),
                            LocalDate.parse(dataNascimentoInput.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            senhaInput.getText().toString(),
                            emailInput.getText().toString()
                            );
                    viewModel.inserir(freelancer);
                    var perfilIntent = new Intent(this, MainActivity.class);
                    startActivity(perfilIntent);
                }
            });
        });
    }
}