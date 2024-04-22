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

		authorService.addAuthor("saranin");
		scriptsService.addScriptToStore("helper","cool sctript",19.99,"saranin","textforce.png","D:\\All\\files\\script2.txt","HcZrog9ULHg");
		scriptsService.addScriptToStore("easy","for video",4.49,"saranin","Screenshot_1.png","D:\\All\\files\\script.txt","HcZrog9ULHg");
		scriptsService.addScriptToStore("keystone","cool sctript",190.99,"saranin","keystone.png","D:\\All\\files\\script.txt","HcZrog9ULHg");
		scriptsService.addScriptToStore("Normal script","for video",1.29,"saranin","textforce.png","D:\\All\\files\\script.txt","HcZrog9ULHg");
		scriptsService.addScriptToStore("Nice","cool sctript",99.99,"saranin","Screenshot_1.png","D:\\All\\files\\script.txt","HcZrog9ULHg");
		scriptsService.addScriptToStore("Video edit","for video",10,"saranin","keystone.png","D:\\All\\files\\script.txt","HcZrog9ULHg");
		scriptsService.addScriptToStore("textforce","cool sctript",99.99,"saranin","textforce.png","D:\\All\\files\\script.txt","HcZrog9ULHg");
		scriptsService.addScriptToStore("Editor","for video",10,"saranin","Screenshot_1.png","D:\\All\\files\\script.txt","HcZrog9ULHg");


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