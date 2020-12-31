package com.mosiqi.sell.repository;

import com.mosiqi.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailReporitory extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
