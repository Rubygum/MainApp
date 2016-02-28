package com.rubyko.client.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.rubyko.client.common.database.Database;
import com.rubyko.client.login.LoginRubykoActivity;
import com.rubyko.client.main.MainRubykoActivity;
import com.rubyko.shared.common.login.model.User;


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
            final User user = Database.getDatabase().get(User.class.getName());
            final Intent intent;
            if(user != null && user.isTokenValid()){
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
