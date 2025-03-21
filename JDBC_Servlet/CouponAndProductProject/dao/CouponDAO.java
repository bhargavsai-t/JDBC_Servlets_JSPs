package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Coupon;
import util.ConnectionUtil;

public class CouponDAO {

    public void save(Coupon coupon) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into coupon (code,discount, exp_date) values(?,?,?)");
            ps.setString(1, coupon.getCode());
            ps.setLong(2, coupon.getDiscount());
            ps.setString(3, coupon.getExpDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Coupon findByCode(String code) {
        Coupon c = new Coupon();
        Connection conn = ConnectionUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from coupon where code=?");
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setCode(rs.getString("code"));
                c.setDiscount(rs.getLong("discount"));
                c.setExpDate(rs.getString("exp_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

}
