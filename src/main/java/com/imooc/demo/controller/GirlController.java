package com.imooc.demo.controller;

import com.imooc.demo.utils.ResultUtil;
import com.imooc.demo.domain.Girl;
import com.imooc.demo.domain.Result;
import com.imooc.demo.repository.GirlRepository;
import com.imooc.demo.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author song
 */
@RestController
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	@Autowired
    private GirlService girlService;

	private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
	/**
	 * 查询所有女生列表
	 * @return
	 */
	@GetMapping(value = "/girl")
	public List<Girl> girlList(){
		logger.info("girl");
		return girlRepository.findAll();
	}
	/**
	 * 添加一个女生
	 * @return
	 */
	@PostMapping(value = "/girl")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
//		    Result result = new Result();
//			result.setCode(0);
//		    result.setMsg(bindingResult.getFieldError().getDefaultMessage());
		    return ResultUtil.failed(1,bindingResult.getFieldError().getDefaultMessage());

//			List<ObjectError> error = bindingResult.getAllErrors();
//			for (int i = 0;i < error.size();i++){
//				result.setData(error.get(i).getDefaultMessage());
//				result.setMsg("error:" + error.get(i).getDefaultMessage());
//			}
//    		return result;
		}
		girl.setId(girl.getId());
    	girl.setName(girl.getName());
		girl.setAge(girl.getAge());
		girl.setMoney(girl.getMoney());

		return ResultUtil.success(girlRepository.save(girl));
	}
	/**
	 * 查询一个女生
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girl/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id){
		return girlRepository.findOne(id);
	}

	/**
	 * 更新一个女生
	 * @param id
	 * @param name
	 * @param age
	 * @return
	 */
	@PutMapping(value = "/girl/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id,
					   @RequestParam("name") String name,
					   @RequestParam("age") Integer age,
					   @RequestParam("money") String money){
		Girl girl=new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setName(name);
		girl.setMoney(money);
		return girlRepository.save(girl);
	}

	/**
	 * 删除一个女生
	 * @param id
	 */
	@DeleteMapping(value = ("/girl/{id}"))
	public void girlDelete(@PathVariable("id") Integer id){
		girlRepository.delete(id);
	}

	/**
	 *通过年龄来查询
	 * @param age
	 * @return
	 */
	@GetMapping(value = "/girl/age/{age}")
	public List<Girl> girlListByAge(@PathVariable Integer age){
		return girlRepository.findByAge(age);
	}

	/**
	 * 事物管理d
	 */
	@PostMapping(value = "/girl/two")
	public void girlTwo(){
    	girlService.insertTwo();

	}

	@GetMapping(value = "/girl/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception{
		girlService.getAge(id);
	}
}
