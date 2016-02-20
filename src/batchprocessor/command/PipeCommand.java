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

import batchprocessor.Batch;
import batchprocessor.ProcessException;

public class PipeCommand extends Command
{

	public PipeCommand(Element element) throws ProcessException
	{
		parse(element);
	}
	
	@Override
	public String describe() 
	{
//		return null;
		return "PipeCommand execute PipeCmdCommand";
	}
	
	@Override
	public void parse(Element element) throws ProcessException
	{
		id = element.getAttribute("id");
		if (id == null || id.isEmpty()) {
			throw new ProcessException("Missing id attribute in PIPE command");
		}
		
		PipeCmdCommand pcc = new PipeCmdCommand(element);
	}
	
	@Override
	public void execute(Batch batch) 
	{
		
	}

}
