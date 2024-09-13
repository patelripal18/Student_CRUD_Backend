package Student.CURD.Operation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow CORS on all paths
                .allowedOrigins("http://localhost:63342/")  // Allow requests from this origin (your frontend's URL)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow specified HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials (cookies, authorization headers, etc.)
    }


}
