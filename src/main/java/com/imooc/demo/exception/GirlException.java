package com.imooc.demo.exception;

import com.imooc.demo.enums.ResultEnum;

/**
 * @author Administrator
 */
public class GirlException extends RuntimeException{

	private Integer code;
	public GirlException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	public Integer getCode() {
		return code;
	}
}