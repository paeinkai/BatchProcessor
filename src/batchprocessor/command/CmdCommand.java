package batchprocessor.command;

/*
 * CS 5348 - Operating Systems Concepts
 * Project 1: Batch Language Processing
 * 
 * Authors:
 * Shiau Kang Wang (sxw160330)
 * Cheng Kai Huang (cxh152330)
 * Justin Fritcher (jrf130030)
 * 
 * CmdCommand.java: Command subclass for the cmd command, which defines a command
 * that will be executed in a process.
 */

import org.w3c.dom.Element;

public class CmdCommand extends Command 
{

	@Override
	public String describe() 
	{
		return null;
	}
	
	@Override
	public void parse(Element element) 
	{
		
	}
	
	@Override
	public void execute(String workingDir) 
	{
		
	}

}
