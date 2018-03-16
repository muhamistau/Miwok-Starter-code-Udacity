package com.example.android.miwok;

/**
 * Created by islam on 3/15/2018.
 */

public class Word {
    //Contain Default Translation
    private String mDefaultTranslation;
    //Contain Miwok Translation
    private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
}
