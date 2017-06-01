package com.example.nicolas.usandosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etcodigo, etnome_disciplina, etnota;
    private Button btincluir, btalterar, btexcluir, btpesquisar, btlistar;

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

    }
}
