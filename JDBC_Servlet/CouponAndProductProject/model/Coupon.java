package model;

public class Coupon {
    private int id;
    private String code;
    private long discount;
    private String expDate;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCode(String name) {
        this.code = name;
    }

    public String getCode() {
        return code;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public long getDiscount() {
        return discount;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpDate() {
        return expDate;
    }

    @Override
    public String toString() {
        return "Coupon [id=" + id + ", code=" + code + ", discount=" + discount + ", expDate=" + expDate + "]";
    }
}
