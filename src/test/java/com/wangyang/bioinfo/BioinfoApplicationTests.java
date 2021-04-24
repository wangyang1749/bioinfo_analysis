package com.wangyang.bioinfo;

import com.wangyang.bioinfo.pojo.DifferenceExpressGene;
import com.wangyang.bioinfo.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BioinfoApplicationTests {

	@Autowired
	TestRepository repository;

	@Test
	void testAdd() {
//		DifferenceExpressGene deg = DifferenceExpressGene.builder().name("南京路中学").build();
//		System.out.println(deg.getName());
//		repository.insert(deg);
	}
	@Test
	void testFind() {
		List<DifferenceExpressGene> students = repository.findAll();
		students.forEach(student -> {
			System.out.println(student.getBaseMean());
		});
	}

}
