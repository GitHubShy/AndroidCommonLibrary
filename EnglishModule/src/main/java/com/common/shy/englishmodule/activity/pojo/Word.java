package com.common.shy.englishmodule.activity.pojo;

public class Word {

    private String word;
    private String englishExplanation;
    private String chineseExplanation;
    private String phonetic;

    private String wrongWord;

    public void setWrongWord(String wrongWord) {
        this.wrongWord = wrongWord;
    }

    public Word(String word, String englishExplanation, String chineseExplanation, String phonetic) {
        this.word = word;
        this.englishExplanation = englishExplanation;
        this.chineseExplanation = chineseExplanation;
        this.phonetic = phonetic;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getEnglishExplanation() {
        return englishExplanation;
    }

    public void setEnglishExplanation(String englishExplanation) {
        this.englishExplanation = englishExplanation;
    }

    public String getChineseExplanation() {
        return chineseExplanation;
    }

    public void setChineseExplanation(String chineseExplanation) {
        this.chineseExplanation = chineseExplanation;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getWrongWord() {
        return wrongWord;
    }

    public static class WordBuilder {
        private String word;
        private String englishExplanation;
        private String chineseExplanation;
        private String phonetic;

        public WordBuilder word(String word) {
            this.word = word;
            return this;
        }

        public WordBuilder chineseExplanation(String chineseExplanation) {
            this.chineseExplanation = chineseExplanation;
            return this;
        }

        public WordBuilder phonetic(String phonetic) {
            this.phonetic = phonetic;
            return this;
        }

        public WordBuilder englishExplanation(String englishExplanation) {
            this.englishExplanation = englishExplanation;
            return this;
        }

        public Word build() {
            return new Word(this.word, this.englishExplanation, this.chineseExplanation, this.phonetic);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("word=" + word);
        sb.append("---");
        sb.append("chineseExplanation=" + chineseExplanation);
        sb.append("---");
        sb.append("englishExplanation=" + englishExplanation);
        sb.append("---");
        sb.append("phonetic=" + phonetic);
        return sb.toString();
    }
}
