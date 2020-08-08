package com.imooc.demo.handle;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.domain.Result;
import com.imooc.demo.exception.GirlException;
import com.imooc.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

	/** 声明捕获哪个异常类 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e){
		if (e instanceof GirlException){
			GirlException girlException = (GirlException) e;
			return ResultUtil.failed(girlException.getCode(),girlException.getMessage());
		}
		else{
			return ResultUtil.failed(100,"未定义未知错误");
		}
	}
}
