package com.example.photocollection_handon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlbumAdapter albumAdapter;

    private ArrayList<Album> albums = new ArrayList<>();
    private Album album1;
    private Album album2;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Photo> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        album1 = new Album("1", "1", "Album1");
        album2 = new Album("2", "2", "Album2");

        albums.add(album1);
        albums.add(album2);

        initRecylerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle item select
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText editText = new EditText(this);

        switch (item.getItemId()){
            case R.id.add_btn:
                alert.setTitle("Add_Album");
                alert.setView(editText);
                alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editText.getText().toString();
                        Log.d("Tag", name);
                        Album album = new Album("99", "11/11/11", name);
                        albums.add(album);
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initializeData(){
//        listItems = new ArrayList<>();
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"11/11/11"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"12/12/12"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"11/11/11"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"12/12/12"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"11/11/11"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"12/12/12"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"11/11/11"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"12/12/12"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"11/11/11"));
        listItems.add(new Photo("1", R.drawable.default_thumbnail,"12/12/12"));
    }
    public void initRecylerView(){
        RecyclerView recyclerView = findViewById(R.id.galleryGridView);
        adapter = new AlbumAdapter(albums, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
