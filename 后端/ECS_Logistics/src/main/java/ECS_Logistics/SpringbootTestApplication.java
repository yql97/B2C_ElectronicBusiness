package ECS_Logistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"ECS_Logistics.*,ECS_Common.*"})
@MapperScan(basePackages="ECS_Logistics.mapper")
public class SpringbootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}
	 private CorsConfiguration buildConfig() {
	        CorsConfiguration corsConfiguration = new CorsConfiguration();
	        corsConfiguration.addAllowedOrigin("*");
	        corsConfiguration.addAllowedHeader("*");
	        corsConfiguration.addAllowedMethod("*");
	        return corsConfiguration;
	    }

	    /**
	     * 跨域过滤器
	     *
	     * @return
	     */
	    @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", buildConfig()); // 
	        return new CorsFilter(source);
	    }
}
