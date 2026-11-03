package com.ernesto.curso.springboot.jpa.springjpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ernesto.curso.springboot.jpa.springjpa.PersonDTO;
import com.ernesto.curso.springboot.jpa.springjpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
    
    @Query ("select upper(p.name) || ' ' || upper(p.lastname) from Person p where p.name between 'E' and 'G' ")
    List<String> findListFullNameBetween();

    @Query ("select upper(p.name) || ' ' || upper(p.lastname) from Person p where p.name LIKE '%o%'")
    List<String> findListFullNameLike();

    @Query ("select concat(upper(p.name), ' ', upper(p.lastname)) from Person p")
    List<String> findListFullNameUpper();

    @Query ("select concat(lower(p.name), ' ', lower(p.lastname)) from Person p")
    List<String> findListFullNameLower();

    @Query ("select count(distinct(p.programmingLanguage)) from Person p")
    Long findAllLanguageCount();

    @Query ("select distinct(p.programmingLanguage) from Person p")
    List <String> findAllLanguageDistinct();

    @Query("select p.name from Person p") 
    List<String> findAllNames();

    @Query("select distinct(p.name) from Person p") 
    List<String> findAllNamesDistinct();
    @Query("select new com.ernesto.curso.springboot.jpa.springjpa.PersonDTO(p.name, p.lastname) from Person p") 
    List<PersonDTO> findAllPersonDTO();

    @Query("select new Person(p.name, p.lastname) from Person p") 
    List<Person> findAllObjectPeronPersonalized();

    @Query("select p, p.programmingLanguage from Person p") 
    List<Object[]> findAllMixPerson();

    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);

    @Query("select concat(p.name , ' ', p.lastname) as fullname from Person p where p.id=?1")
    String getFullNameById(Long id);

    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByNameContaining(String name);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName(String name, String programmingLanguage);

    @Query("select p from Person p where p.name=:name and p.programmingLanguage=:programmingLanguage")
    List<Person> findByProgrammingLanguage(String name, String lastname ,String programmingLanguage );

    @Query("select p.name, p.programmingLanguage from Person p where p.name=:name and p.programmingLanguage=:programmingLanguage")
    List<Object[]> obtenerByProgrammingLanguage(String name, String lastname ,String programmingLanguage );
}
