package com.DAO;

import java.sql.Connection;

public class UserDAOImpl implements UserDAO{

    private Connection conn;

    public UserDAOImpl(Connection conn){
        super();
        this.conn=conn;
    }

    public boolean userRegister(User us){
        boolean f=false;
        try{
            Stringg sql="insert into user(name,email,phno,password)values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, us.getName());
            s.setString(2, us.getEmail());
            s.setString(3, us.getPhno());
            s.setString(4, us.getPassword());

            int i=ps.executeUpdate();
            if(i==1)
            {
                f=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public boolean login(String email,String password){
        boolean f=false;

        try{
            String sql="select"from user where email=? and password=?"
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                us=new User();
                us.setId(rs.getInt(1));
                us.setName(rs.getInt(2));
                us.setEmail(rs.getInt(3));
                us.setPhno(rs.getInt(4));
                us.setPassword(rs.getInt(5));
                us.setAddress(rs.getInt(6));
                us.setLandmark(rs.getInt(7));
                us.setCity(rs.getInt(8));
                us.setState(rs.getInt(9));
                us.setPincode(rs.getInt(10));
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return us;
    }
}