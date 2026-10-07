package com.ernesto.curso.springboot.jpa.springjpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.ernesto.curso.springboot.jpa.springjpa.entities.Person;
import com.ernesto.curso.springboot.jpa.springjpa.repositories.PersonRepository;


@SpringBootApplication
public class SpringjpaApplication implements CommandLineRunner {

	@Autowired 
	private PersonRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		delete2();
	}

	@Transactional 
	public void delete2(){
		repository.findAll().forEach(System.out::println);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el id a eliminar: ");
		Long id = scanner.nextLong();
		
		Optional<Person> optionalPerson = repository.findById(id);
		optionalPerson.ifPresentOrElse(repository::delete, 
			() -> System.out.println("Lo sentimos no existe la persona"));
		

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional 
	public void delete(){
		repository.findAll().forEach(System.out::println);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el id a eliminar: ");
		Long id = scanner.nextLong();
		repository.deleteById(id);

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}



	@Transactional 
	public void create(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa tu nombre: ");
		String name  = scanner.next();
		System.out.println("Ingresa tus apellidos: ");
		String lastname = scanner.next();
		System.out.println("Ingresa tu lenguaje de programación: ");
		String programmingLanguage = scanner.next();
		scanner.close();
		Person person = new Person(null,name, lastname, programmingLanguage);
		Person personNew = repository.save(person);
		System.out.println(personNew);

		scanner.close();
	} 

	@Transactional 
	public void update(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el id de la persona: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresent(person ->{
			System.out.println(person);
			System.out.println("Ingrese el lenguaje de programación: ");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person personDb = repository.save(person);
			System.out.println(personDb);

		});
	}

	@Transactional(readOnly= true) 
	public void findOne(){
		// Person person = null;
		// Optional<Person> optionalPerson = repository.findById(8L);
		// if(optionalPerson.isPresent()){
		// 	person = optionalPerson.get();
		// }
		// System.out.println(person); 
		repository.findByNameContaining("ria").ifPresent(person -> System.out.println(person));
	}

	public void list(){
		// List<Person> persons = (List<Person>) repository.findAll();
		// List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Andres","Java");
		List<Object[]> persons = repository.obtenerByProgrammingLanguage("Pepe", "Doe", "Python");
		
		persons.stream().forEach(person -> System.out.println(person[0]));
	}
	

}
