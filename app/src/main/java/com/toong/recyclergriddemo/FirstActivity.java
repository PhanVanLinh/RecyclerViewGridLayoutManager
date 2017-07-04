package com.toong.recyclergriddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.toong.recyclergriddemo.adapter.MyRecyclerViewAdapter;
import com.toong.recyclergriddemo.item_decoration.GridSpacingItemDecorationKeepItemSize;
import com.toong.recyclergriddemo.model.Item;
import java.util.ArrayList;

import static com.toong.recyclergriddemo.R.id.recyclerView;

public class FirstActivity extends AppCompatActivity
        implements MyRecyclerViewAdapter.ItemClickListener {
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Grid Recycler View Keep Item Size");

        mRecyclerView = (RecyclerView) findViewById(recyclerView);

        ArrayList<Item> data = new ArrayList<>();
        data.add(new Item("a", "b"));
        data.add(new Item("c", "b"));
        data.add(new Item("d", "b"));
        data.add(new Item("e", "b"));
        data.add(new Item("f", "b"));
        data.add(new Item("g", "b"));
        data.add(new Item("h", "b"));
        data.add(new Item("j", "b"));
        data.add(new Item("k", "b"));
        data.add(new Item("l", "b"));
        data.add(new Item("m", "b"));

        // set up the RecyclerView
        int numberOfColumns = 3;
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data.toArray(new Item[data.size()]));
        adapter.setClickListener(this);
        mRecyclerView.setAdapter(adapter);

        //        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
        //                DividerItemDecoration.HORIZONTAL));

        mRecyclerView.addItemDecoration(new GridSpacingItemDecorationKeepItemSize(3,
                getResources().getDimensionPixelSize(R.dimen.dp_60)));
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
