package com.novasoft.springbootstarterkit.application.queries.master;

import com.novasoft.springbootstarterkit.domain.agregates.master.Master;

import java.util.List;

public interface IMasterQuery {

    Master getById(int id);

    List<Master> getAll();

    List<Master> pagination(int page, int size);
}
