package com.mahii.recyclerviewonclicklistnerusinglambda.MVP.presenter;

public interface Presenter<V> {

    void setView(V view);

    void detachView();
}
