package com.davicamargo.taxascom.ui.empresa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import com.davicamargo.taxascom.R;
import com.davicamargo.taxascom.data.entities.Empresa;
import com.davicamargo.taxascom.data.entities.Endereco;
import com.davicamargo.taxascom.data.entities.RamoAtuacao;
import com.davicamargo.taxascom.ui.MainActivity;
import com.davicamargo.taxascom.ui.common.BaseCadastroActivity;
import com.davicamargo.taxascom.ui.endereco.EnderecoViewModel;
import com.davicamargo.taxascom.ui.ramoAtuacao.RamoAtuacaoViewModel;
import java.util.ArrayList;
import java.util.List;

public class EmpresaCadastroActivity extends BaseCadastroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_empresa_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner = findViewById(R.id.spinnerRamo);
        RamoAtuacaoViewModel viewModel = new ViewModelProvider(this).get(RamoAtuacaoViewModel.class);

        viewModel.getTodosRamos().observe(this, ramos -> {
            ArrayAdapter<RamoAtuacao> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_spinner_item,
                    ramos
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        });
    }

    public void enviarCadastroEmpresaButtonOnClick(View view){
        EditText nomeFantasiaInput = findViewById(R.id.nomeFantasiaCadastroInput);
        EditText razaoSocialInput = findViewById(R.id.razaoSocialCadastroInput);
        EditText cnpjInput = findViewById(R.id.cnpjCadastroInput);
        EditText emailInput = findViewById(R.id.emailEmpresaCadastroInput);
        EditText senhaInput = findViewById(R.id.senhaEmpresaCadastroInput);
        EditText confirmacaoSenhaInput = findViewById(R.id.confirmacaoSenhaEmpresaCadastroInput);

        EditText cepInput = findViewById(R.id.cepCadastroEnderecoInput);
        EditText ruaInput = findViewById(R.id.ruaCadastroEnderecoInput);
        EditText numeroInput = findViewById(R.id.numeroCadastroEnderecoInput);
        EditText bairroInput = findViewById(R.id.bairroCadastroEnderecoInput);
        EditText estadoInput = findViewById(R.id.estadoCadastroEnderecoInput);
        EditText paisInput = findViewById(R.id.paisCadastroEnderecoInput);
        EditText complementoInput = findViewById(R.id.complementoCadastroEnderecoInput);
        EditText cidadeInput = findViewById(R.id.cidadeCadastroEnderecoInput);

        Spinner ramoSpinner = findViewById(R.id.spinnerRamo);
        var ramo = (RamoAtuacao) ramoSpinner.getSelectedItem();

        List<EditText> inputs = new ArrayList<>();
        inputs.add(nomeFantasiaInput);
        inputs.add(razaoSocialInput);
        inputs.add(cnpjInput);
        inputs.add(emailInput);
        inputs.add(senhaInput);
        inputs.add(confirmacaoSenhaInput);
        inputs.add(cepInput);
        inputs.add(ruaInput);
        inputs.add(numeroInput);
        inputs.add(bairroInput);
        inputs.add(estadoInput);
        inputs.add(paisInput);
        inputs.add(complementoInput);
        inputs.add(cidadeInput);

        var todosCamposPreenchidos = camposEstaoPreenchidos(inputs);
        if (!todosCamposPreenchidos)
            return;

        var enderecoViewModel = new ViewModelProvider(this).get(EnderecoViewModel.class);
        var empresaViewModel = new ViewModelProvider(this).get(EmpresaViewModel.class);

        var endereco = new Endereco(
            ruaInput.getText().toString(),
            paisInput.getText().toString(),
            cepInput.getText().toString(),
            cidadeInput.getText().toString(),
            bairroInput.getText().toString(),
            complementoInput.getText().toString(),
            Integer.parseInt(numeroInput.getText().toString()),
            estadoInput.getText().toString()
        );

        enderecoViewModel.inserir(endereco);

        var empresa = new Empresa(
                nomeFantasiaInput.getText().toString(),
                ramo.cod,
                cnpjInput.getText().toString(),
                senhaInput.getText().toString(),
                endereco.cod,
                emailInput.getText().toString(),
                null
        );

        empresaViewModel.inserir(empresa);

        var mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}