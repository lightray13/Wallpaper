package ccc.bbb.aaa.wallpaper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ccc.bbb.aaa.wallpaper.R;
import ccc.bbb.aaa.wallpaper.adapter.CustomRecyclerViewAdapter;
import shivam.developer.featuredrecyclerview.FeatureLinearLayoutManager;
import shivam.developer.featuredrecyclerview.FeaturedRecyclerView;

public class MenuActivity extends AppCompatActivity {

    List<String> dummyData = new ArrayList<>();
    FeaturedRecyclerView featuredRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        createDummyDataList();

        featuredRecyclerView = (FeaturedRecyclerView) findViewById(R.id.featured_recycler_view);

        FeatureLinearLayoutManager layoutManager = new FeatureLinearLayoutManager(this);
        featuredRecyclerView.setLayoutManager(layoutManager);

        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter();
        adapter.swapData(dummyData, MenuActivity.this);

        featuredRecyclerView.setAdapter(adapter);
    }

    private void createDummyDataList() {
        for (int i = 1; i <= 6; i++) {
            if (i == 1) {
                dummyData.add("Животные");
            } else if (i == 2) {
                dummyData.add("Города");
            } else if (i == 3) {
                dummyData.add("Спорт");
            } else if (i == 4) {
                dummyData.add("Природа");
            } else if (i == 5) {
                dummyData.add("Музыка");
            } else if (i == 6) {
                dummyData.add("");
            }
        }
    }
}
