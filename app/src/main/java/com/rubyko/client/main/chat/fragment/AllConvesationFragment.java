package com.rubyko.client.main.chat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rubyko.client.R;
import com.rubyko.client.common.RubykoClient;
import com.rubyko.client.common.RubykoFragment;
import com.rubyko.client.common.database.Database;
import com.rubyko.client.login.fragment.LoadingFragment;
import com.rubyko.client.main.MainRubykoActivity;
import com.rubyko.server.RubykoServer;
import com.rubyko.shared.common.login.model.AccessCard;
import com.rubyko.shared.peer.chat.ChatBox;
import com.rubyko.shared.peer.chat.impl.ChatBoxImpl;

import java.io.Serializable;

/**
 * Created by alex on 28.02.16.
 */
public class AllConvesationFragment extends RubykoFragment<MainRubykoActivity> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle savedInstanceState) {
        final View view = pInflater.inflate(R.layout.fragment_allconversation, pContainer, false);
        try {
            AccessCard accessCard = Database.getDatabase().get(AccessCard.class.getName());
            LoadingFragment.show(getFragmentActivity(), new AllConversationRunnable(this, accessCard));
        } catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
        return view;
    }
}

class AllConversationRunnable implements Runnable, Serializable {

    private final AccessCard mAccessCard;
    private final AllConvesationFragment allConvesationFragment;

    public AllConversationRunnable(AllConvesationFragment allConvesationFragment, final AccessCard pAccessCard) {
        this.mAccessCard = pAccessCard;
        this.allConvesationFragment = allConvesationFragment;
    }

    @Override
    public void run() {
        try {
            // create the RMI server
            final AccessCard accessCard =  Database.getDatabase().get(AccessCard.class.getName());
            RubykoServer.registerService("11111", new ChatBoxImpl(accessCard, "111"));
            RubykoServer.start();
            final ChatBox chatBox = RubykoClient.lookupService(RubykoServer.getInstance().getNetInfo(), ChatBox.class, "11111");
            allConvesationFragment.getFragmentActivity().runOnUiThread(new AllConversationSucessRunnable(chatBox));
        } catch (final Exception e) {
            allConvesationFragment.getFragmentActivity().runOnUiThread(new AllConversationExceptionRunnable(e));
        }
    }

    private void hideLoadingFragment() {
        final FragmentManager fragmentManager = allConvesationFragment.getFragmentActivity().getSupportFragmentManager();
        fragmentManager.popBackStackImmediate();
    }

    private class AllConversationSucessRunnable implements Runnable {

        private final ChatBox chatBox;

        public AllConversationSucessRunnable(ChatBox chatBox) {
            this.chatBox = chatBox;
        }

        @Override
        public void run() {
            hideLoadingFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(ChatBox.class.getName(), chatBox);
            allConvesationFragment.getFragmentActivity().replaceFragment(bundle, SpecificConversationFragment.class);
        }
    }

    private class AllConversationExceptionRunnable implements Runnable {

        final Exception exception;

        public AllConversationExceptionRunnable(Exception exception) {
            this.exception = exception;
        }

        @Override
        public void run() {
            Toast.makeText(allConvesationFragment.getFragmentActivity(), exception.getMessage(), Toast.LENGTH_SHORT).show();
            hideLoadingFragment();
        }
    }


}