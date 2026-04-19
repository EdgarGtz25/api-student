package com.itcl.students.mx.students.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}