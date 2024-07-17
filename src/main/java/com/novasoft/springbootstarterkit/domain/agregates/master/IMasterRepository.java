package com.novasoft.springbootstarterkit.domain.agregates.master;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterRepository {

    Master getById(int id);

    List<Master> getAll();

    List<Master> pagination(int page, int size);

    Master save(Master master);

    Master update(Master master);

    void delete(int id);

}
