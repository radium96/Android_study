package com.naca.bible.ui.viewModel;

import androidx.lifecycle.ViewModel;

public class BibleListItemViewModel extends ViewModel {
    private String chapter;

    public BibleListItemViewModel (String chapter){
        this.chapter = chapter;
    }

    public String getChapter(){
        return chapter;
    }

    public void onClick(){


    }
}
