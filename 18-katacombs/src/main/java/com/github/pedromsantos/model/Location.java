package com.github.pedromsantos.model;

import java.util.List;

public class Location {
	private String description;
	private List<Direction> exits;
	private List<Item> items;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Direction> getExits() {
		return exits;
	}

	public void setExits(List<Direction> exits) {
		this.exits = exits;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}