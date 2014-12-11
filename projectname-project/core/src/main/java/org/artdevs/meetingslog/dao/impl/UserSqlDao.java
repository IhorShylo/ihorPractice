package org.artdevs.meetingslog.dao.impl;

import org.artdevs.meetingslog.dao.UserDAO;
import org.artdevs.meetingslog.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Slava on 11.12.2014.
 */
@Component
public class UserSqlDao implements UserDAO{

    @Autowired
    NamedParameterJdbcTemplate namedParamTemplate;

    private RowMapper<User> userRowMapper=new RowMapper<User>(){
        public User mapRow (ResultSet res,int rowNum)throws SQLException {
            return new User(
                    res.getInt("id"),
                    res.getString("login"),
                    res.getString("password"),
                    res.getString("firstName"),
                    res.getString("secondName"),
                    res.getString("email"),
                    res.getString("comment"),
                    res.getDate("tmLastLogin"),
                    res.getDate("tmRegistered")
            );
        }
    };

    @Override
    public List<User> getAll(){
        final String qryStr="SELECT * FROM 'users'";

        return namedParamTemplate.query(qryStr, userRowMapper);
    }

    @Override
    public List<User> getByEmail(String email) {
        final String qryStr="SELECT * FROM 'users' WHERE 'email'=:email";

        Map<String,Object> mapPars=new HashMap<String,Object>();
        mapPars.put(":email",email);

        return namedParamTemplate.query(qryStr,mapPars, userRowMapper);
    }

    @Override
    public User findById(int id) {
        final String qryStr="SELECT * FROM 'users' WHERE 'id'=:id";

        Map<String,Object> mapPars=new HashMap<String,Object>();
        mapPars.put(":id",id);

        return namedParamTemplate.queryForObject(qryStr,mapPars, userRowMapper);
    }

    @Override
    public User findByLogin(String login) {
        final String qryStr="SELECT * FROM 'users' WHERE 'login'=:login";

        Map<String,Object> mapPars=new HashMap<String,Object>();
        mapPars.put(":login",login);

        return namedParamTemplate.queryForObject(qryStr,mapPars, userRowMapper);
    }

    @Override
    public void insert(User user) {
        StringBuilder qryStrBuilder=new StringBuilder();
        qryStrBuilder.append("INSERT INTO 'users' SET ");

        Field[] userFields = User.class.getFields();

        for(int i=0; i<userFields.length; i++){
            if(!userFields[i].getName().equals("id")){
                qryStrBuilder.append(userFields[i].getName()+"=:"+userFields[i].getName());
                if(i!=userFields.length-1){
                    qryStrBuilder.append(",");
                }

            }
        }

        final String qryStr=qryStrBuilder.toString();

        Map<String,Object> mapPars=new HashMap<String,Object>();

        try{
            for(int i=0; i<userFields.length; i++){
                Object dummy = new Object();
                if(!userFields[i].getName().equals("id"))
                    mapPars.put(":" + userFields[i].getName(),
                            user.getClass().getDeclaredField(userFields[i].getName()).get(dummy));
            }
        }catch(NoSuchFieldException exept){throw new RuntimeException("DB-model incompatibility",exept);}
        catch (IllegalAccessException exept) {throw new RuntimeException("DB-model incompatibility",exept);}

        namedParamTemplate.update(qryStr,mapPars);
    }

    @Override
    public void updateById(User user) {
        StringBuilder qryStrBuilder=new StringBuilder();
        qryStrBuilder.append("UPDATE 'users' SET");

        Map<String,Object> mapPars=new HashMap<String,Object>();

        Field[] userFields = User.class.getFields();

        try{

            for(int i=0; i<userFields.length; i++){
                if(!(userFields[i].getName().equals("id") ||
                        user.getClass().getDeclaredField(userFields[i].getName()).equals(null))) {

                    qryStrBuilder.append(userFields[i].getName() + "=:" + userFields[i].getName());
                    if(i!=userFields.length-1){
                        qryStrBuilder.append(",");
                    }
                }
            }

            qryStrBuilder.append(" WHERE id=:id");

            for(int i=0; i<userFields.length; i++){
                if(!user.getClass().getDeclaredField(userFields[i].getName()).equals(null))
                    mapPars.put(":" + userFields[i].getName(),user.getClass().getDeclaredField(userFields[i].getName()));
            }
        }catch(NoSuchFieldException exept){throw new RuntimeException("DB-model incompatibility",exept);}

        final String qryStr=qryStrBuilder.toString();

        namedParamTemplate.update(qryStr,mapPars);
    }

    @Override
    public void updateByLogin(User user) {
        StringBuilder qryStrBuilder=new StringBuilder();
        qryStrBuilder.append("UPDATE 'users' SET");

        Map<String,Object> mapPars=new HashMap<String,Object>();

        Field[] userFields = User.class.getFields();

        try{

            for(int i=0; i<userFields.length; i++){
                if(!(userFields[i].getName().equals("login") ||
                        user.getClass().getDeclaredField(userFields[i].getName()).equals(null))) {

                    qryStrBuilder.append(userFields[i].getName() + "=:" + userFields[i].getName());
                    if(i!=userFields.length-1){
                        qryStrBuilder.append(",");
                    }
                }
            }

            qryStrBuilder.append(" WHERE login=:login");

            for(int i=0; i<userFields.length; i++){
                if(!user.getClass().getDeclaredField(userFields[i].getName()).equals(null))
                    mapPars.put(":" + userFields[i].getName(),user.getClass().getDeclaredField(userFields[i].getName()));
            }
        }catch(NoSuchFieldException exept){throw new RuntimeException("DB-model incompatibility",exept);}

        final String qryStr=qryStrBuilder.toString();

        namedParamTemplate.update(qryStr,mapPars);
    }

    @Override
    public void removeById(int id) {

        Map<String,Object> mapPars=new HashMap<String,Object>();

        mapPars.put(":id",id);

        final String qryStr="DELETE FROM 'users' WHERE id=:id";

        namedParamTemplate.update(qryStr,mapPars);
    }

    @Override
    public void removeByLogin(int login) {
        Map<String,Object> mapPars=new HashMap<String,Object>();

        mapPars.put(":login",login);

        final String qryStr="DELETE FROM 'users' WHERE login=:login";

        namedParamTemplate.update(qryStr,mapPars);
    }

    @Override
    public boolean checkPassword(String login, String password) {
        User usr=findByLogin(login);
        
        return usr.getPassword().equals(password);
    }
}
