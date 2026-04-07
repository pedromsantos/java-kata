package com.github.pedromsantos.controller;

import com.github.pedromsantos.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@GetMapping("/items/{itemSid}")
	public Item getItemDescription(@PathVariable String itemSid) {
		// TODO: Implement item description logic
		return new Item();
	}

	@GetMapping("/{playerSid}/bag")
	public List<Item> getBag(@PathVariable String playerSid) {
		// TODO: Implement bag content logic
		return List.of();
	}

	@PutMapping("/{playerSid}/item/{itemSid}/use/{action}")
	public void useItem(@PathVariable String playerSid,
			@PathVariable String itemSid,
			@PathVariable Action action) {
		// TODO: Implement item usage logic
	}

	@GetMapping("/{playerSid}/location")
	public Location lookAround(@PathVariable String playerSid) {
		// TODO: Implement look around logic
		return new Location();
	}

	@GetMapping("/{playerSid}/look/{direction}")
	public Location getDirectionDescription(@PathVariable String playerSid,
			@PathVariable Direction direction) {
		// TODO: Implement direction look logic
		return new Location();
	}

	@PutMapping("/{playerSid}/move/{direction}")
	public void move(@PathVariable String playerSid,
			@PathVariable Direction direction) {
		// TODO: Implement move logic
	}
}