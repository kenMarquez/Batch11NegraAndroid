package io.mariachi.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import io.mariachi.recyclerviewexample.models.User;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerContacts;

    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateDummyData();
        initViews();
    }

    private void initViews() {
        mRecyclerContacts = (RecyclerView) findViewById(R.id.recycler_contacts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerContacts.setLayoutManager(linearLayoutManager);

        ContactAdapter contactAdapter = new ContactAdapter(userList);
        mRecyclerContacts.setAdapter(contactAdapter);

    }

    public void generateDummyData() {


        userList.add(new User("usuario", "1233123"));

        userList.add(new User("Luis", "5566778899"));
        userList.add(new User("Raúl", "5544332211"));
        userList.add(new User("Bryan", "343144121"));
//        userList.add(new User("Mateo", "55437389"));
//        userList.add(new User("Jhon", "5593849203"));
//        userList.add(new User("Pepe", "5583719037"));
//        userList.add(new User("Fiora", "5513489043"));
//        userList.add(new User("Malzahar", "5539174391"));
//        userList.add(new User("Fizz", "5544332211"));
    }

}
