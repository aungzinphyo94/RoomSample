package com.example.azphyo.roompersistanceexample.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.azphyo.roompersistanceexample.Model.Word;

import java.util.List;

/**
 * Created by aungzinphyo on 3/27/2018.
 */

@Dao
public interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();
}
