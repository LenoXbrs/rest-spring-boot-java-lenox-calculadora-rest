package br.com.lenox.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lenox.JsonMath;
import br.com.lenox.converters.NumberConverter;
import br.com.lenox.exceptions.UnsupportedMathOperationException;
import br.com.lenox.math.SimpleMath;


@RestController
public class MathControler {

	
	private  final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	//diferente das query Strings, tem que por esse value pra poder aceitar o method=RequestMethod.GET
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception {
		
	
	if(!NumberConverter.isNumeric(numberOne) ||!NumberConverter.isNumeric(numberTwo)) {
		throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
	}
	
	
		return math.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo)) ;
	}
	
	
	
	
	@RequestMapping(value = "/sumJson/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public JsonMath somadorJson(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) ||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		Double soma =math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
		String vetor[] = {numberOne,numberTwo};
		
		return new JsonMath(vetor, "soma" ,soma) ;
	}

	
	
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double sub(
			//errei o pathVariable, coloquei pathparam ai deu um erro doido kk
					@PathVariable(value = "numberOne") String numberOne,
					@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		
		if(!NumberConverter.isNumeric(numberOne) ||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
		

		
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double mult(
				@PathVariable(value = "numberOne") String numberOne,
				@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) ||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return math.multiplication(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double div(
				@PathVariable(value = "numberOne") String numberOne,
				@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) ||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) ||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	@RequestMapping(value = "/squareRoot/{numberOne}",method = RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "numberOne") String numberOne
			
			
			) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return  math.squareRoot(NumberConverter.convertToDouble(numberOne)) ;
		
	}
	
	
	
	




	
	
}
