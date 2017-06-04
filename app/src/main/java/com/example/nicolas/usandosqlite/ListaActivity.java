package com.example.nicolas.usandosqlite;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;

public class ListaActivity extends AppCompatActivity {

    private ListView lvregistros;
    private SQLiteDatabase banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvregistros = (ListView) findViewById(R.id.lvlistar);

        banco = this.openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        montarListadeRegisto();
    }

    private void montarListadeRegisto() {
        Cursor registros = banco.query("notas1", null, null, null, null, null, null);
        String nomeCamposTabela[] = new String[] {"nome_disciplina", "nota"};
        int nomeCamposTela[] = new int[]{android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),android.R.layout.two_line_list_item, registros, nomeCamposTabela, nomeCamposTela);
        lvregistros.setAdapter(adapter);
    }
}
