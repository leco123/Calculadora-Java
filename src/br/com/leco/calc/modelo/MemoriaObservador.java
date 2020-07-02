package br.com.leco.calc.modelo;

@FunctionalInterface
public interface MemoriaObservador {

	void valorAlterado(String novovalor);
}
