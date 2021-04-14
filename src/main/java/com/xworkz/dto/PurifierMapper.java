package com.xworkz.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PurifierMapper implements RowMapper<PurifierDTO> {

	@Override
	public PurifierDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PurifierDTO purifierDTO = new PurifierDTO();
		purifierDTO.setId(rs.getInt("id"));
		purifierDTO.setBrand(rs.getString("brand"));
		purifierDTO.setPrice(rs.getDouble("price"));
		return purifierDTO;
	}

}
