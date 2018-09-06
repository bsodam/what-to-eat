package com.example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RestaurantForm {
	@NotNull
	@Size(min = 1, max = 127)
	private String category;
	@NotNull
	@Size(min = 1, max = 127)
	private String restaurantName;
}
