package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Restaurant;
import com.example.domain.User;
import com.example.repository.RestaurantRepository;

@Service
@Transactional
public class RestaurantService {
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public List<Restaurant> findAll() {
		return restaurantRepository.findAllOrderByName();
	}
	
	public Restaurant findOne(Integer id) {
		return restaurantRepository.findOne(id);
	}
	
	public Restaurant create(Restaurant restaurant, User user) {
		restaurant.setUser(user);
		return restaurantRepository.save(restaurant);
	}
	
	public Restaurant update(Restaurant restaurant, User user) {
		restaurant.setUser(user);
		return restaurantRepository.save(restaurant);
	}
	
	public void delete(Integer id) {
		restaurantRepository.delete(id);
	}
}
