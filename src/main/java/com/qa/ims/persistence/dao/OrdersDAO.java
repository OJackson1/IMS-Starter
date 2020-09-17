package com.qa.ims.persistence.dao;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.Item;



public class OrdersDAO implements Dao<Orders>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	private Utils utils = new Utils();

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderid = resultSet.getLong("orderid");
		Long customerid = resultSet.getLong("customerid");
		return new Orders(orderid, customerid);
	}

	public Orders modelOne(ResultSet resultSet) throws SQLException {
        Long orderid = resultSet.getLong("orderId");
        Long itemid = resultSet.getLong("itemid");
        String customer = resultSet.getString("customer");
        String itemName = resultSet.getString("itemName");
        Long quantity = resultSet.getLong("quantity");
        Float value = resultSet.getFloat("value");
        Float total = resultSet.getFloat("total");
        return new Orders(orderid, itemid, customer, itemName, quantity,value,total);
	}
	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery("select orders.orderid, orderItems.itemid, concat(customers.firstName,\" \", customers.surname) as customer, items.itemName, items.value, quantity,quantity*value as total from orders, orderItems, items, customers where orders.orderid = " +
	                     "orderItems.orderid and items.itemid = orderItems.itemid and orders.customerid= customers.customerid order by orders.orderid;");
				//ResultSet resultSet = statement.executeQuery("select orderid, customerid, itemid, total from orders, orderitems where orders.orderid = orderitems.orderid;");
	        )
	       {
	            List<Orders> orders = new ArrayList<>();
	            while (resultSet.next()) {
	                orders.add(modelOne(resultSet));
	            }
	            return orders;
	        } catch (SQLException e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return new ArrayList<>();
	}
	
	//reads all from orders

	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderid DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/*public Orders readCustomer() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderid DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}*/

	/**
	 * Creates an order in the database
	 * 
	 * @param order - takes in an order object. id will be ignored
	 */
	@Override
	public Orders create(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
	             Statement statement = connection.createStatement();) {
	            statement.executeUpdate("INSERT INTO orders(customerid) values('"+order.getCustomerid() + "')");
	            Orders cust =readLatest();
	            LOGGER.info(cust.getOrderid());
	            LOGGER.info("^ Here is your order ID - Please now enter an item ID");
	            Long itemid = utils.getLong();
	            LOGGER.info("Please enter a quantity");
	            Long quantity = utils.getLong();
	            statement.executeUpdate("INSERT INTO orderItems(orderid, itemid, quantity) values('" + cust.getOrderid()
	                    + "','" + itemid + "','" +quantity+"')");            
	            return cust;
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return null;
	}

	/*public Orders readItem(Long orderid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where orderid = " + orderid);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;*/
	public Orders addItem(Orders order) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            statement.executeUpdate("INSERT INTO orderItems(orderid, itemid) values('" + order.getOrderid()
                    + "','" + order.getItemid() + "')");
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
	}

	/**
	 * Updates an order in the database
	 * 
	 * @param order - takes in an order object, the id field will be used to
	 *                 update that order in the database
	 * @return
	 */
	@Override
	public Orders update(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
	             Statement statement = connection.createStatement();) {
	            statement.executeUpdate("INSERT INTO orderItems(orderid, itemid, quantity) values('" + order.getOrderid()
	                    + "','" + order.getItemid() + "','" +order.getQuantity()+"')");
	            return readOrder(order.getOrderid());
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return null;
	}

	
	/*// removes an item from an order
	public Orders updateRemoveFromOrder(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM orders WHERE orderid =" + order.getOrderid() + " AND itemid=" + order.getItemid());
			return readItem(order.getOrderid());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}*/
	
	/*//adds an item to an order
	public Orders addToOrder(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders (orderid, itemid, quantity) values (" + order.getOrderid() + ", " + order.getItemid() + ", " + order.getQuantity() + ")");
			return readItem(order.getOrderid());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;*/
	public Orders readOrder(Long orderid) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where orderid = " + orderid);) {
            resultSet.next();
            return modelOne(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
	}
	
	
	/**
	 * Deletes an order in the database
	 * 
	 * @param id - id of the order
	 */
	@Override
	public int delete(long idd) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from orders where orderid in (select orderid from orderItems where orderid = "+ idd+")");
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	public int delete(long orderid, long itemid) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            return statement.executeUpdate("delete from orderItems where orderid in (select orderid from orders where orderid = "+orderid +
                    " and itemid = "+itemid+ ")");
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
	}
	
	public int readcustomer(Long orderid) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            return statement.executeUpdate("select sum(quantity*value) as total from orders, orderItems, items where orders.orderid = orderItems.orderid and orderItems.itemid and orders.orderid =" +orderid +")");
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
	}
	
	/*public List<Orders> readcustomer() {
		try (Connection connection = DBUtils.getInstance().getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery("select sum(quantity*value) as total from orders, orderItems, items where order.orderid = orderItems.orderid and orderItems.itemid and orders.orderid = orderid =" +orderid +")");

	        )
	       {
	            List<Orders> customerorders = new ArrayList<>();
	            while (resultSet.next()) {
	                customerorders.add(modelOne(resultSet));
	            }
	            return customerorders;
	        } catch (SQLException e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return new ArrayList<>();
	}*/
	
	
	
}
