package com.example.nicolas.usandosqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etcodigo, etnome_disciplina, etnota;
    private Button btincluir, btalterar, btexcluir, btpesquisar, btlistar;
    private CriarBanco banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcodigo = (EditText) findViewById(R.id.etcodigo);
        etnome_disciplina = (EditText) findViewById(R.id.etnome_disciplina);
        etnota = (EditText) findViewById(R.id.etnota);

        banco = new CriarBanco(this);

        btincluir = (Button) findViewById(R.id.btincluir);
        btalterar = (Button) findViewById(R.id.btalterar);
        btexcluir = (Button) findViewById(R.id.btexcluir);
        btpesquisar = (Button) findViewById(R.id.btpesquisar);
        btlistar = (Button) findViewById(R.id.btlistar);
        btincluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (etnome_disciplina.getText().toString().equals("")) {
                        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
                        mensagem.setTitle("Atenção");
                        mensagem.setMessage("O nome da disciplina deve ser preenchido");
                        mensagem.setNeutralButton("OK", null);
                        mensagem.show();
                    } else if (etnota.getText().toString().equals("")) {
                        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
                        mensagem.setTitle("Atenção");
                        mensagem.setMessage("O campo Nota deve ser preenchido");
                        mensagem.setNeutralButton("OK", null);
                        mensagem.show();
                    } else {
                        btincluirOnClick(v);
                    }

                return;
                }
            });
        btalterar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (etnome_disciplina.getText().toString().equals("")) {
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
                    mensagem.setTitle("Atenção");
                    mensagem.setMessage("O nome da disciplina deve ser preenchido");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();
                } else if (etnota.getText().toString().equals("")) {
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
                    mensagem.setTitle("Atenção");
                    mensagem.setMessage("O campo Nota deve ser preenchido");
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();
                } else {
                    btalterarOnClick(v);
                }

                return;
            }
        });

        btexcluir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {if (etnome_disciplina.getText().toString().equals("")) {
                AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
                mensagem.setTitle("Atenção");
                mensagem.setMessage("O nome da disciplina deve ser preenchido");
                mensagem.setNeutralButton("OK", null);
                mensagem.show();
            } else if (etnota.getText().toString().equals("")) {
                AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
                mensagem.setTitle("Atenção");
                mensagem.setMessage("O campo Nota deve ser preenchido");
                mensagem.setNeutralButton("OK", null);
                mensagem.show();
            } else {
                btexcluirOnClick(v);
            }

                return;
            }
        });
        btpesquisar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                btpesquisarOnClick(v);
            }
        });
        btlistar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                btlistarOnClick(v);
            }
        });
    }
    public void btincluirOnClick(View v) {

        Notas xxx = new Notas();
        xxx.setNomeDisciplina(etnome_disciplina.getText().toString());
        xxx.setNota(Double.parseDouble(etnota.getText().toString()));
        banco.incluirRegistro(xxx);
        Toast.makeText(getApplicationContext(), "Incluido", Toast.LENGTH_SHORT).show();
    }

    public void btalterarOnClick(View v) {
        int id = Integer.parseInt(etcodigo.getText().toString());
        Notas notas = new Notas();
        notas.set_id(id);
        notas.setNomeDisciplina(etnome_disciplina.getText().toString());
        notas.setNota(Double.parseDouble(etnota.getText().toString()));
        banco.alterarRegistro(notas);
        Toast.makeText(getApplicationContext(), "Alterado", Toast.LENGTH_SHORT).show();

    }

    public void btexcluirOnClick(View v) {
        int id = Integer.parseInt(etcodigo.getText().toString());
        banco.excluirRegistro(id);
        Toast.makeText(getApplicationContext(), "Excluído!", Toast.LENGTH_SHORT).show();

    }

    public void btpesquisarOnClick(View v) {
        final EditText etCodPesquisa = new EditText(getApplicationContext());
        etCodPesquisa.setTextColor(Color.BLACK);

        AlertDialog.Builder telaPesquisa = new AlertDialog.Builder(this);
        telaPesquisa.setTitle("Pesquisa");
        telaPesquisa.setMessage("Informe o código para pesquisa");
        telaPesquisa.setView(etCodPesquisa);
        telaPesquisa.setNegativeButton("Cancelar", null);
        telaPesquisa.setPositiveButton("Pesquisar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                realizarPesquisa(Integer.parseInt(etCodPesquisa.getText().toString()));
            }
        });

        telaPesquisa.show();
    }
    protected void realizarPesquisa(int id){
        Notas notas = banco.pesquisarRegistro(id);

        if(notas != null){
            etcodigo.setText(String.valueOf(notas.get_id()));
            etnome_disciplina.setText(notas.getNomeDisciplina());
            etnota.setText(String.valueOf(notas.getNota()));

            Toast.makeText(getApplicationContext(),"Registro encontrado", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Registro não encontrado", Toast.LENGTH_SHORT).show();
        }
    }



    public void btlistarOnClick(View v) {
        startActivity(new Intent(getApplicationContext(), ListaActivity.class));
    }
}
