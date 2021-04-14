package com.xworkz.tester;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.dao.PurifierDAO;
import com.xworkz.dao.PurifierDAOImpl;
import com.xworkz.dto.PurifierDTO;

public class Tester {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Application.xml");
		PurifierDAOImpl purifierDAOImpl = (PurifierDAOImpl) applicationContext.getBean(PurifierDAOImpl.class);
		PurifierDTO purifierDTO = new PurifierDTO(14, "LG", 20000.0);
		purifierDAOImpl.save(purifierDTO);
		for (PurifierDTO dto : purifierDAOImpl.readAllRecords()) {
			System.out.println(dto);
		}
		purifierDAOImpl.updateBrandById(" Whirlpool", 4);
		purifierDAOImpl.deleteById(8);
	}

}
