package com.company.tetris.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.company.tetris.block.*;

public class BlockPool {
	private Map<String, Stack<Block>> pool;
	
	public BlockPool() {
		pool = new HashMap<>();
		pool.put("I", new Stack<>());
		pool.put("J", new Stack<>());
		pool.put("L", new Stack<>());
		pool.put("O", new Stack<>());
		pool.put("S", new Stack<>());
		pool.put("T", new Stack<>());
		pool.put("Z", new Stack<>());
	}
	
	public Block getBlock(String type) {
		Stack<Block> blocks = pool.get(type);
		if(blocks == null || blocks.isEmpty()) {
			return BlockFactory.createBlock(type);
		}
		return blocks.pop();
	}
	
	public void returnBlock(Block block) {
		block.reset();
		Stack<Block> blocks = pool.get(block.getType());
		if(block !=null) { blocks.push(block); }
	}
}
