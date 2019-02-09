package com.gdg.app.data.db;

import com.gdg.app.data.db.model.person.DaoMaster;
import com.gdg.app.data.db.model.person.DaoSession;
import com.gdg.app.data.db.model.person.Person;
import com.gdg.app.data.network.model.user.User;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Long> insertUser(final Person user) {
        return Observable.fromCallable(() -> mDaoSession.getPersonDao().insert(user));
    }

    @Override
    public Observable<List<Person>> getAllUsers() {
        return Observable.fromCallable(() -> mDaoSession.getPersonDao().loadAll());
    }
}
