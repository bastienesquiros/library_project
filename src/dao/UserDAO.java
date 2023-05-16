package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import entity.User;
import main.Connect;

public class UserDAO implements DAO<User> {

    @Override
    public User findAll() {
       try {
        PreparedStatement prepare = Connect.getConnection().prepareStatement("SELECT * FROM user");
        ResultSet result = prepare.executeQuery();
        List<User> users = new ArrayList<>();

       }
    }

    @Override
    public User find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public User create(User obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public User delete(User obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public User update(User obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
