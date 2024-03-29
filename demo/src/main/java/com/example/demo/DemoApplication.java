package com.example.demo;

import com.example.demo.tables.author_id.Authors;
import com.example.demo.tables.author_id.AuthorsService;
import com.example.demo.tables.scripts_table.ScriptsService;
import com.example.demo.tests.CourseService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		AuthorsService authorService = context.getBean(AuthorsService.class);
		ScriptsService scriptsService = context.getBean(ScriptsService.class);

		//authorService.addAuthor("saranin");
//		scriptsService.addScriptToStore("helper","cool sctript",19.99,"saranin","1.png");
//		scriptsService.addScriptToStore("visual","for video",4.49,"saranin","2.png");
//		scriptsService.addScriptToStore("Super","cool sctript",190.99,"saranin","1.png");
//		scriptsService.addScriptToStore("Normal script","for video",1.29,"saranin","2.png");
//		scriptsService.addScriptToStore("Nice","cool sctript",99.99,"saranin","1.png");
//		scriptsService.addScriptToStore("Video edit","for video",10,"saranin","2.png");
		//scriptsService.addScriptToStore("New script","cool sctript",99.99,"saranin","1.png");
		//scriptsService.addScriptToStore("Editor","for video",10,"saranin","2.png");


		scriptsService.printAllScripts();

		//CourseService courseService = context.getBean(CourseService.class);
		String s=scriptsService.getPrices();
		System.out.println(s);
	}

//	// Настройка CORS
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/api/**")
//						.allowedOrigins("http://your-frontend-domain.com")
//						.allowedMethods("GET", "POST", "PUT", "DELETE")
//						.allowedHeaders("*")
//						.allowCredentials(true);
//			}
//		};
//	}
}