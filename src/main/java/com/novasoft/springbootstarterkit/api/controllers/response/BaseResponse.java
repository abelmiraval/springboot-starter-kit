package com.novasoft.springbootstarterkit.api.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BaseResponse<T> {
    public T data;
    public String message;
    public boolean status;
}
