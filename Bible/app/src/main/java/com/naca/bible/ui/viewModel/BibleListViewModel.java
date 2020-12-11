package com.naca.bible.ui.viewModel;

import android.content.res.AssetManager;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;


public class BibleListViewModel extends ViewModel {
    private ObservableArrayList<BibleListItemViewModel> bibleListItemViewModels;

    public BibleListViewModel(){
        bibleListItemViewModels = new ObservableArrayList<>();
    }

    public ObservableArrayList<BibleListItemViewModel> getBibleListItemViewModels() {
        return this.bibleListItemViewModels;
    }

    public void addListItem(String[] chapterset){
        for(int i = 0;i<chapterset.length;i++)
            bibleListItemViewModels.add(new BibleListItemViewModel(chapterset[i]));
    }
}
