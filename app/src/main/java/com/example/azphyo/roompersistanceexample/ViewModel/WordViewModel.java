package com.example.azphyo.roompersistanceexample.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.azphyo.roompersistanceexample.Model.Word;
import com.example.azphyo.roompersistanceexample.Repository.WordRepository;

import java.util.List;

/**
 * Created by aungzinphyo on 3/27/2018.
 */

public class WordViewModel extends AndroidViewModel{

    private WordRepository mRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return  mAllWords;
    }

    public void insert(Word word){
        mRepository.insert(word);
    }
}
