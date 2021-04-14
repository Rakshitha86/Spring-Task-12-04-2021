package com.xworkz.dao;

import java.util.List;

import com.xworkz.dto.PurifierDTO;

public interface PurifierDAO {

	void save(PurifierDTO purifierDTO);

	List<PurifierDTO> readAllRecords();

    void updateBrandById(String brand,int id) ;

	void deleteById(int id);
}
