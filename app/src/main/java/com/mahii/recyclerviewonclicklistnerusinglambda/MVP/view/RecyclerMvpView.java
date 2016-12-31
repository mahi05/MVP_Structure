package com.mahii.recyclerviewonclicklistnerusinglambda.MVP.view;

import com.mahii.recyclerviewonclicklistnerusinglambda.API.models.MyModel;

import java.util.List;

public interface RecyclerMvpView extends MvpView {

    void loadData(List<MyModel> myModels);

    void getPosition(MyModel myModel);

}
