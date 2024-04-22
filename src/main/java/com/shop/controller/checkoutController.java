package com.shop.controller;

import com.shop.entity.Cart;
import com.shop.entity.Order;
import com.shop.entity.OrderDetail;
import com.shop.entity.Product;
import com.shop.service.ItemService;
import com.shop.service.OrderDetailService;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/checkout")
public class checkoutController {

    @Autowired
    OrderService orderService;

    @Autowired
    private ItemService itemService;

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping
    public String checkout(Model model) {

        // Date
        LocalDate date = LocalDate.now();
        model.addAttribute("date", date);

        long micrometer = java.time.Instant.now().toEpochMilli();
        int numInvoice = (int) micrometer;
        model.addAttribute("coexistence", numInvoice);


        List<Product> item = itemService.getItemList();
        model.addAttribute("item", item);

        Double subTotal = itemService.calculatetotalAmount();
        model.addAttribute("subTotal", subTotal);

        DecimalFormat df = new DecimalFormat("#.00");
        Double ss = Double.valueOf(df.format(subTotal));
        model.addAttribute("ss", ss);

        // tex
        Double tet = 0d;
        Double vat7 = (subTotal * 7) / 100 ;
        Double vat = Double.valueOf(df.format(vat7));
        model.addAttribute("vat", vat);

        // TotalPrice
        Double gandTotal = 0d;
        gandTotal = subTotal + vat7;
        Double totalPrice = Double.valueOf(df.format(gandTotal));
        model.addAttribute("totalPrice", totalPrice);

        return "checkout";
    }

    @GetMapping("/invoice-print")
    public String invoicePrint(Model model) {
        return "invoice-print";
    }

    @PostMapping("/invoice")
    public String checkoutInvoice(
            @RequestParam("id") int id,
            @RequestParam("tex") String tex , Model model) {

        Order order = orderService.findById(id);
        model.addAttribute("order", order);

        List<OrderDetail> orderDetail = orderDetailService.findByTextId(tex);
        model.addAttribute("item", orderDetail);

        DecimalFormat df = new DecimalFormat("#.00");

        Double totalPrice = 0d;
        totalPrice = Double.valueOf(order.getTotalPrice());
        model.addAttribute("totalPrice", totalPrice);

        System.out.println(totalPrice);

        Double subTotal = 0d;
        subTotal = Double.valueOf(df.format((totalPrice * 100) / 107));
        Double vat7 = Double.valueOf(df.format((subTotal * 7) / 100));
        model.addAttribute("subTotal", subTotal);
        model.addAttribute("vat", vat7);

        return "invoice";
    }


    @PostMapping("/finish")
    public String finish(
                        @RequestParam("tex") String tex,
                        @RequestParam("id") int productid,
                        @RequestParam("date") String date,
                        @RequestParam("name") String product ,
                        @RequestParam("detail") String detail ,
                        @RequestParam("price") Double price,
                        @RequestParam("quantity") int quantity,
                        @RequestParam("totalPrice") Double totalPrice ) {

        Order order = new Order();
        order.setDate(date);
        order.setTex(String.valueOf(tex));
        order.setDate(date);
        order.setTotalPrice(String.valueOf(totalPrice));
        orderService.save(order);

        List<Product> item = itemService.getItemList();


        orderDetailService.importData(item,tex);


        itemService.clearItemList();
        return "redirect:/home";
    }


}
