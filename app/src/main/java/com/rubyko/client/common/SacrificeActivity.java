package com.rubyko.client.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.rubyko.client.common.database.Database;
import com.rubyko.client.login.LoginRubykoActivity;
import com.rubyko.client.main.MainRubykoActivity;
import com.rubyko.shared.login.model.AuthedUser;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by alex on 27.02.16.
 */
public class SacrificeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            final AuthedUser authedUser = Database.getDatabase().get(AuthedUser.class.getName());
            final Intent intent;
            if(authedUser != null && authedUser.isTokenValid()){
                intent = new Intent(this, MainRubykoActivity.class);
            } else {
                intent = new Intent(this, LoginRubykoActivity.class);
            }
            startActivity(intent);
            finish();
        } catch (FileNotFoundException e){
            Intent intent = new Intent(this, LoginRubykoActivity.class);
            startActivity(intent);
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
