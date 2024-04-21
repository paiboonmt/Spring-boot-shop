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

    @PostMapping("/finish")
    public String finish(
            @RequestParam("tex") String tex,
            @RequestParam("id") int productid,
            @RequestParam("date") String date,
            @RequestParam("name") String product ,
            @RequestParam("detail") String detail ,
            @RequestParam("price") String price,
            @RequestParam("quantity") String quantity,
            @RequestParam("totalPrice") String totalPrice,
            @ModelAttribute Product productww

    ) {


//        System.out.println(productww);
//        Order order = new Order();
//        order.setDate(date);
//        order.setTex(tex);
//        order.setDate(date);
//        order.setTotalPrice(totalPrice);
//        orderService.save(order);


            for ( Product ss : itemService.getItemList()){
                if ( ss.getName().equals(productww.getName())){
                    System.out.println(productid);
                    System.out.println(ss.getId());
                }
                System.out.println(productid);
                System.out.println(ss.getId());

            }

//       for (int i = 0; i < itemService.getItemList().size(); i++) {
//            OrderDetail o = new OrderDetail();
//            o.setProductId(productid);
//            o.setQuantity(quantity);
//            o.setTextId(tex);
//            o.setPrice(price);
//            o.setProductName(product);
//            orderDetailService.save(o);
//       }

//        OrderDetail o = new OrderDetail();
//        o.setProductId(productid);
//        o.setQuantity(quantity);
//        o.setTextId(tex);
//        o.setPrice(price);
//        o.setProductName(product);

//        for (Product p : itemService.getItemList()) {
//            boolean found = false;
//            if ( p.getId() != productid ) {
//                orderDetailService.save(o);
//                found = true;
//            }
//            if (!found) {
//                break;
//            }
//        }

        itemService.clearItemList();
        return "redirect:/home";
    }


}
