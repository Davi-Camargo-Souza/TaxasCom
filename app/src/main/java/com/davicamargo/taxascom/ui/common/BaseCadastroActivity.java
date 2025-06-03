package com.davicamargo.taxascom.ui.common;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.davicamargo.taxascom.R;
import com.davicamargo.taxascom.utils.TextUtil;

import java.util.List;

public class BaseCadastroActivity extends AppCompatActivity {
    protected boolean camposEstaoPreenchidos(List<EditText> inputs){
        for(EditText input : inputs){
            if (input != null && TextUtils.isEmpty(input.getText())){
                exibirMensagemErro("Insira todos os dados antes de enviar!");
                return false;
            }
        }
        return true;
    }

    protected void exibirMensagemErro(String mensagemErro){
        var mensagemErroTextView = (TextView) findViewById(R.id.mensagemErroCadastro);
        var visibilidadeMensagemErro = mensagemErroTextView.getVisibility();

        mensagemErroTextView.setText(mensagemErro);
        TextUtil.tremerTextView(mensagemErroTextView);

        if (visibilidadeMensagemErro == View.GONE)
            mensagemErroTextView.setVisibility(View.VISIBLE);
    }
}
