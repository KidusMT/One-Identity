package com.gdg.app.data.db;

import com.gdg.app.data.db.model.person.Person;
import com.gdg.app.data.network.model.user.User;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<Long> insertUser(final Person user);

    Observable<List<Person>> getAllUsers();
}
