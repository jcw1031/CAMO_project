package jcw.CAMO_Spring.domain;

public class Cafe {
    private Long cafeId; //카페번호(PK)
    private Long presidentId; //회원번호와 동일(FK)
    private String cafeName; //카페 이름
    private String address; //카페 주소
    private String callNumber; //전화번호

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }

    public Long getPresidentId() {
        return presidentId;
    }

    public void setPresidentId(Long presidentId) {
        this.presidentId = presidentId;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }
}
