package com.gabriel.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button numero0, numero1, numero2, numero3, numero4,
            numero5, numero6, numero7, numero8, numero9, ponto,
            soma, mulplicacao, subtracao, divisao, bota_limpar, bt_igual;

    private TextView txtExpressao, txtResultado;

    private ImageView backspace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numero1.setOnClickListener(this);
        numero2.setOnClickListener(this);
        numero3.setOnClickListener(this);
        numero4.setOnClickListener(this);
        numero5.setOnClickListener(this);
        numero6.setOnClickListener(this);
        numero7.setOnClickListener(this);
        numero8.setOnClickListener(this);
        numero9.setOnClickListener(this);
        numero0.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        mulplicacao.setOnClickListener(this);

        bota_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if (!string.isEmpty()) {

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }

                txtResultado.setText(" ");

            }
        });

        bt_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long result = (long) resultado;

                    if(resultado == (double)result){
                        txtResultado.setText((CharSequence) String.valueOf(result));
                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                }catch (Exception e){

                }
            }
        });

    }

    private void IniciarComponentes(){
        numero0 = findViewById(R.id.numero_zero);
        numero1 = findViewById(R.id.numero_um);
        numero2 = findViewById(R.id.numero_dois);
        numero3 = findViewById(R.id.numero_tres);
        numero4 = findViewById(R.id.numero_quatro);
        numero5 = findViewById(R.id.numero_cinco);
        numero6 = findViewById(R.id.numero_seis);
        numero7 = findViewById(R.id.numero_sete);
        numero8 = findViewById(R.id.numero_oito);
        numero9 = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.numero_ponto);
        soma = findViewById(R.id.bt_soma);
        mulplicacao = findViewById(R.id.bt_multiplicacao);
        subtracao = findViewById(R.id.bt_subtracao);
        divisao = findViewById(R.id.bt_divisao);
        bota_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado= findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
        bt_igual = findViewById(R.id.bt_igual);
    }

    public void AcrescentarUmaExpressao(String string, Boolean limparDados){

        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (limparDados){

            if(!txtResultado.getText().equals(" "))
            {
                txtExpressao.setText("");
            }
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }
        else {
            if(!txtResultado.getText().equals(" "))
            {
                txtExpressao.setText("");
                txtExpressao.append(txtResultado.getText());
            }
            txtExpressao.append(" " + string + " " );
            txtResultado.setText(" ");

        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.numero_zero:
                AcrescentarUmaExpressao("0", true);
                break;
            case R.id.numero_um:
                AcrescentarUmaExpressao("1", true);
                break;
            case R.id.numero_dois:
                AcrescentarUmaExpressao("2", true);
                break;
            case R.id.numero_tres:
                AcrescentarUmaExpressao("3", true);
                break;
            case R.id.numero_quatro:
                AcrescentarUmaExpressao("4", true);
                break;
            case R.id.numero_cinco:
                AcrescentarUmaExpressao("5", true);
                break;
            case R.id.numero_seis:
                AcrescentarUmaExpressao("6", true);
                break;
            case R.id.numero_sete:
                AcrescentarUmaExpressao("7", true);
                break;
            case R.id.numero_oito:
                AcrescentarUmaExpressao("8", true);
                break;
            case R.id.numero_nove:
                AcrescentarUmaExpressao("9", true);
                break;
            case R.id.numero_ponto:
                AcrescentarUmaExpressao(".", true);
                break;
            case R.id.bt_soma:
                AcrescentarUmaExpressao("+", false);
                break;
            case R.id.bt_subtracao:
                AcrescentarUmaExpressao("-", false);
                break;
            case R.id.bt_multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;
            case R.id.bt_divisao:
                AcrescentarUmaExpressao("/", false);
                break;
        }
    }
}