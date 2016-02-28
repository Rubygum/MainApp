package com.rubyko.client.main.chat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rubyko.client.R;
import com.rubyko.client.common.RubykoClient;
import com.rubyko.client.common.RubykoFragment;
import com.rubyko.client.main.MainRubykoActivity;
import com.rubyko.client.main.chat.adapter.ChatRecyclerViewAdapter;
import com.rubyko.shared.peer.chat.Conversation;
import com.rubyko.shared.common.chat.model.Message;

/**
 * Created by alex on 27.02.16.
 */
public class SpecificConversationFragment extends RubykoFragment<MainRubykoActivity> implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ChatRecyclerViewAdapter mAdapter;
    private EditText mMessageEdt;
    private Conversation mConversation = (Conversation) getArguments().getSerializable(Conversation.class.getName());


    @Nullable
    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle savedInstanceState) {
        final View view = pInflater.inflate(R.layout.fragment_chat, pContainer, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.chat_recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getFragmentActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ChatRecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);

        final Button sendBtn = (Button) view.findViewById(R.id.chat_message_send_btn);
        mMessageEdt = (EditText) view.findViewById(R.id.chat_message_content_edt);
        sendBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chat_message_send_btn:
                final Message message = new Message(mMessageEdt.getText().toString());

                mConversation = RubykoClient.lookupService(mConversation.getCurrentUser(), Conversation.class, "111");
                mConversation.send(message);

                mRecyclerView.smoothScrollToPosition(mAdapter.getItemCount());
                break;
        }
    }



}
