package batchprocessor.command;

import org.w3c.dom.Element;

/*
 * CS 5348 - Operating Systems Concepts
 * Project 1: Batch Language Processing
 * 
 * Authors:
 * Shiau Kang Wang (sxw160330)
 * Cheng Kai Huang (cxh152330)
 * Justin Fritcher (jrf130030)
 * 
 * PipeCmdCommand.java: Command subclass for the two cmd commands for a PipeCommand
 */

public class PipeCmdCommand extends Command 
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
