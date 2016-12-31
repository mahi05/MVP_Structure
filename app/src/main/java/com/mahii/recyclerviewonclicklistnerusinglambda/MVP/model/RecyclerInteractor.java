package com.mahii.recyclerviewonclicklistnerusinglambda.MVP.model;

import android.content.Context;
import android.util.Log;

import com.mahii.recyclerviewonclicklistnerusinglambda.API.models.MyModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerInteractor {

    private Context context;

    public RecyclerInteractor(Context context) {
        this.context = context;
    }

    public void loadData(RecyclerCallback recyclerCallback) {

        List<MyModel> myModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyModel myModel = new MyModel();
            myModel.setTitle("Title " + (i + 1));
            myModel.setSubTitle("SubTitle " + (i + 1));
            myModels.add(myModel);
        }
        recyclerCallback.onResponse(myModels);
    }

}
