package com.ernesto.curso.springboot.jpa.springjpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ernesto.curso.springboot.jpa.springjpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);

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
