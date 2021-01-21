package com.mosiqi.sell.controller;

import com.mosiqi.sell.dataobject.ProductCategory;
import com.mosiqi.sell.dataobject.ProductInfo;
import com.mosiqi.sell.exception.SellException;
import com.mosiqi.sell.form.ProductForm;
import com.mosiqi.sell.service.CategoryService;
import com.mosiqi.sell.service.ProductService;
import com.mosiqi.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "5") int size,
                             Map<String, Object> map) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }


    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            log.error("[Order status] wrong status {}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }


    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            log.error("[Order status] wrong status {}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }


    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        ProductInfo productInfo = new ProductInfo();
        if (!StringUtils.isEmpty(productId)) {
            productInfo = productService.findOne(productId);
        }
        map.put("productInfo", productInfo);
        // 查询所有的类目
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("productCategoryList", productCategoryList);
        return new ModelAndView("/product/index", map);
    }


    @PostMapping("/save")
//    @CachePut(cacheNames = "product", key = "123")
    @CacheEvict(cacheNames = "product", key = "123")
    public ModelAndView save(@Valid ProductForm productForm,
                             Map<String, Object> map,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[Add new product] parameters not correct，orderForm={}", productForm);
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("/common/error", map);
        }
        ProductInfo productInfo = new ProductInfo();

        try {
            // 如果productId为空，则说明是新增
            if (!StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productService.findOne(productForm.getProductId());
            } else {
                productForm.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(productForm, productInfo);
            productService.save(productInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

}
