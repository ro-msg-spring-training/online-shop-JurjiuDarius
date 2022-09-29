package ro.msg.training.shop.dto.order;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class OrderDTO {
    private int customerId;
    private LocalDateTime createdAt;
    private String country;
    private String city;
    private String county;
    private String streetAddress;
    private ArrayList<OrderDetailDTO> orderDetailDTOS;
}
