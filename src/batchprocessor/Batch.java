package batchprocessor;

/*
 * CS 5348: Operating Systems Concepts
 * Project 1: Batch Language Processing
 * 
 * Authors:
 * 	Shiau Kang Wang (sxw160330)
 * 	Cheng Kai Huang (cxh152330)
 * 	Justin Fritcher (jrf130030)
 * 
 * Batch.java: Maintains the N commands that were parsed from the given batch file.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import batchprocessor.command.Command;

public class Batch 
{

	private String workingDir;
	private Map<String,Command> cmdLookup;
	private List<Command> commandList;
	
	public Batch()
	{
		workingDir = "";
		commandList = new ArrayList<Command>();
		cmdLookup = new HashMap<String,Command>();
	}
	
	public void addCommand(Command command) 
	{
		commandList.add(command);
		if (cmdLookup.containsKey(command.getID()))
		{
			System.err.println("Warning: duplicate command id, previous value replaced");
		}
		cmdLookup.put(command.getID(), command);
	}
	
	public String getWorkingDir()
	{
		return workingDir;
	}
	
	public void setWorkingDir(String workingDir)
	{
		this.workingDir = workingDir;
	}
	
	public Map<String,Command> getCommands()
	{
		return cmdLookup;
	}
	
	public List<Command> getCommandList()
	{
		return commandList;
	}
	
}
