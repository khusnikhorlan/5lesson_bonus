package com.example.contextmenu4bonus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView mlistView;
    private String[] contacts = {"Aru","Enlik", "Sabina","Khorlan"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistView = findViewById(R.id.listViewID);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,contacts
        );
        mlistView.setAdapter(adapter);
        registerForContextMenu(mlistView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {

        if (item.getItemId() == R.id.callAction){
            Toast.makeText(this,"call selected",Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId()==R.id.smsaction){
            Toast.makeText(this,"SMS selected",Toast.LENGTH_SHORT).show();
        }else {
            return false;
        }

            return true;

    }}