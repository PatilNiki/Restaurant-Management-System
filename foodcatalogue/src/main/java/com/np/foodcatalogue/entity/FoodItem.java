package com.np.foodcatalogue.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String itemName;
	private String itemDescription;
	private Boolean isVeg;
	private Number price;
	private Integer restaurantId;
	
	@Column(nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer quantity;
	
}
