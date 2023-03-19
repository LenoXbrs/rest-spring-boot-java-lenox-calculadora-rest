package br.com.lenox.math;

public class SimpleMath {

	private Double result;

	public Double sum(Double a, Double b) {
		return result = a + b;
		
	}
	
	public Double subtraction(Double a, Double b) {
		return result = a-b;
		
	}

	public Double multiplication(Double a, Double b) {
		return result = a*b;
		
	}
	
	public Double division(Double a, Double b) {
		return result = a/b;
		
	}
	
	public Double mean(Double a, Double b) {
		return result =(a + b) / 2;
		
	}
	
	public Double squareRoot(Double a) {
		return result = Math.sqrt(a);
		
	}

	public Double getResult() {
		return result;
	}


	
	
	
	
}
