package batchprocessor;

/*
 * CS 5348 - Operating Systems Concepts
 * Project 1: Batch Language Processing
 * 
 * Authors:
 * Shiau Kang Wang (sxw160330)
 * Cheng Kai Huang (cxh152330)
 * Justin Fritcher (jrf130030)
 * 
 * ProcessException.java: Exception that is thrown when there are errors with the
 * execution of the batch file. 
 */

@SuppressWarnings("serial")
public class ProcessException extends Exception {
	public ProcessException(String message) 
	{
		super(message);
	}
	
	public ProcessException(String message, Throwable throwable)
	{
		super(message, throwable);
	}
}
