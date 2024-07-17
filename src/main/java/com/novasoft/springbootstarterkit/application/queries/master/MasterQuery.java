package com.novasoft.springbootstarterkit.application.queries.master;

import com.novasoft.springbootstarterkit.domain.agregates.master.IMasterRepository;
import com.novasoft.springbootstarterkit.domain.agregates.master.Master;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterQuery implements IMasterQuery {

    private final IMasterRepository masterRepository;

    public MasterQuery(IMasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public Master getById(int id) {
        return masterRepository.getById(id);
    }

    @Override
    public List<Master> getAll() {
        return masterRepository.getAll();
    }

    @Override
    public List<Master> pagination(int page, int size) {
        return masterRepository.pagination(page, size);
    }
}
