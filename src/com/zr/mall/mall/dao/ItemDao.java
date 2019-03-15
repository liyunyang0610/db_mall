package com.zr.mall.mall.dao;

import com.zr.mall.framework.DruidDbUtil;
import com.zr.mall.mall.entity.Items;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ItemDao {

    //学会使用dcutil
    private QueryRunner qr = new QueryRunner(DruidDbUtil.getDataSource());

    public List<Items> findAll(){

        String sql = "select * from items";
        List<Items> itemsList = null;
        try {
            itemsList = qr.query(sql, new BeanListHandler<>(Items.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemsList;
    }


    public Items findById(int id){

        String sql = "select * from items where id = ?";
        Items items = null;
        try {
            items = qr.query(sql, new BeanHandler<>(Items.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    public int add(Items items){

        Object[] objs =  {items.getName(),items.getCity(),items.getPrice(),items.getNumber(),items.getPicture()};
        String sql = "insert into items(name,city,price,number,picture)";
        try {
            int i = qr.update(sql,objs);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }





}
