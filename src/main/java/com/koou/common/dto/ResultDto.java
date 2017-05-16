package com.koou.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-16 12:35 PM
 */
@Data
public class ResultDto<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private T data;
}
