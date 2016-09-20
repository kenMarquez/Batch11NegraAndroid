package io.mariachi.realmexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.mariachi.realmexample.models.User;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        User user = new User("Pepe", "pepe2@gmail.com", 24);
        guardarUsuario(user);


    }

    private void guardarUsuario(User user) {


        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        realm.copyToRealmOrUpdate(user);


        realm.commitTransaction();

        printAllUsers();

    }

    private void printAllUsers() {


        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();


        // Encontramos todos los usuarios de la tabla de
        List<User> allUsers = realm.where(User.class).findAll();

        // Encontramos un usuario especifico
        User luis = realm.where(User.class).equalTo("name", "Pepe").findFirst();
        realm.beginTransaction();

        luis.deleteFromRealm();
        realm.commitTransaction();


        // Encontramos todos los usuarios de la tabla de
        allUsers = realm.where(User.class).findAll();

        // Encontramos el primer usuario de toda la tabbla de usuarios
        User first = realm.where(User.class).findFirst();


        for (int i = 0; i < allUsers.size(); i++) {
            Log.i("myLog", "User: " + allUsers.get(i).getName());
        }


    }


}
