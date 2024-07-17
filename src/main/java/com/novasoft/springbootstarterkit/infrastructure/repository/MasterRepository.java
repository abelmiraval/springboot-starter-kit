package com.novasoft.springbootstarterkit.infrastructure.repository;

import com.novasoft.springbootstarterkit.domain.agregates.master.IMasterRepository;
import com.novasoft.springbootstarterkit.domain.agregates.master.Master;

import java.util.List;

public class MasterRepository implements IMasterRepository {

    @Override
    public Master getById(int id) {
        return null;
    }

    @Override
    public List<Master> getAll() {
        return List.of();
    }

    @Override
    public List<Master> pagination(int page, int size) {
        return List.of();
    }

    @Override
    public Master save(Master master) {
        return null;
    }

    @Override
    public Master update(Master master) {
        return null;
    }

    @Override
    public void delete(int id) {
        // delete master
    }
}
