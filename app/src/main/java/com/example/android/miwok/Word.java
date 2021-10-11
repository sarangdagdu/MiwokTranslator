package com.example.android.miwok;

/**
 * Represents the single word.
 * This class holds both default and miwok words.
 */
public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mRawResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mRawResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mRawResourceId = mRawResourceId;
    }

    /**
     * Parametrized Constructor to hold the translation along with the image resource id
     * needed in the activities.
     *
     * @param mDefaultTranslation English Word
     * @param mMiwokTranslation   Miwok Translation
     * @param mImageResourceId    Resource Id of the image corresponding to the translation.
     */
    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId, int mRawResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mRawResourceId = mRawResourceId;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public void setmMiwokTranslation(String mMiwokTranslation) {
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public int getmRawResourceId() {
        return mRawResourceId;
    }
    /**
     * Check if there is an image for the word.
     *
     * @return boolean value
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
