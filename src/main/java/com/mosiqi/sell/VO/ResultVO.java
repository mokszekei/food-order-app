package com.mosiqi.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ResultVO<T> {

    private Integer code;
    private String msg;

    private T data;

}
