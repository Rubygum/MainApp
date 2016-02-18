package com.rubyko.mainapp.login.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import com.github.florent37.materialtextfield.MaterialTextField;


/**
 * Created by alex on 17.02.16.
 */
public class CustomizeTextField extends MaterialTextField {


    public CustomizeTextField(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void handleAttributes(Context context, AttributeSet attrs) {
        super.handleAttributes(context, attrs);
        try {
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, com.github.florent37.materialtextfield.R.styleable.MaterialTextField);

            {
                ANIMATION_DURATION = styledAttrs.getInteger(com.github.florent37.materialtextfield.R.styleable.MaterialTextField_mtf_animationDuration, 400);
            }
            {
                OPEN_KEYBOARD_ON_FOCUS = styledAttrs.getBoolean(com.github.florent37.materialtextfield.R.styleable.MaterialTextField_mtf_openKeyboardOnFocus, false);
            }
            {
                labelColor = styledAttrs.getColor(com.github.florent37.materialtextfield.R.styleable.MaterialTextField_mtf_labelColor, Color.BLACK);
            }
            {
                cardColor = styledAttrs.getColor(com.github.florent37.materialtextfield.R.styleable.MaterialTextField_mtf_cardColor, Color.parseColor("#e0e0e0"));
            }
            {
                imageDrawableId = styledAttrs.getResourceId(com.github.florent37.materialtextfield.R.styleable.MaterialTextField_mtf_image, -1);
            }

            styledAttrs.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
