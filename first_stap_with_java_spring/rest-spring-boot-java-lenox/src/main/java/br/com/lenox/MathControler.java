package br.com.lenox;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lenox.exceptions.UnsupportedMathOperationException;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;

@RestController
public class MathControler {

	
	private  final AtomicLong counter = new AtomicLong();
	
	//diferente das query Strings, tem que por esse value pra poder aceitar o method=RequestMethod.GET
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}

		return convertToDouble(numberOne) +  convertToDouble(numberTwo) ;
	}
	@RequestMapping(value = "/sumJson/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public JsonMath somadorJson(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		Double soma =convertToDouble(numberOne) +  convertToDouble(numberTwo);
		String vetor[] = {numberOne,numberTwo};
		
		return new JsonMath(vetor, "soma" ,soma) ;
	}

	
	
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double sub(
			//errei o pathVariable, coloquei pathparam ai deu um erro doido kk
					@PathVariable(value = "numberOne") String numberOne,
					@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
		

		
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double mult(
				@PathVariable(value = "numberOne") String numberOne,
				@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
		
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double div(
				@PathVariable(value = "numberOne") String numberOne,
				@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
		
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			
			) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		
	}
	@RequestMapping(value = "/raiz/{numberOne}",method = RequestMethod.GET)
	public Double raiz(
			@PathVariable(value = "numberOne") String numberOne
			
			
			) throws Exception{
		
		if(!isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Error !!! Please set a numeric value"); 
		}
		return  Math.sqrt(convertToDouble(numberOne)) ;
		
	}
	
	
	
	

	private Double convertToDouble(String strNumber) {
		
		if (strNumber == null) return 0D;
		// BR 10,35 USA 10.25
		String number = strNumber.replaceAll(",", ".");
		
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	
}
