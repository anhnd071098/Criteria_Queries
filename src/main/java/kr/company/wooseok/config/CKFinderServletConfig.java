package kr.company.wooseok.config;

import com.ckfinder.connector.ConnectorServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CKFinderServletConfig {
    private ClassLoader classLoader = CKFinderServletConfig.class.getClassLoader();
    private String ckfinderXMLPath = classLoader.getResource("static").getPath() + "/ckfinder.xml";

    @Bean
    public ServletRegistrationBean connectCKFinder() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ConnectorServlet(),
                "/ckfinder/core/connector/java/connector.java");
        registrationBean.addInitParameter("XMLConfig", ckfinderXMLPath);
        registrationBean.addInitParameter("debug", "true");
        return registrationBean;
    }
}
