package com.novasoft.springbootstarterkit.api.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BasePaginationResponse<T> {
    private T items;
    private int page;
    private int size;
    private int total;
}
