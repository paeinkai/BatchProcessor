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

import java.util.List;
import java.util.Map;

import batchprocessor.command.Command;

public class Batch 
{

	private String workingDir;
	private Map<String,Command> cmdLookup;
	private List<Command> commandList;
	
	
	public void addCommand(Command command) 
	{
		
	}
	
	
	public String getWorkingDir()
	{
		return this.workingDir;
	}
	
	public Map<String,Command> getCommands()
	{
		return this.cmdLookup;
	}
	
}
