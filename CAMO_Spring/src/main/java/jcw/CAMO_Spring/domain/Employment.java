package jcw.CafeMenuApp.domain;

public class Employment {
    private Long cafeId; //카페번호(FK)
    private Long presidentId; //사장번호(FK)
    private Long staffId; //직원번호
    private String staffName; //직원이름

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

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
