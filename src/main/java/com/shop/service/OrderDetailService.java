package com.shop.service;

import com.shop.entity.OrderDetail;
import com.shop.entity.Product;
import com.shop.repository.OrderDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    public List<OrderDetail> findAll(){
        return orderDetailRepo.findAll();
    }
    public OrderDetail findById(Long id){
        Optional<OrderDetail> orderDetail = orderDetailRepo.findById(id);
        return orderDetail.orElse(null);
    }
    public OrderDetail save(OrderDetail orderDetail){
        return orderDetailRepo.save(orderDetail);
    }
    public void delete(OrderDetail orderDetail){
        orderDetailRepo.delete(orderDetail);
    }

    public void deleteById(Long id){
        orderDetailRepo.deleteById(id);
    }

    public void importData(List<Product> orderDetails , String tex) {
        for (Product o : orderDetails) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(o.getId());
            orderDetail.setTextId(tex);
            orderDetail.setProductId(o.getId());
            orderDetail.setProduct(o.getName());
            orderDetail.setQuantity(o.getQuantity());
            orderDetail.setPrice(o.getPrice());
            orderDetailRepo.save(orderDetail);
        }
    }


    public List<OrderDetail> findByTextId(String textId){
        return orderDetailRepo.findByTex(textId);
    }

}
