package sg.edu.np.madapplication.madapplication.madpractical.s10203319;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    static ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Random random = new Random();

        for(int i = 0;i < 20; i++){
            userList.add( new User("User " + random.nextInt(1000000000), "Description: " + random.nextInt(1000000000), random.nextInt(1000000000), false));
        }

        RecyclerView recyclerView = findViewById(R.id.UserListView);

        UserListAdapter lAdapter = new UserListAdapter(userList, ListActivity.this);

        LinearLayoutManager lLayoutManager = new LinearLayoutManager(ListActivity.this);

        recyclerView.setLayoutManager(lLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(lAdapter);
    }
}