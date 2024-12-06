package com.pluralsight.NorthwindTradersSpringBoot2;

import com.pluralsight.NorthwindTradersSpringBoot2.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot2.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindTradersSpringBoot2Application.class, args);
//		ProductService productService = context.getBean(ProductService.class);


	}
}