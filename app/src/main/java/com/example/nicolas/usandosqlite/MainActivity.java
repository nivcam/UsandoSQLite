package com.example.nicolas.usandosqlite;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

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
                btincluirOnClick(v);
            }
        });
        btalterar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                btalterarOnClick(v);
            }
        });
        btexcluir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                btexcluirOnClick(v);
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

        Notas notas = new Notas();
        notas.setNomeDisciplina(etnome_disciplina.getText().toString());
        notas.setNota(Double.parseDouble(etnota.getText().toString()));
        banco.incluirRegistro(notas);
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
      //  final EditText etCod

    }

    public void btlistarOnClick(View v) {

    }
}
