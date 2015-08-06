package com.koumi.framework.product.rcs.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkUtils {
	
	/**
	 * freemark初始化
	 * 
	 * @param templatePath
	 *            模板文件位置
	 */
	public FreemarkUtils(String templatePath,Object servletContext) {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setServletContextForTemplateLoading(servletContext, templatePath);
	}
	
	public FreemarkUtils(String templatePath,Class<?> clazz) {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(clazz, templatePath);
	}
	
	public FreemarkUtils(String templatePath,File file) throws IOException {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setDirectoryForTemplateLoading(file);
	}
	
	
	public void create(Map<String, Object> params){  
        Template t = null;  
        Writer out = null; 
        try {  
        	//获取模板信息  
            t = configuration.getTemplate(templateName); 
            File outFile = new File(filePath+"/"+fileName);  
        	out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8")); 
            //输出数据到模板中，生成文件。  
            t.process(params, out);
        } catch (TemplateException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
        	try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
          
    }

	/**
	 * freemark模板配置
	 */
	private Configuration configuration;
	/**
	 * freemark模板的名字
	 */
	private String templateName;
	/**
	 * 生成文件名
	 */
	private String fileName;
	/**
	 * 生成文件路径
	 */
	private String filePath;

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
