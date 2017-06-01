package com.example.nicolas.usandosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ListaActivity extends AppCompatActivity {

    private ListView lvregistros;
    private SQLiteDatabase banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvregistros = (ListView) findViewById(R.id.lvlistar);

        banco = this.openOrCreateDatabase("banco", getApplicationContext().MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS notas (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "nome_disciplina TEXT NOT NULL, nota DECIMAL NOT NULL");

    }
}
