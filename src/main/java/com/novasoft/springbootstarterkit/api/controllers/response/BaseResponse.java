package com.novasoft.springbootstarterkit.api.controllers.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse<T> {

    public T data;
    public String message;
    public boolean status;
}
