package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders>  {
	
	public static final Logger LOGGER = LogManager.getLogger();

    private OrdersDAO orderDAO;
    private Utils utils;

    public OrdersController(OrdersDAO orderDAO, Utils utils) {
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
    }

    /**
     * Reads all orders to the logger
     */
    @Override
    public List<Orders> readAll() {
        List<Orders> orders = orderDAO.readAll();
        for (Orders order : orders) {
            LOGGER.info(order.toString());
        }
        return orders;
    }

    /**
     * Creates a order by taking in user input
     */
    @Override
    public Orders create() {
        LOGGER.info("Please enter a product ID");
        Long itemid = utils.getLong();
        LOGGER.info("Please enter a customer ID");
        Long customerid = utils.getLong();
        LOGGER.info("Please enter a Quantity");
        Long quantity = utils.getLong();
        Orders order = orderDAO.create(new Orders(itemid, customerid, quantity));
        LOGGER.info("Order created");
        return order;
    }

    /**
     * Updates an existing order by taking in user input
     */
    @Override
    public Orders update() {
        //TODO: require to update this section
        LOGGER.info("Please enter the id of the order you would like to update");
        Long orderid = utils.getLong();
        LOGGER.info("Please enter a product ID");
        Long itemid = utils.getLong();
        LOGGER.info("Please enter a customer ID");
        Long customerid = utils.getLong();
        Orders order = orderDAO.update(new Orders(orderid, itemid, customerid));
        LOGGER.info("Order Updated");
        return order;
    }

    /**
     * Deletes an existing order by the id of the order
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the ID of the order you would like to delete");
        Long orderid = utils.getLong();
        return orderDAO.delete(orderid);
    }

}
