package com.qa.ims.persistence.dao;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


public class OrdersDAOTest {
	
	private final OrdersDAO DAO = new OrdersDAO();

    @Before
    public void setup() {
        DBUtils.connect("src/test/resources/db.properties");
        DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

    @Test
    public void testCreate() {
        final Orders created = new Orders(1L, 1L);
        assertEquals(created, DAO.create(created));
    }

    @Test
    public void testReadAll() {
        List<Orders> expected = new ArrayList<>();
        expected.add(new Orders(1L,1L,"Jordan Harrison", "Football",1L,2.0f,2.0f));
        assertEquals(expected, DAO.readAll());
    }
    
    @Test
    public void testReadOrder() {
        List<Orders> expected = new ArrayList<>();
        expected.add(new Orders(1L,1L,"Jordan Harrison","Football",1L,2.0f,2.0f));
        assertEquals(expected, DAO.readAll());
    }

    @Test
    public void testReadLatest() {
        assertEquals(new Orders(1L, null, null,null,null,null,null), DAO.readLatest());
    }

    @Test
    public void testRead() {
        final long ID = 2L;
        assertEquals(new Orders(ID, 1L), DAO.readOrder(ID));
    }

    @Test
    public void testUpdate() {
        final Orders updated = new Orders(1L,2L,5L);
        final Orders result = new Orders(1L,1L);
        assertEquals(result, DAO.update(updated));

    }
    
    @Test
    public void testAddItem() {
        final Orders updated = new Orders(1L,2L,5L);
        final Orders result = new Orders(1L,1L);
        assertEquals(result, DAO.update(updated));

    }

    @Test
    public void testDelete() {
        assertEquals(0,DAO.delete(2,2));
        assertEquals(0, DAO.delete(1));
    }
   /* 
    public void testDelete() {
        assertEquals(0,DAO.delete(2,2));
        assertEquals(0, DAO.delete(1));
    }
    
    public void testDelete() {
        assertEquals(0,DAO.delete(2,2));
        assertEquals(0, DAO.delete(1));
    }
    
    public void testReadCustomer() {
        assertEquals(0,DAO.delete(2,2));
        assertEquals(0, DAO.delete(1));
    }
    */
}
