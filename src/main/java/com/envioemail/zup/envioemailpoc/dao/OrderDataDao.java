package com.envioemail.zup.envioemailpoc.dao;

import com.envioemail.zup.envioemailpoc.exception.ObjectNotFoundException;
import com.envioemail.zup.envioemailpoc.input.OrderData;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class OrderDataDao {

    private final String hashReference= "Orders";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, OrderData> hashOperations;

    public void saveOrders(OrderData emp) {
        //creates one record in Redis DB if record with that Id is not present

        if(getOneOrder(emp.getOrderNumber())!= null){
            throw new ObjectNotFoundException("Order já cadastrada!");
        }

        hashOperations.putIfAbsent(hashReference, emp.getOrderNumber(), emp);
    }

    public void saveAllOrders(Map<Integer, OrderData> map) {
        hashOperations.putAll(hashReference, map);
    }

    public OrderData getOneOrder(Integer id) {
        return hashOperations.get(hashReference, id);
    }

    public void updateOrder(OrderData emp) {
        hashOperations.put(hashReference, emp.getOrderNumber(), emp);
    }

    public Map<Integer, OrderData> getAllEmployees() {
        return hashOperations.entries(hashReference);
    }

    public void deleteOrder(Integer id) {
        hashOperations.delete(hashReference, id);
    }
}
