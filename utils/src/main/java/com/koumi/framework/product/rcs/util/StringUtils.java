package com.koumi.framework.product.rcs.util;

/**
 * @author sunhaiyang
 *
 */
public class StringUtils {
	
	public static boolean isNotEmpy(String value) {
		if (value != null && value.trim() != "" && value.trim().length() > 0)
			return true;
		return false;
	}
	
	public static boolean isEmpy(String value) {
		return !(isNotEmpy(value));
	}
}
