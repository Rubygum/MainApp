package com.rubyko.mainapp.login.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.rubyko.mainapp.login.validation.LocalValidator;
import com.rubyko.mainapp.login.validation.LocalValidatorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 20.02.16.
 */
public class RubykoEditText extends com.rey.material.widget.EditText  {

    private static final int MESSAGE_ID = 0;
    private static final int ERROR_DELAY = 500;

    private ValidateHandler mHandler = new ValidateHandler();

    public RubykoEditText(Context context) {
        super(context);
    }

    public RubykoEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RubykoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private List<LocalValidator> localValidators = new ArrayList<>();

    public void addValidator(LocalValidator localValidator){
        localValidators.add(localValidator);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        this.update(true);
        return super.onKeyUp(keyCode, event);
    }

    public void update(boolean isDelayed){
        mHandler.removeMessages(MESSAGE_ID);
        try {
            for (LocalValidator localValidator : localValidators){
                localValidator.validate();
            }
            clearError();
        } catch (LocalValidatorException e){
            final Message message = new Message();
            message.arg1 = MESSAGE_ID;
            message.obj = e;
            int delay =  isDelayed ? ERROR_DELAY : 0;
            mHandler.sendMessageDelayed(message, delay);
        }
    }

    private class ValidateHandler extends  Handler {

        @Override
        public void handleMessage(Message msg) {
            if(msg.arg1 == MESSAGE_ID){
                String message = ((LocalValidatorException)msg.obj).getMessage();
                setError(message);
            }
        }
    }

}

