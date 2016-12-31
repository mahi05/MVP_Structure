package com.mahii.recyclerviewonclicklistnerusinglambda.MVP.presenter;

import com.mahii.recyclerviewonclicklistnerusinglambda.API.models.MyModel;
import com.mahii.recyclerviewonclicklistnerusinglambda.MVP.model.RecyclerCallback;
import com.mahii.recyclerviewonclicklistnerusinglambda.MVP.model.RecyclerInteractor;
import com.mahii.recyclerviewonclicklistnerusinglambda.MVP.view.RecyclerMvpView;

import java.util.List;

public class RecyclerPresenter implements Presenter<RecyclerMvpView>, RecyclerCallback {

    private RecyclerMvpView recyclerMvpView;
    private RecyclerInteractor recyclerInteractor;

    public RecyclerPresenter() {
    }

    @Override
    public void setView(RecyclerMvpView view) {
        if (view == null) throw new IllegalArgumentException("You can't set a null view");

        recyclerMvpView = view;
        recyclerInteractor = new RecyclerInteractor(recyclerMvpView.getContext());
    }

    @Override
    public void detachView() {
        recyclerMvpView = null;
    }

    public void getData() {
        recyclerInteractor.loadData(this);
    }

    public void getPositionData(MyModel myModel){
        recyclerMvpView.getPosition(myModel);
    }

    @Override
    public void onResponse(List<MyModel> myModels) {
        recyclerMvpView.loadData(myModels);
    }

}
