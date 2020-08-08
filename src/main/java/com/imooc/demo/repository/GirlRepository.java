package com.imooc.demo.repository;

import com.imooc.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

	/** 这是通过年龄来查询女生列表
	 * @param age
	 * @return
	 */
	 List<Girl> findByAge(Integer age);
}
