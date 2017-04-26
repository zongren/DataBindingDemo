package me.zongren.databindingdemo;

import android.view.View;

/**
 * Created by zongren on 2017/4/26.
 */

public interface ItemEventHandler {
    void clickTitle(View view);
    void clickCheckbox(View view);
    void clickTitle(View view,Item item);
}
