package com.example.springbootmongodb;

import com.example.springbootmongodb.dao.CustomerRepository;
import com.example.springbootmongodb.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMongodbApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.deleteAll();

		// 保存用户
		customerRepository.save(new Customer("Bob", "Smith"));
		customerRepository.save(new Customer("Alice", "Smith"));

		// 查询所有用户
		System.out.println("查询所有用户----start---------");
		for(Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println("查询所有用户-----end--------");

		// 通过姓名查询
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}
