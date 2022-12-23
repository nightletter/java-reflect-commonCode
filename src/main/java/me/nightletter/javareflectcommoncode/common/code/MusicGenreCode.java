package me.nightletter.javareflectcommoncode.common.code;

@CommonCodeAnnotation
public enum MusicGenreCode implements CommonCodeInterface {

    JAZZ("재즈", "재즈"),
    BALLADE("발라드", "발라드"),
    RAP("랩", "랩"),
    ROCK("락","락");

    private final String nm;
    private final String dc;

    MusicGenreCode(String nm, String dc) {
        this.nm = nm;
        this.dc = dc;
    }

    @Override
    public String nm() {
        return this.nm;
    }

    @Override
    public String dc() {
        return this.dc;
    }

    @Override
    public String groupNm() {
        return this.getClass().getSimpleName();
    }
}
