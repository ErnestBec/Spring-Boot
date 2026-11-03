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
		
		fullNameBetween();
	}
	@Transactional (readOnly = true)
	public void fullNameBetween(){
				System.out.println("========= Lista de nombres en between =========");
		List<String> listFullNames = repository.findListFullNameBetween();
		listFullNames.forEach(fullName -> System.out.println(fullName));
	}

	@Transactional(readOnly = true)
	public void fullNamePersonalized(){

		System.out.println("========= Lista de nombres en minusaculas =========");
		List<String> listFullNames = repository.findListFullNameLower();
		listFullNames.forEach(fullName -> System.out.println(fullName));

		System.out.println("========= Lista de nombres en mayusculas =========");
		listFullNames = repository.findListFullNameUpper();
		listFullNames.forEach(fullName -> System.out.println(fullName));

		System.out.println("========= Lista de nombres con coincidencia =========");
		listFullNames = repository.findListFullNameLike();
		listFullNames.forEach(fullName -> System.out.println(fullName));
	}

	@Transactional(readOnly = true) 
	public void personalizedQueriesDistinct (){
		System.out.println("========== Lsta de nombres ==========");
		List<String> names = repository.findAllNames();

		names.forEach(name -> System.out.println(name));

		System.out.println("========== Lsta de nombres unicos ==========");
		names = repository.findAllNamesDistinct();
		names.forEach(name -> System.out.println(name));

		System.out.println("========== Lenguajes de programación unicos ==========");
		List<String> languajes = repository.findAllLanguageDistinct();
		languajes.forEach(languages -> System.out.println(languages));

		System.out.println("========== Cantidad de Lenguajes de programación unicos ==========");
		Long count = repository.findAllLanguageCount();
		System.out.println("Existen " + count + " lenguajes de programación.");

	}

	@Transactional(readOnly = true)
	public void personalizedQueries2(){
		System.out.println("======= consulta por objeto persona y lenguaje de programación =======");

		List<Object[]> personsRegs = repository.findAllMixPerson();
		personsRegs.forEach(person -> System.out.println("Language: " + person[1] + " Person: " + person[0]));

		System.out.println("======= Consulta que puebla y devuelve objeto entity de una onstancia personalizada. =======");
		List<Person> persons = repository.findAllObjectPeronPersonalized();
		persons.forEach(person -> System.out.println("Person: " + person));


		System.out.println("======= Consulta que puebla y devuelve objeto entity de un DTO. =======");
		List<PersonDTO> personsDto = repository.findAllPersonDTO();
		personsDto.forEach(person -> System.out.println("Person: " + person));
	}


	@Transactional(readOnly = true)
	public void personalizedQueries(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el id: ");
		Long id = scanner.nextLong();

		String fullName = repository.getFullNameById(id);

		System.out.println("Usuario: " + fullName );
		scanner.close();
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
