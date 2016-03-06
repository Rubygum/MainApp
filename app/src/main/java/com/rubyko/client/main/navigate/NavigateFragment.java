package com.rubyko.client.main.navigate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rubyko.client.R;
import com.rubyko.client.common.database.Database;
import com.rubyko.client.login.LoginRubykoActivity;
import com.rubyko.client.common.RubykoFragment;
import com.rubyko.client.main.MainRubykoActivity;
import com.rubyko.client.main.chat.fragment.AllConvesationFragment;
import com.rubyko.shared.common.login.model.AccessCard;

import java.io.IOException;


/**
 * Created by alex on 24.02.16.
 */
public class NavigateFragment extends RubykoFragment<MainRubykoActivity> implements View.OnClickListener {


    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        final View view = pInflater.inflate(R.layout.fragment_navigate, pContainer, false);

        final Button navigateChatBtn = (Button) view.findViewById(R.id.navigate_chat_btn);
        final Button navigateLogoutBtn = (Button) view.findViewById(R.id.navigate_logout_btn);
        final Button navigateVideoCallBtn = (Button) view.findViewById(R.id.navigate_videocall_btn);
        final Button navigateCollisiobBtn = (Button) view.findViewById(R.id.navigate_collision_btn);
        final Button navigateAccountBtn = (Button) view.findViewById(R.id.navigate_account_btn);
        final Button navigateSettingBtn = (Button) view.findViewById(R.id.navigate_setting_btn);

        navigateChatBtn.setOnClickListener(this);
        navigateLogoutBtn.setOnClickListener(this);
        navigateVideoCallBtn.setOnClickListener(this);
        navigateCollisiobBtn.setOnClickListener(this);
        navigateAccountBtn.setOnClickListener(this);
        navigateSettingBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigate_logout_btn:
                performLogout();
                break;
            case R.id.navigate_chat_btn:
                openChatRooms();
                break;
        }
    }

    private void performLogout(){
        try {
            Database.getDatabase().save(null, AccessCard.class.getName());
            Intent intent = new Intent(this.getFragmentActivity(), LoginRubykoActivity.class);
            startActivity(intent);
            getFragmentActivity().finish();
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void openChatRooms(){
        getFragmentActivity().replaceFragment(new Bundle(), AllConvesationFragment.class);
    }

}
