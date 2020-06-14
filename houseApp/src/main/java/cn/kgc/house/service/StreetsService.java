package cn.kgc.house.service;

import cn.kgc.house.domain.Street;

import java.util.List;

public interface StreetsService {

    public List<Street> streetList(Integer id)throws Exception;

}
