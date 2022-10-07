package com.camsoft.okuidp.Config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConversionConfig {
private Set<Converter> getConverters(){
 Set<Converter> Converters = new HashSet<Converter>();
		 return Converters;
}
public ConversionService conversionService() {
	ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
	bean.setConverters(getConverters());
	return bean.getObject();
}
}
