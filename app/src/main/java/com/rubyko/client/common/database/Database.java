package com.rubyko.client.common.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.rubyko.client.RubykoApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/**
 * Created by alex on 27.02.16.
 */
public class Database {

    private static final Database database = new Database();

    public static Database getDatabase(){
        return database;
    }

    public void remove(){

    }

    public void save(Serializable serializable, String key) throws IOException {
        FileOutputStream fos = RubykoApplication.getInstance().openFileOutput(key, Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(serializable);
        os.close();
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) throws  IOException, ClassNotFoundException {
        FileInputStream fis = RubykoApplication.getInstance().openFileInput(key);
        ObjectInputStream os = new ObjectInputStream(fis);
        T obj = (T) os.readObject();
        os.close();
        return obj;
    }

}
