package com.mahii.recyclerviewonclicklistnerusinglambda.UI.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mahii.recyclerviewonclicklistnerusinglambda.API.models.MyModel;
import com.mahii.recyclerviewonclicklistnerusinglambda.MVP.presenter.RecyclerPresenter;
import com.mahii.recyclerviewonclicklistnerusinglambda.MVP.view.RecyclerMvpView;
import com.mahii.recyclerviewonclicklistnerusinglambda.R;
import com.mahii.recyclerviewonclicklistnerusinglambda.UI.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerMvpView {

    RecyclerView myRecyclerView;

    private RecyclerPresenter recyclerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPresenter = new RecyclerPresenter();
        recyclerPresenter.setView(this);

        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        setupRecyclerView();

        recyclerPresenter.getData();
    }

    private void setupRecyclerView() {
        MyAdapter adapter = new MyAdapter();
        adapter.setItemClickListener(
                (myModel, position) -> recyclerPresenter.getPositionData(myModel));
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(adapter);
    }

    @Override
    public void loadData(List<MyModel> myModels) {
        MyAdapter adapter = (MyAdapter) myRecyclerView.getAdapter();
        adapter.setModels(myModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getPosition(MyModel myModel) {
        Toast.makeText(this, myModel.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }
}
