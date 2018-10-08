package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

	// long count() Returns the number of entities
	// Iterable<T> findAll() Returns all items of given type
	// Optional<T> findById(ID Id) Returns one item by id
	// void delete(T entity) Deletes an entity
	// void deleteAll() Deletes all entities of the repository
	// <S extends T> save(S entity) Saves an entity

	List<Car> findByBrand(@Param("brand") String brand);
	List<Car> findByColor(@Param("color") String color);
	//List<Car> findByYear(int year);
}
