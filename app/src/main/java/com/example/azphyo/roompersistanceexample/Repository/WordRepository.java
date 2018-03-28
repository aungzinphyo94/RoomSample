package com.example.azphyo.roompersistanceexample.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.azphyo.roompersistanceexample.DAO.WordDao;
import com.example.azphyo.roompersistanceexample.Model.Word;
import com.example.azphyo.roompersistanceexample.database.WordRoomDatabase;

import java.util.List;

/**
 * Created by aungzinphyo on 3/27/2018.
 */

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords= mWordDao.getAlphabetizedWords();
    }

    //Room executes all queries on a separate thread.
    public LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{

        private WordDao mAsyncTaskDao;

        public insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
