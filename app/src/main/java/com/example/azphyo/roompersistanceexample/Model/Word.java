package com.example.azphyo.roompersistanceexample.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by aungzinphyo on 3/27/2018.
 */

@Entity (tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")

    private String mWord;

    public Word(@NonNull String word){
        this.mWord = word;
    }

    public String getWord() {
        return this.mWord;
    }
}
