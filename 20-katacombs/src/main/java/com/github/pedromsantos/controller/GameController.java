package com.github.pedromsantos.controller;

import com.github.pedromsantos.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

	@PostMapping("/player")
	@ResponseStatus(HttpStatus.CREATED)
	public void startGame(@RequestBody Player player) {
		// TODO: Implement game start logic
	}

	@GetMapping("/player")
	public List<Player> listPlayers() {
		// TODO: Implement player listing logic
		return List.of();
	}

	@DeleteMapping("/{playerSid}")
	public String quitGame(@PathVariable String playerSid) {
		// TODO: Implement quit game logic
		return "Game Over";
	}
}