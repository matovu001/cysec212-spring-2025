package edu.gannon.todocontentproviderapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "todo.db";
    private static final int DATABASE_VERSION = 1;

    public TodoDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_TABLE = "CREATE TABLE " + TodoContract.TABLE_NAME + " ("
                + TodoContract.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TodoContract.COLUMN_TASK + " TEXT NOT NULL, "
                + TodoContract.COLUMN_DESCRIPTION + " TEXT, "
                + TodoContract.COLUMN_IS_COMPLETED + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_TABLE);

        // sample data
        db.execSQL("INSERT INTO " + TodoContract.TABLE_NAME + " (task, description, isCompleted)" +
                "VALUES ('Buy Groceries', 'Milk, Eggs, Bread', 0);");
        db.execSQL("INSERT INTO " + TodoContract.TABLE_NAME + " (task, description, isCompleted)" +
                "VALUES ('Homework', 'Complete CYSEC212 Homework', 1);");
        db.execSQL("INSERT INTO " + TodoContract.TABLE_NAME + " (task, description, isCompleted)" +
                "VALUES ('Project', 'Work on home project', 0);");
        db.execSQL("INSERT INTO " + TodoContract.TABLE_NAME + " (task, description, isCompleted)" +
                "VALUES ('Watch Movie', 'Check Netflix for a movie', 0);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TodoContract.TABLE_NAME);
        onCreate(db);
    }
}
