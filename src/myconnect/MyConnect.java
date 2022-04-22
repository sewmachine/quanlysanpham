/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconnect;

//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author minht
 */
public class MyConnect {

    /**
     * @param args the command line arguments
     */
    static String url ="jdbc:mysql://localhost:3306/qlsp";
    static String user ="root";
    static String password="";
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = (Connection) DriverManager.getConnection(url, user, password);
    } catch(Exception ex){
        ex.printStackTrace();
    }
        return conn;
    }
    public static List<Product> findAll(){
        List<Product> productList = new ArrayList<>();
        String query = "select * from sanpham";
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Product prd = new Product(rs.getInt("maSp"),rs.getString("tenSp"),rs.getString("xuatXu"),rs.getInt("soLuong"),rs.getInt("giaTien"));
                productList.add(prd);
            }
        } catch(Exception ex){
            
        }
        return productList;
    }
    
    public static List<Product> findAllAlmostOver(){
        List<Product> productList = new ArrayList<>();
        String query = "select * from sanpham where soluong < 10 AND soluong>0";
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Product prd = new Product(rs.getInt("maSp"),rs.getString("tenSp"),rs.getString("xuatXu"),rs.getInt("soLuong"),rs.getInt("giaTien"));
                productList.add(prd);
            }
        } catch(Exception ex){
            
        }
        return productList;
    }
    
    public static List<Product> findAllOver(){
        List<Product> productList = new ArrayList<>();
        String query = "select * from sanpham where soluong = 0 ";
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Product prd = new Product(rs.getInt("maSp"),rs.getString("tenSp"),rs.getString("xuatXu"),rs.getInt("soLuong"),rs.getInt("giaTien"));
                productList.add(prd);
            }
        } catch(Exception ex){
            
        }
        return productList;
    }
    
    public static void insert(Product prd){
        String query ="INSERT INTO sanpham(masp,tensp,xuatxu,soluong,giatien) values (?,?,?,?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, prd.getMaSp());
            pstmt.setString(2, prd.getTenSp());
            pstmt.setString(3, prd.getXuatXu());
            pstmt.setInt(4, prd.getSoLuong());
            pstmt.setInt(5, prd.getGiaTien());
            pstmt.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    public static void delete(Product prd){
        String query = "delete from sanpham where masp = '"+prd.getMaSp()+"'";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.execute();
        } catch (Exception e) {
        }
    }
    public static void update (Product prd){
        String query = "update sanpham where set tensp=?,xuatxu=?,soluong=?,giatien=? where tensp = '"+prd.getTenSp()+"'";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prd.getTenSp());
            pstmt.setString(2, prd.getXuatXu());
            pstmt.setInt(3, prd.getSoLuong());
            pstmt.setInt(4, prd.getGiaTien());
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static List<Product> findByName(Product p){
        List<Product> productLt = new ArrayList<>();
        String query = "select * from sanpham where tensp = '"+p.getTenSp()+"' OR masp = '"+p.getTenSp()+"' OR xuatxu = '"+p.getTenSp()+"'";
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Product prd = new Product(rs.getInt("maSp"),rs.getString("tenSp"),rs.getString("xuatXu"),rs.getInt("soLuong"),rs.getInt("giaTien"));
                productLt.add(prd);
            }
        } catch(Exception ex){
            
        }
        return productLt;
    }

    public static void register(User user){
        String query ="INSERT INTO information(username,password,fullname,email) values (?,?,?,?)";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFullname());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    public static List<User> findUser(User us){
        List<User> userList = new ArrayList<>();
        String query = "select * from information where username = '"+us.getUsername()+"' AND password = '"+us.getPassword()+"'";
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            if(rs.next()){

              FormProduct fp = new FormProduct();
              fp.setVisible(true);
             
            }else {
                JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
            }
        } catch(Exception ex){
            
        }
        return userList;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Login lg = new Login();
        lg.setVisible(true);
        
    }
    
}
