package com.koumi.framework.product.rcs.util;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
/**
 * 将日期转换的类绑定
 * @author Koumi_art
 * @date  2011-12-02
 */
public class MyWebBinding implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {
		//2种方法
		//1. 使用spring自带的CustomDateEditor
		//SimpleDateFormat simplDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(simplDateFormat, true));
		//2. 自定义的PropertyEditorSupport
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

}
