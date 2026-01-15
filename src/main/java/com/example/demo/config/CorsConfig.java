//package com.example.demo.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;;;
//
//@Configuration
//@EnableWebMvc
//public class CorsConfig  {
//	@Bean
//	public WebMvcConfigurer corsConfigurer()  {
//
//		return  new WebMvcConfigurer(){
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/login")
//						.allowedOrigins("http://localhost:4200")
//						.allowedMethods("*")
//				        .exposedHeaders();
//
//				registry.addMapping("/api/**")
//						.allowedOrigins("http://localhost:4200")
//				        .allowedMethods("*");
//			}
//
//		};
//
//	}
//}
//
//
///*
//*
//* @Bean
//public WebMvcConfigurer corsConfigurer() {
//    return new WebMvcConfigurerAdapter() {
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
//        }
//    };
//}
//* */
//
///*	@Override
//extends WebMvcConfigurerAdapter
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**");
//	}*/
