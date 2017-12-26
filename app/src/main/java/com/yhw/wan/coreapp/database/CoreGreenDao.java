package com.yhw.wan.coreapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yhw.wan.core.app.Core;

/**
 * Created by 傅令杰 on 2017/3/29
 */

public final class CoreGreenDao {
    private DaoSession mDaoSession;

    private CoreGreenDao() {
        Context context = Core.getApplicationContext();
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(context, "core_db.db", null);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public static CoreGreenDao getInstance() {
        return Holder.INSTANCE;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }


    private static class Holder {
        private static final CoreGreenDao INSTANCE = new CoreGreenDao();
    }


}
