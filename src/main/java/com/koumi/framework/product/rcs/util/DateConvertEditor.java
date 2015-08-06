package com.koumi.framework.product.rcs.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.util.StringUtils;

/**
 * 自定义解决前台日期传到后台自动装载为java.util.Date
 * @author Koumi_art
 * @date  2011-12-02
 */
public class DateConvertEditor extends PropertyEditorSupport {
	private SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.hasText(text)) {
			try {
				if (text.indexOf(":") == -1 && text.length() == 10) {
					setValue(this.dateFormat.parse(text));
				} else if (text.indexOf(":") > 0 && text.length() == 19) {
					setValue(this.datetimeFormat.parse(text));
				}else{
					throw new IllegalArgumentException("日期转换出错");
				}
			} catch (ParseException ex) {
				IllegalArgumentException iae = new IllegalArgumentException("日期转换出错: " + ex.getMessage());
				iae.initCause(ex);
				throw iae;
			}
		} else {
			setValue(null);
		}
	}
}
