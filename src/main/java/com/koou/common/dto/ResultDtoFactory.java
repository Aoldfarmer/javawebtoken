package com.koou.common.dto;

import com.koou.common.constant.ResultCode;

import java.io.Serializable;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-16 1:12 PM
 */
public final class ResultDtoFactory {

    private ResultDtoFactory() {
    }

    public static <T extends Serializable> ResultDto<T> toACK (String message, T data) {
        ResultDto<T> result = new ResultDto<>();
        result.setCode(ResultCode.ACK);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T extends Serializable> ResultDto<T> toACK (String message) {
        return toACK(message, null);
    }

    public static <T extends Serializable> ResultDto<T> toNACK (String message, T data) {
        ResultDto<T> result = new ResultDto<>();
        result.setCode(ResultCode.NACK);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public <T extends Serializable> ResultDto<T> toNACK (String message) {
        return toNACK(message, null);
    }
}
