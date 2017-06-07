package com.koou.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String password;

    private Date loginTime;

}