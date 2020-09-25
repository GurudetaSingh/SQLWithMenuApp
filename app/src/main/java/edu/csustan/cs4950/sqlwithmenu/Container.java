package edu.csustan.cs4950.sqlwithmenu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Container extends SQLiteOpenHelper {
    private static final String DB_NAME  = "myDB";
    private static final int DB_VERSION  = 1;
    private static final String TABLE    = "score";
    private static final String ID       = "id";
    private static final String NAME     = "name";
    private static final String POINT    = "point";

    public Container(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String createTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "create table if not exists " + TABLE +
                " ( " + ID + " integer primary key autoincrement, " +
                NAME + " text, " +
                POINT + " real)";
        Log.i("Container", query);
        db.execSQL(query);

        return "created table";
    }

    public String deleteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "drop table if exists " + TABLE;
        Log.i("Container", query);
        db.execSQL(query);

        return "deleted table";
    }

    public String insert(String name, float point) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "insert into " + TABLE +
                " values ( null, '" + name + "', " + point + ")";
        Log.i("Container", query);
        db.execSQL(query);

        return "inserted";
    }

    public String update(int id, float point) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "update " + TABLE +
                " set " + POINT + " = " + point +
                " where id = " + id;
        Log.i("Container", query);
        db.execSQL(query);

        return "updated";
    }

    public String delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "delete from " + TABLE +
                " where id = " + id;
        Log.i("Container", query);
        db.execSQL(query);

        return "deleted";
    }

    public ArrayList<Score> selectAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Score> scores = new ArrayList<Score>();

        String query = "select * from " + TABLE;
        Log.i("Container", query);
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            float point = cursor.getFloat(2);

            scores.add(new Score(id, name, point));
        }
        return scores;
    }

    public Score select(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from " + TABLE +
                " where id = " + id;
        Log.i("Container", query);
        Cursor cursor = db.rawQuery(query, null);
        Score score = null;
        if (cursor.moveToFirst()) {
            int scoreId = cursor.getInt(0);
            String name = cursor.getString(1);
            float point = cursor.getFloat(2);
            score = new Score(scoreId, name, point);
        }
        return score;
    }

    public ArrayList<Score> selectLargerThanPoint(float point) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Score> scores = new ArrayList<Score>();

        String query = "select * from " + TABLE +
                " where point > " + point;
        Log.i("Container", query);
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            float columnPoint = cursor.getFloat(2);

            scores.add(new Score(id, name, columnPoint));
        }
        return scores;
    }

    public Score selectByIDLargerThanPoint(int id, float point) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from " + TABLE +
                " where id = " + id + " and " +
                " point > " + point;
        Log.i("Container", query);
        Cursor cursor = db.rawQuery(query, null);
        Score score = null;
        if (cursor.moveToFirst()) {
            int scoreId = cursor.getInt(0);
            String name = cursor.getString(1);
            float columnPoint = cursor.getFloat(2);
            score = new Score(scoreId, name, columnPoint);
        }
        return score;
    }

    public boolean existTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select distinct tbl_name from sqlite_master " +
                " where tbl_name = '" + TABLE + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
