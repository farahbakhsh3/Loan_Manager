package ir.farahbakhsh3.LoanManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    private final static String DBName = "dbLoanManager.db";
    private final static int DBVersion = 1;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL("CREATE TABLE [Loans](\n" +
                "  [LoanID] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, \n" +
                "  [LoanTitle] NVARCHAR(255) NOT NULL, \n" +
                "  [LoanType] NVARCHAR(100) NOT NULL, \n" +
                "  [LoanCount] INT NOT NULL, \n" +
                "  [LoanFirstPay] NVARCHAR(10) NOT NULL, \n" +
                "  [LoanPeriod] INT NOT NULL, \n" +
                "  [LoanPaymentAmount] NUMERIC(15) NOT NULL, \n" +
                "  [LaonPaymentReminderAlertDays] INT NOT NULL);\n "
        );
        db.execSQL("CREATE TABLE [LoanPayment]( " +
                "  [LoanID] INT NOT NULL REFERENCES [Loans]([LoanID]) ON DELETE CASCADE ON UPDATE CASCADE,  " +
                "  [PaymentID] INT NOT NULL,  " +
                "  [PaymentDate] NVARCHAR(10) NOT NULL,  " +
                "  [PaymentIsPayed] BOOL,  " +
                "  [PaymentPayedDate] NVARCHAR(10),  " +
                "  PRIMARY KEY([PaymentID], [LoanID])); "
        );
        db.execSQL("CREATE TABLE [Settings]([NotifTime] NVARCHAR(5));"
        );
        db.execSQL("CREATE VIEW [ViewLoansPayment] " +
                "AS " +
                "SELECT  " +
                "       [main].[Loans].[LoanID],  " +
                "       [main].[Loans].[LoanTitle],  " +
                "       [main].[Loans].[LoanType],  " +
                "       [main].[Loans].[LoanCount],  " +
                "       [main].[Loans].[LoanFirstPay],  " +
                "       [main].[Loans].[LoanPeriod],  " +
                "       [main].[Loans].[LoanPaymentAmount],  " +
                "       [main].[Loans].[LaonPaymentReminderAlertDays],  " +
                "       [main].[LoanPayment].[PaymentID],  " +
                "       [main].[LoanPayment].[PaymentDate],  " +
                "       [main].[LoanPayment].[PaymentIsPayed],  " +
                "       [main].[LoanPayment].[PaymentPayedDate] " +
                "FROM   [main].[Loans] " +
                "       LEFT JOIN [main].[LoanPayment] ON [main].[Loans].[LoanID] = [main].[LoanPayment].[LoanID]; "
        );
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists [main].[Loans];  ");
//        db.execSQL("drop table if exists [main].[LoanPayment];  ");
//        db.execSQL("drop table if exists [main].[Settings];  ");
    }

//    public void DeleteScores() {
//        SQLiteDatabase db = getWritableDatabase();
//        db.delete("???", null, null);
//
//        db.close();
//    }

//    public void ResetScores() {
//        DeleteScores();
//        InitiateScores();
//    }

//    public void InitiateScores() {
//        insert("beginner", 0, 0, 0);
//        insert("easy", 0, 0, 0);
//        insert("normal", 0, 0, 0);
//        insert("hard", 0, 0, 0);
//    }

//    public void insert(String game_level, int human, int draw, int ai) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues cv = new ContentValues();
//        cv.put("game_level", game_level);
//        cv.put("human", human);
//        cv.put("draw", draw);
//        cv.put("ai", ai);
//        db.insert("Scores", null, cv);
//
//        db.close();
//    }

//    public int[][] selectScores() {
//        SQLiteDatabase db = getReadableDatabase();
//
//        int[][] Scores = new int[4][3];
//        int idx = 0;
//        Cursor cursor = db.rawQuery("select * from Scores", null);
//        if (cursor.moveToFirst())
//            do {
//                Scores[idx][0] = cursor.getInt(1);
//                Scores[idx][1] = cursor.getInt(2);
//                Scores[idx][2] = cursor.getInt(3);
//                idx++;
//            } while (cursor.moveToNext());
//
//        db.close();
//        return Scores;
//    }

//    public void setScore(int ii, int jj) {
//        int[][] scores = selectScores();
//        DeleteScores();
//
//        scores[ii][jj]++;
//
//        insert("beginner", scores[0][0], scores[0][1], scores[0][2]);
//        insert("easy", scores[1][0], scores[1][1], scores[1][2]);
//        insert("normal", scores[2][0], scores[2][1], scores[2][2]);
//        insert("hard", scores[3][0], scores[3][1], scores[3][2]);
//    }
}
