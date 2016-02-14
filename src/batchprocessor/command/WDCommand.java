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

import batchprocessor.ProcessException;

public class WDCommand extends Command
{
	public WDCommand(Element element) throws ProcessException
	{
		parse(element);	
	}

	@Override
	public String describe() 
	{
		return null;
	}
	
	@Override
	public void parse(Element element) throws ProcessException
	{	
		throw new ProcessException("");	
	}

	@Override
	public void execute(String workingDir) 
	{
		
	}
		
}
