package com.imooc.demo.service;


import com.imooc.demo.enums.ResultEnum;
import com.imooc.demo.exception.GirlException;
import com.imooc.demo.repository.GirlRepository;
import com.imooc.demo.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author song
 */
@Service
public class GirlService {

	@Autowired GirlRepository girlRepository;

	@Transactional(rollbackOn = Exception.class)
	public void insertTwo(){
		Girl girlA=new Girl();
		girlA.setName("A");
		girlA.setAge(20);
		girlRepository.save(girlA);

		Girl girlB=new Girl();
		girlB.setAge(22);
		girlB.setName("B");
		girlRepository.save(girlB);
	}
	 public void getAge(Integer id) throws Exception{
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if (age<10){
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}
		else if (age>10 && age<18){
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	 }

	/**
	 * 通过ID查询一个女生
	 * @param id
	 * @return
	 */
	 public Girl findOne(Integer id){
		return girlRepository.findOne(id);
	 }

	 public String findName(Integer id){
	 	return girlRepository.findOne(id).getName();
	 }
}
