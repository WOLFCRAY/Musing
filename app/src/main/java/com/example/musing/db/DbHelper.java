package com.example.musing.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "registro.db";
    public static final String TABLE_USUARIOS = "t_usuarios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_USUARIOS+"(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "usuario TEXT NOT NULL," +
                "correo TEXT NOT NULL," +
                "password TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_USUARIOS);
        onCreate(sqLiteDatabase);
    }
}
