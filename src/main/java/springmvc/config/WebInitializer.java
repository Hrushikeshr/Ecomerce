package springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		@SuppressWarnings("rawtypes")
		Class [] classArr = {WebAppConfig.class};
		return classArr;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mapping = {"/"};
		return mapping;
	}

}
