package com.novasoft.springbootstarterkit.api.controllers;

import com.novasoft.springbootstarterkit.api.controllers.request.master.CreateMasterRequest;
import com.novasoft.springbootstarterkit.api.controllers.request.master.UpdateMasterRequest;
import com.novasoft.springbootstarterkit.api.controllers.response.BasePaginationResponse;
import com.novasoft.springbootstarterkit.api.controllers.response.BaseResponse;
import com.novasoft.springbootstarterkit.api.controllers.response.master.MasterResponse;
import com.novasoft.springbootstarterkit.application.mapper.MasterMapper;
import com.novasoft.springbootstarterkit.application.queries.master.IMasterQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/masters")
public class MasterController {

    private final IMasterQuery masterQuery;
    public static final String SUCCESS = "Success";

    MasterController(IMasterQuery masterQuery) {
        this.masterQuery = masterQuery;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<MasterResponse>> getById(@PathVariable int id) {
        var master = masterQuery.getById(id);
        var response = MasterMapper.INSTANCE.masterToResponse(master);

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<MasterResponse>>> getAll() {
        var masters = masterQuery.getAll();
        var response = MasterMapper.INSTANCE.mastersToMasterResponses(masters);

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true), HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity<BaseResponse<BasePaginationResponse<List<MasterResponse>>>> pagination(@RequestParam int page, @RequestParam int size) {

        var masters = masterQuery.pagination(page, size);
        var items = MasterMapper.INSTANCE.mastersToMasterResponses(masters);
        var response = new BasePaginationResponse<>(items, page, size, items.size());

        return new ResponseEntity<>(new BaseResponse<>(response, SUCCESS, true), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public boolean save(@RequestBody CreateMasterRequest masterRequest) {
        return true;
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable String id, @RequestBody UpdateMasterRequest masterRequest) {
        return true;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return true;
    }

}
