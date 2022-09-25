package jcw.CafeMenuApp.domain;

public class Coupon {
    private Long memberId; //회원번호(PK)(FK)
    private Long cafeId; //카페번호(PK)(FK)
    private int number; //쿠폰 개수

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
