package com.novasoft.springbootstarterkit.api.controllers.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasePaginationResponse<T> {
    public T data;
    public int page;
    public int size;
    public String message;
    public boolean status;
}
