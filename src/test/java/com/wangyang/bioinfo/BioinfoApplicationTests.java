package com.wangyang.bioinfo;

import com.wangyang.bioinfo.pojo.DEG;
import com.wangyang.bioinfo.repository.DEGRepository;
import com.wangyang.bioinfo.service.IDEGService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
class BioinfoApplicationTests {

	@Autowired
    DEGRepository repository;

	@Autowired
	IDEGService degService;
	@Test
	void testAdd() {
//		DEG deg = DEG.builder().name("南京路中学").build();
//		repository.insert(deg);
	}
	@Test
	void testFind() {
//		List<DEG> students = repository.findAll();
		PageRequest pageRequest = PageRequest.of(2, 10);
		Page<DEG> page = degService.page(pageRequest);
//		System.out.println(page);
//		students.forEach(student -> {
//			System.out.println(student.getBaseMean());
//		});
	}

}
