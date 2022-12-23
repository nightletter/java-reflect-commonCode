package me.nightletter.javareflectcommoncode.common.code;

@CommonCodeAnnotation
public enum PaymentTypeCode implements CommonCodeInterface {

    COUPON("쿠폰결제", "쿠폰결제"),
    MONEY("현금결제", "현금결제");

    private final String nm;
    private final String dc;

    PaymentTypeCode(String nm, String dc) {
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
