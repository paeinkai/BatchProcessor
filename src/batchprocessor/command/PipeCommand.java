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
 * PipeCommand.java: Command subclass for the pipe command, which is an interconnection
 * between two processes. Requires two sub-commands (PipeCmdCommand) that will be executed
 * concurrently.
 */

import org.w3c.dom.Element;

public class PipeCommand extends Command
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
