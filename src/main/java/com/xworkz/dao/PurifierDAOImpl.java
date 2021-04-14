package com.xworkz.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.xworkz.dto.PurifierDTO;
import com.xworkz.dto.PurifierMapper;

public class PurifierDAOImpl implements PurifierDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(PurifierDTO purifierDTO) {
		String sql = "insert into purifier_details (id,brand, price) values(?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { purifierDTO.getId(), purifierDTO.getBrand(), purifierDTO.getPrice() });
		System.out.println("inserted record");
		System.out.println(purifierDTO);
	}

	public List<PurifierDTO> readAllRecords() {
		String sql = "select * from purifier_details";
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<PurifierDTO> list = jdbcTemplate.query(sql, new PurifierMapper());
		System.out.println("Records present in database");
		return list;
	}

	public void updateBrandById(String brand, int id) {
		String sql = "update purifier_details set brand=? where id=? ";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, brand, id);
		System.out.println("updated brand is " + brand + " id " + id);

	}

	public void deleteById(int id) {
		String sql = "delete from purifier_details where id=?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, id);
		System.out.println("deleted id is " + id);

	}
}
