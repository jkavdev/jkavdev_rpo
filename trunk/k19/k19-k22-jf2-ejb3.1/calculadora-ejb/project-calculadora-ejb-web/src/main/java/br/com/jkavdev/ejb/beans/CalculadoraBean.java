package br.com.jkavdev.ejb.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.jkavdev.ejb.sessionbeans.Calculadora;

@ManagedBean(name="calcBean")
public class CalculadoraBean {

	@EJB
	private Calculadora calculadora;

	private double a;
	private double b;
	private double resultado;

	public void soma() {
		this.resultado = this.calculadora.soma(a, b);
	}

	public Calculadora getCalculadora() {
		return calculadora;
	}

	public void setCalculadora(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

}
