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
        LOGGER.info("Please enter a customer ID");
        Long customerid = utils.getLong();
        Orders order = orderDAO.create(new Orders(customerid));
        LOGGER.info("Order created");
        return order;
    }

    /**
     * Updates an existing order by taking in user input
     */
    @Override
    public Orders update() {
    	LOGGER.info("Please enter the orderid of the order you would like to update/add");
        Long orderid = utils.getLong();
        LOGGER.info("Please enter a itemid");
        Long itemid = utils.getLong();
        LOGGER.info("Please enter a quantity");
        Long quantity = utils.getLong();

        return OrdersDAO.update(new Orders(orderid,itemid,quantity));
    }

    /**
     * Deletes an existing order by the id of the order
     *
     * @return
     */
    @Override
    public int delete() {
    	LOGGER.info("Type \"item\" to delete item or \"order\" to delete order");
        String choice =utils.getString();

        switch(choice){
            case "order":
                LOGGER.info("Type orderid of the order you would like to delete");
                Long id = utils.getLong();
                return OrdersDAO.delete(id);
            case "item":
                LOGGER.info("Type the orderid of the order you would like to delete");
                Long orderid = utils.getLong();
                LOGGER.info("Type itemid of the item you would like to delete");
                Long itemid = utils.getLong();
                return OrdersDAO.delete(orderid,itemid);
            default:
                LOGGER.info("Try again");
                break;
        }
        return  0;
    }
}
