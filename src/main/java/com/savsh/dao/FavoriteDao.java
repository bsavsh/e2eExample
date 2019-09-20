package com.savsh.dao;

import com.savsh.entity.Favorite;
import com.savsh.entity.Customer;
import com.savsh.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class FavoriteDao {
    private static final Logger LOGGER = Logger.getLogger(FavoriteDao.class.getSimpleName());

    private static List<Favorite> favorites = new ArrayList<>();

    public static Favorite getFavorite() {
        Favorite favorite = new Favorite();
        favorites.add(favorite);
        return favorite;
    }

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ItemDao itemDao;

    public void addItemForUser(long itemId, long customerId) {
        Item item = itemDao.getById(itemId);
        Customer customer = customerDao.getById(customerId);
        customer.getFavorite().addItem(item);
        LOGGER.log(Level.INFO, "add to favorite item: " + itemId + " to customer: " + customerId);
    }
}
