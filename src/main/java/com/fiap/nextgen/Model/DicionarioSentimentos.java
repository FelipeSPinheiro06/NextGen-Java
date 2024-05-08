package com.fiap.nextgen.Model;

public enum DicionarioSentimentos {

    TERRIBLE(1),
    BAD(2),
    REGULAR(3),
    GOOD(4),
    AWESOME(5);

    private int feeling;

    DicionarioSentimentos(int feeling) {
        this.feeling = feeling;
    }

    DicionarioSentimentos() {

    }

    public int getFeeling() {
        return feeling;
    }
}
