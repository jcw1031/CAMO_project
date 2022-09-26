package jcw.CafeMenuApp.domain;

public class CafeMenu {
    private Long menuId; //메뉴번호(PK)
    private Long cafeId; //카페번호(PK)(FK)
    private String menuName; //메뉴 이름
    private int menuPrice; //메뉴 가격
    private boolean couponAvailability; //쿠폰 사용 가능 여부

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public boolean isCouponAvailability() {
        return couponAvailability;
    }

    public void setCouponAvailability(boolean couponAvailability) {
        this.couponAvailability = couponAvailability;
    }
}
