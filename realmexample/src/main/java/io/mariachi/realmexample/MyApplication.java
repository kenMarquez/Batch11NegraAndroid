package io.mariachi.realmexample;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Ken on 19/09/16.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        // Create a RealmConfiguration that saves the Realm file in the app's "files" directory.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);
    }


}
