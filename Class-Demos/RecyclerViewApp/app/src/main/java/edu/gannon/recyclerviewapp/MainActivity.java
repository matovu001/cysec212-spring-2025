package edu.gannon.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewTasks;
    TaskAdapter mTaskAdapter;
    List<Task> mTaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mRecyclerViewTasks = findViewById(R.id.recyclerview_tasks);
        mRecyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));

        mTaskList = new ArrayList<>();
        mTaskList.add(new Task("Buy Groceries", "Milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Homework", "Finish up CIS 219 homework 02", true));
        mTaskList.add(new Task("Work out", "Run 5k in the morning", false));
        mTaskList.add(new Task("Club Meeting", "Meet for the club activities", true));
        mTaskList.add(new Task("Fix Bug", "Work on the bug in CYSEC 212 exam", false));
        mTaskList.add(new Task("Complete Homework", "Finish up CIS 219 homework 02", true));
        mTaskList.add(new Task("Work out", "Run 5k in the morning", false));
        mTaskList.add(new Task("Club Meeting", "Meet for the club activities", true));
        mTaskList.add(new Task("Fix Bug", "Work on the bug in CYSEC 212 exam", false));
        mTaskList.add(new Task("Buy Groceries", "Milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Homework", "Finish up CIS 219 homework 02", true));
        mTaskList.add(new Task("Work out", "Run 5k in the morning", false));
        mTaskList.add(new Task("Club Meeting", "Meet for the club activities", true));
        mTaskList.add(new Task("Fix Bug", "Work on the bug in CYSEC 212 exam", false));
        mTaskList.add(new Task("Complete Homework", "Finish up CIS 219 homework 02", true));
        mTaskList.add(new Task("Work out", "Run 5k in the morning", false));
        mTaskList.add(new Task("Club Meeting", "Meet for the club activities", true));
        mTaskList.add(new Task("Fix Bug", "Work on the bug in CYSEC 212 exam", false));
        mTaskList.add(new Task("Buy Groceries", "Milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Homework", "Finish up CIS 219 homework 02", true));
        mTaskList.add(new Task("Work out", "Run 5k in the morning", false));
        mTaskList.add(new Task("Club Meeting", "Meet for the club activities", true));
        mTaskList.add(new Task("Fix Bug", "Work on the bug in CYSEC 212 exam", false));
        mTaskList.add(new Task("Complete Homework", "Finish up CIS 219 homework 02", true));
        mTaskList.add(new Task("Work out", "Run 5k in the morning", false));
        mTaskList.add(new Task("Club Meeting", "Meet for the club activities", true));
        mTaskList.add(new Task("Fix Bug", "Work on the bug in CYSEC 212 exam", false));

        mTaskAdapter = new TaskAdapter(mTaskList);
        mRecyclerViewTasks.setAdapter(mTaskAdapter);

    }
}