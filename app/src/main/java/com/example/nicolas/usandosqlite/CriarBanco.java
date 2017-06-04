package com.example.nicolas.usandosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriarBanco extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "banco";

    public CriarBanco(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase banco) {
        banco.execSQL("CREATE TABLE notas1 (_id INTEGER PRIMARY KEY AUTOINCLEMENT, " +
                "nome_disciplina TEXT NOT NULL, nota DECIMAL NOT NULL");

    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int oldVersion, int newVersion) {
        banco.execSQL("DROP TABLE IF EXISTS notas1");
        onCreate(banco);
    }
    public void incluirRegistro(Notas notas) {
        SQLiteDatabase banco = this.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nome_disciplina", notas.getNomeDisciplina());
        registro.put("nota", notas.getNota());
        banco.insert("nota1", null, registro);
        banco.close();
    }
    public void alterarRegistro (Notas notas){
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("nome_disciplina", notas.getNomeDisciplina());
        registro.put("nota", notas.getNota());
        banco.update("notas1", registro, "_id = ") +
        notas.get_id(), null;
        banco.close();
    }

    public void excluirRegistro(int id){
        SQLiteDatabase banco = this.getWritableDatabase();
        banco.delete("notas1", "_id = ?", new String[]{String.valueOf(id)});
        banco.close();
    }
}
