package ccc.bbb.aaa.wallpaper.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ccc.bbb.aaa.wallpaper.R;
import ccc.bbb.aaa.wallpaper.adapter.MyAdapter;
import ccc.bbb.aaa.wallpaper.model.Item;

public class PhotoActivity extends AppCompatActivity {

    List<Item> items;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        switch (position) {
            case 0:
                toolbar.setTitle("Животные");
                break;
            case 1:
                toolbar.setTitle("Города");
                break;
            case 2:
                toolbar.setTitle("Спорт");
                break;
            case 3:
                toolbar.setTitle("Природа");
                break;
            case 4:
                toolbar.setTitle("Музыка");
                break;
        }
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        items = new ArrayList<>();

        switch (position){
            case 0:
                items.add(new Item(getResources().getDrawable(R.drawable.one_one), R.drawable.one_one));
                items.add(new Item(getResources().getDrawable(R.drawable.one_two), R.drawable.one_two));
                items.add(new Item(getResources().getDrawable(R.drawable.one_three), R.drawable.one_three));
                break;
            case 1:
                items.add(new Item(getResources().getDrawable(R.drawable.two_one), R.drawable.two_one));
                items.add(new Item(getResources().getDrawable(R.drawable.two_two), R.drawable.two_two));
                items.add(new Item(getResources().getDrawable(R.drawable.two_three), R.drawable.two_three));
                break;
            case 2:
                items.add(new Item(getResources().getDrawable(R.drawable.three_one), R.drawable.three_one));
                items.add(new Item(getResources().getDrawable(R.drawable.three_two), R.drawable.three_two));
                items.add(new Item(getResources().getDrawable(R.drawable.three_three), R.drawable.three_three));
                break;
            case 3:
                items.add(new Item(getResources().getDrawable(R.drawable.four_one), R.drawable.four_one));
                items.add(new Item(getResources().getDrawable(R.drawable.four_two), R.drawable.four_two));
                items.add(new Item(getResources().getDrawable(R.drawable.four_three), R.drawable.four_three));
                break;
            case 4:
                items.add(new Item(getResources().getDrawable(R.drawable.five_one), R.drawable.five_one));
                items.add(new Item(getResources().getDrawable(R.drawable.five_two), R.drawable.five_two));
                items.add(new Item(getResources().getDrawable(R.drawable.five_three), R.drawable.five_three));
                break;
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter(this, items);
        recyclerView.setAdapter(adapter);

        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
