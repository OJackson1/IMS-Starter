package com.qa.ims.persistence.dao;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.utils.Utils;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;
import org.junit.runner.RunWith;


public class OrdersDAOTest {
	
	private final OrdersDAO DAO = new OrdersDAO();

    @Before
    public void setup() {
        DBUtils.connect("src/test/resources/db.properties");
        DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

    @Test
    public void testCreate() {
        final Orders created = new Orders(2L, 1L);
        assertEquals(created, DAO.create(created));
    }

    @Test
    public void testReadAll() {
        List<Orders> expected = new ArrayList<>();
        expected.add(new Orders(1L,3L,"Jordan Harrison","Hat",6L,4.0f,24.0f));
        expected.add(new Orders(1L,2L,"Jordan Harrison","Yoyo",10L,3.0f,30.0f));
        expected.add(new Orders(2L,2L,"Owen Jackson","Yoyo",8L,3.0f,24.0f));
        expected.add(new Orders(3L,5L,"Theo Thuckthunder","Fan",10L,23.5f,235.0f));
        expected.add(new Orders(4L,2L,"Dick Dickerson","Yoyo",4L,3.0f,12.0f));
        assertEquals(expected, DAO.readAll());
    }

    @Test
    public void testReadLatest() {
        assertEquals(new Orders(2L, 2L), DAO.readLatest());
    }

    @Test
    public void testRead() {
        final long ID = 1L;
        assertEquals(new Orders(ID, 1L), DAO.readOrder(ID));
    }

    @Test
    public void testUpdate() {
        final Orders updated = new Orders(1L,2L,5L);
        final Orders result = new Orders(1L,1L);
        assertEquals(result, DAO.update(updated));

    }

    @Test
    public void testDelete() {
        assertEquals(0,DAO.delete(2,2));
        assertEquals(0, DAO.delete(1));
    }

}
