package com.example.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Restaurant;
import com.example.service.RestaurantService;
import com.example.service.LoginUserDetails;

@Controller
@RequestMapping("restaurants")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@ModelAttribute
	RestaurantForm setUpForm() {
		return new RestaurantForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	String list(Model model) {
		List<Restaurant> restaurants = restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);
		return "restaurants/list";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	String create(@Validated RestaurantForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if (result.hasErrors()) {
			return list(model);
		}
		Restaurant restaurant = new Restaurant();
		BeanUtils.copyProperties(form, restaurant);
		restaurantService.create(restaurant, userDetails.getUser());
		return "redirect:/restaurants";
	}
	
	@RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
	String editForm(@RequestParam Integer id, RestaurantForm form) {
		Restaurant restaurant = restaurantService.findOne(id);
		BeanUtils.copyProperties(restaurant, form);
		return "restaurants/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	String edit(@RequestParam Integer id, @Validated RestaurantForm form, BindingResult result, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if(result.hasErrors()) {
			return editForm(id, form);
		}
		Restaurant restaurant = new Restaurant();
		BeanUtils.copyProperties(form, restaurant);
		restaurant.setId(id);
		restaurantService.update(restaurant, userDetails.getUser());
		return "redirect:/restaurants";
	}
	
	@RequestMapping(value = "edit", params = "goToTop")
	String goToTop() {
		return "redirect:/restaurants";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	String edit(@RequestParam Integer id) {
		restaurantService.delete(id);
		return "redirect:/restaurants";
	}
}
