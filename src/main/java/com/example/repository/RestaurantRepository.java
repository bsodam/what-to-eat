package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	@Query("SELECT x FROM Restaurant x ORDER BY x.category, x.restaurantName")
	List<Restaurant> findAllOrderByName();
}