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
    private SQLiteDatabase banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcodigo = (EditText) findViewById(R.id.etcodigo);
        etnome_disciplina = (EditText) findViewById(R.id.etnome_disciplina);
        etnota = (EditText) findViewById(R.id.etnota);

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
    }
    public void btincluirOnClick(View v) {

        Notas notas = new Notas();
        notas.set_id(Integer.parseInt(etcodigo.getText().toString()));
        CriarBanco criarBanco = new CriarBanco(this);
        criarBanco.incluirRegistro(notas);
        Toast.makeText(getApplicationContext(), "Incluido", Toast.LENGTH_SHORT).show();

        /* ContentValues registro = new ContentValues();
        registro.put("nome_disciplina", etnome_disciplina.getText().toString());
        registro.put("nota", Double.parseDouble(etnota.getText().toString()));
        banco.insert("notas", null, registro);
        Toast.makeText(getApplicationContext(), "Sucesso!", Toast.LENGTH_SHORT).show();
        */
    }

    public void btalterarOnClick(View v) {
        int id = Integer.parseInt(etcodigo.getText().toString());
        ContentValues registro = new ContentValues();
        registro.put("nome_disciplina", etnome_disciplina.getText().toString());
        registro.put("nota", Double.parseDouble(etnota.getText().toString()));
        banco.update("notas", registro, "_id = " + id, null);
        Toast.makeText(getApplicationContext(), "Sucesso!", Toast.LENGTH_SHORT).show();

    }

    public void btexcluirOnClick(View v) {
        int id = Integer.parseInt(etcodigo.getText().toString());
        banco.delete("notas", "_id = " + id, null);
        Toast.makeText(getApplicationContext(), "Sucesso!", Toast.LENGTH_SHORT).show();

    }

    public void btpesquisarOnClick(View v) {

    }

    public void btlistarOnClick(View v) {

    }
}
