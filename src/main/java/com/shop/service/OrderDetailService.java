package com.shop.service;

import com.shop.entity.OrderDetail;
import com.shop.repository.OrderDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    public List<OrderDetail> findAll(){
        return orderDetailRepo.findAll();
    }
    public OrderDetail findById(Long id){
        return orderDetailRepo.findById(id).get();
    }
    public OrderDetail save(OrderDetail orderDetail){
        return orderDetailRepo.save(orderDetail);
    }
    public void delete(OrderDetail orderDetail){
        orderDetailRepo.delete(orderDetail);
    }


}
