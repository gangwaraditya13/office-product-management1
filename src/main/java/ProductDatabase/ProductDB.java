package ProductDatabase;

import org.example.officeEntity.Product;

import java.sql.*;

public class ProductDB {
    Connection com = null;

    public void addProduct(Product p){
        String url = "jdbc:mysql://localhost:3306/aliens";
        String username = "root";
        String password ="Gangwar@123";
        try {
            com = DriverManager.getConnection(url, username, password);
            String createQuery = "create table if not exists OProduct(SNo int not null auto_increment primary key,productName varchar(200), type varchar(200), place varchar(200), warranty integer)";
            String query = "insert into OProduct (productName, type, place, warranty)values(?,?,?,?)";

            Statement st = com.createStatement();
            int count = st.executeUpdate(createQuery);
            System.out.println(count + " Row effected");
            PreparedStatement pst = com.prepareStatement(query);
            pst.setString(1,p.getProductName());
            pst.setString(2,p.getType());
            pst.setString(3,p.getPlace());
            pst.setInt(4,p.getWarranty());
            int count1 = pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void showProduct(){
        String url = "jdbc:mysql://localhost:3306/aliens";
        String username = "root";
        String password ="Gangwar@123";

        try {
            com = DriverManager.getConnection(url,username,password);
            String query = "select sno, productName, type, place, warranty from OProduct";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void SBP(String place) {
        String url = "jdbc:mysql://localhost:3306/aliens";
        String username = "root";
        String password ="Gangwar@123";

        try {
            com = DriverManager.getConnection(url,username,password);
            String query = "select sno, productName, type, place, warranty from OProduct";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                if(rs.getString(4).toLowerCase().contains(place.toLowerCase())){
                    System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getInt(5));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void SPOW(int year) {
        String url = "jdbc:mysql://localhost:3306/aliens";
        String username = "root";
        String password ="Gangwar@123";

        try {
            com = DriverManager.getConnection(url,username,password);
            String query = "select sno, productName, type, place, warranty from OProduct";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                if(rs.getInt(5) <= year){
                    System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getInt(5));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void SBN(String text) {
        String url = "jdbc:mysql://localhost:3306/aliens";
        String username = "root";
        String password ="Gangwar@123";

        try {
            com = DriverManager.getConnection(url,username,password);
            String query = "select sno, productName, type, place, warranty from OProduct";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                if(rs.getString(2).toLowerCase().contains(text.toLowerCase()) || rs.getString(3).toLowerCase().contains(text.toLowerCase()) || rs.getString(4).toLowerCase().contains(text.toLowerCase())){
                    System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getInt(5));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
