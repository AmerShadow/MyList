package com.example.im_ranu.mylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView id, name, no;
    Button viewId, viewName, viewno, add;
    ArrayList<ViewDetails> viewDetails = new ArrayList<>();
    String id1, name1, no1;
    ListView list;
    String viewnow[];
    int i = 0, j;
    private ArrayAdapter adapter;
    private ArrayList<String> data;
    private String TAG=MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setIds();
        setAdapter();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().isEmpty()){
                    id.setError("Please Insert an ID");
                    id.requestFocus();
                    return;
                }
                if(name.getText().toString().isEmpty()){
                    name.setError("Please Insert Name");

                    return;
                }
                if(no.getText().toString().isEmpty()){
                    no.setError("Please Insert Contact number");
                    no.requestFocus();
                    return;
                }

                viewDetails.add(new ViewDetails(id.getText().toString(), name.getText().toString(), no.getText().toString()));
                id.setText("");
                name.setText("");
                no.setText("");
                adapter.notifyDataSetChanged();
            }
        });
        viewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                for (int j = 0; j < viewDetails.size(); j++) {
                    Log.d(TAG,"Name : "+viewDetails.get(j).getName());
                    data.add(viewDetails.get(j).getId());
                }
                adapter.notifyDataSetChanged();
            }
        });

        viewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                for(int j=0;j<viewDetails.size();j++) {
                    data.add(viewDetails.get(j).getName());
                }
                adapter.notifyDataSetChanged();
            }
        });
        viewno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                for(int j=0;j<viewDetails.size();j++) {
                    data.add(viewDetails.get(j).getNo());
                }
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void setAdapter(){
        data = new ArrayList<>();
        for (int j = 0; j < viewDetails.size(); j++) {
            data.add(viewDetails.get(j).getName());
        }
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
    }

    private void setIds() {
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        no = findViewById(R.id.no);
        viewId = findViewById(R.id.listId);
        viewName = findViewById(R.id.listName);
        viewno = findViewById(R.id.listNo);
        add = findViewById(R.id.add);
        list = findViewById(R.id.list);
    }


}



