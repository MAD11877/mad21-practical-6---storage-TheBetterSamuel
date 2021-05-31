package sg.edu.np.madapplication.madapplication.madpractical.s10203319;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UserDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDB.db";
    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "username";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_FOLLOWED = "followed";

    public UserDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE_USERS = "CREATE TABLE" + TABLE_USERS + '(' + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_DESCRIPTION + " TEXT," + COLUMN_NAME +" TEXT," + COLUMN_FOLLOWED + " BIT" + ")";
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_USERS);
        onCreate(db);
    }

    public void addUses(User newUser){
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, newUser.getDescription());
        values.put(COLUMN_NAME,newUser.getName());
        values.put(COLUMN_ID,newUser.getId());
        if(newUser.isfollowed()){
            values.put(COLUMN_FOLLOWED,1);
        }
        else{
            values.put(COLUMN_FOLLOWED,0);
        }

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USERS,null,values);
        db.close();
    }
}
