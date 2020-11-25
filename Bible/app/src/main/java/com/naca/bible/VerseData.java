package com.naca.bible;

import java.io.Serializable;

public class VerseData implements Serializable {
    private String BibleID;
    private int chapNum;
    private int verseNum;
    private String verse;

    public String getBibleID() {
        return BibleID;
    }

    public void setBibleID(String bibleID) {
        BibleID = bibleID;
    }

    public int getChapNum() {
        return chapNum;
    }

    public void setChapNum(int chapNum) {
        this.chapNum = chapNum;
    }

    public int getVerseNum() {
        return verseNum;
    }

    public void setVerseNum(int verseNum) {
        this.verseNum = verseNum;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }
}
