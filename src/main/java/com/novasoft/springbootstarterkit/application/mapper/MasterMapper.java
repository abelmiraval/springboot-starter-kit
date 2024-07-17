package com.novasoft.springbootstarterkit.application.mapper;

import com.novasoft.springbootstarterkit.api.controllers.response.master.MasterResponse;
import com.novasoft.springbootstarterkit.domain.agregates.master.Master;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MasterMapper {
    MasterMapper INSTANCE = Mappers.getMapper(MasterMapper.class);

    MasterResponse masterToResponse(Master model);

    List<MasterResponse> mastersToMasterResponses(List<Master> masters);
}