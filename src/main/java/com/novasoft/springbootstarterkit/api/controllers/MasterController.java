package com.novasoft.springbootstarterkit.api.controllers;

import com.novasoft.springbootstarterkit.api.controllers.request.master.CreateMasterRequest;
import com.novasoft.springbootstarterkit.api.controllers.request.master.UpdateMasterRequest;
import com.novasoft.springbootstarterkit.api.controllers.response.BasePaginationResponse;
import com.novasoft.springbootstarterkit.api.controllers.response.BaseResponse;
import com.novasoft.springbootstarterkit.api.controllers.response.master.MasterResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class MasterController {


    public static final String SUCCESS = "Success";

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<MasterResponse>> getById(@PathVariable String id) {
        var masterResponse = new MasterResponse("1", "One");
        var response = new BaseResponse<MasterResponse>();
        response.data = masterResponse;
        response.message = SUCCESS;
        response.status = true;

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<MasterResponse>>> getAll() {
        List<MasterResponse> masterResponses = Arrays.asList(
                new MasterResponse("1", "One"),
                new MasterResponse("2", "Two")
        );

        var response = new BaseResponse<List<MasterResponse>>();
        response.data = masterResponses;
        response.message = SUCCESS;
        response.status = true;

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity<BasePaginationResponse<List<MasterResponse>>> pagination(@RequestParam int page, @RequestParam int size) {
        List<MasterResponse> masterResponses = Arrays.asList(
                new MasterResponse("1", "One"),
                new MasterResponse("2", "Two")
        );

        BasePaginationResponse<List<MasterResponse>> response = new BasePaginationResponse<>();
        response.data = masterResponses;
        response.page = page;
        response.size = size;
        response.message = SUCCESS;
        response.status = true;

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public boolean create(@RequestBody CreateMasterRequest masterRequest) {
        return true;
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable String id, @RequestBody UpdateMasterRequest masterRequest) {
        return true;
    }

    @PatchMapping("/{id}")
    public boolean patch(@PathVariable String id, @RequestBody UpdateMasterRequest masterRequest) {
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return true;
    }

}
