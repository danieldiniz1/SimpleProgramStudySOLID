package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import br.com.alura.rh.ValidacaoException;

public class Funcionario {

	private DadosPessoais dadosPessoais;
	private LocalDate dataUltimoReajuste;

	public Funcionario(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}


	public String getNome() {
		return dadosPessoais.getNome();
	}


	public String getCpf() {
		return dadosPessoais.getNome();
	}


	public Cargo getCargo() {
		return dadosPessoais.getCargo();
	}


	public BigDecimal getSalario() {
		return dadosPessoais.getSalario();
	}


	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public void atualizarSalario(BigDecimal salarioReajustado) {
		this.dadosPessoais.setSalario(salarioReajustado);
		this.dataUltimoReajuste = LocalDate.now();
	}

    public void promover(Cargo novoCargo) {
		dadosPessoais.setCargo(novoCargo);
    }
}
