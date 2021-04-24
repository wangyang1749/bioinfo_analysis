package com.wangyang.bioinfo.repository;

import com.wangyang.bioinfo.pojo.DifferenceExpressGene;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author wangyang
 * @date 2021/4/24
 */
public interface TestRepository extends MongoRepository<DifferenceExpressGene, Integer> {
    //DifferenceExpressGene findByName(String name);
}
