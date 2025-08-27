package com.company.tetris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.tetris.logic.GameState;
import com.company.tetris.service.TetrisService;

@Controller @RequestMapping("/tetris")
public class TetrisController {
	@Autowired private TetrisService tetrisService;
	
	@RequestMapping("/") @ResponseBody
	public String basic() {return "/";}
	
	@GetMapping
	public String gamaPage(Model model) {
		model.addAttribute("score", tetrisService.getScore());
		return "game";
	}
	
	@ResponseBody
    @GetMapping("/state")
    public GameState getState() { return tetrisService.getCurrentState(); }

    @ResponseBody
    @PostMapping("/move")
    public void move(@RequestParam String direction) { tetrisService.move(direction); }

    @ResponseBody
    @PostMapping("/drop")
    public void drop() { tetrisService.drop(); }

    @ResponseBody
    @PostMapping("/spawn")
    public void spawn() { tetrisService.spawn(); }
    
    @ResponseBody
    @PostMapping("/pause")
    public void pause() {tetrisService.pause();}
    
    @ResponseBody
    @PostMapping("/resume")
    public void resume() {tetrisService.resume();}
    
    @ResponseBody
    @PostMapping("/restart")
    public void restart() {tetrisService.restart();}
}
