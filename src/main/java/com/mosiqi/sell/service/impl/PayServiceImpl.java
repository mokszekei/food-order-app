package com.mosiqi.sell.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;
import com.mosiqi.sell.dto.OrderDTO;
import com.mosiqi.sell.enums.ResultEnum;
import com.mosiqi.sell.exception.SellException;
import com.mosiqi.sell.service.OrderService;
import com.mosiqi.sell.service.PayService;
import com.mosiqi.sell.utils.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "wechat-food-order";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[微信支付] 发起支付，request={}", JsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("[微信支付] 发起支付，response={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        // 1.check psySign
        // 2.check pay status
        // 3.check order value
        // 4. check whether order person == pay person
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("[wechat pay] async notify, payResponse={}", JsonUtil.toJson(payResponse));

        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

        if(orderDTO == null){
            log.error("[wechat pay] async notify, order doesn't exist");
            throw new SellException(ResultEnum.PARAM_ERROR.ORDER_NOT_EXIST);
        }

        if (!MathUtil.equals(orderDTO.getOrderAmount().doubleValue(), payResponse.getOrderAmount())) {
            log.error("[wechat pay] async notify, order price not consistent，orderId={},notice price={},system price={}",
                    payResponse.getOrderId(),
                    payResponse.getOrderAmount(),
                    orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }

        orderService.paid(orderDTO);

        return payResponse;
    }

    @Override
    public RefundResponse refund(OrderDTO orderDTO) {

        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[wechat refund] request={}", JsonUtil.toJson(refundRequest));
        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("[wechat refund] response={}", JsonUtil.toJson(refundResponse));

        return refundResponse;
    }
}


















