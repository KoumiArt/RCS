$.extend($.fn.validatebox.defaults.rules, {
 	mobile: {
	    validator: function (value) {
	    	var reg = /^1[3|4|5|8|9]\d{9}$/;
	        return reg.test(value);
	    },
	    message: '输入手机号码格式不准确.'
 	},
 	loginPwd: {
        validator: function (value) {		        
            return $("input[name=loginPwd]").val()==value;
    	},
    	message: '两次输入的密码不一致.'
	}
});