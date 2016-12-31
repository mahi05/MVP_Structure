package com.mahii.recyclerviewonclicklistnerusinglambda.MVP.model;

import com.mahii.recyclerviewonclicklistnerusinglambda.API.models.MyModel;

import java.util.List;

public interface RecyclerCallback {

    void onResponse(List<MyModel> artists);

}
