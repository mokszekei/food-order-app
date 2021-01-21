package com.mosiqi.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 5404115822959335572L;

    private Integer code;

    private String msg;

    private T data;

}
