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
 * WDCommand.java: Command subclass for the wd command, which sets the working directory
 * that the batch will execute within.
 */

import org.w3c.dom.Element;

public class WDCommand extends Command
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
