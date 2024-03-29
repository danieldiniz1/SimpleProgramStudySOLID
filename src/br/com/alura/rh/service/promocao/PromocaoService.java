package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, Boolean metaBatida) {
        Cargo cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerente não pode ser promovido!");
        }
        if(!metaBatida) {
            throw new ValidacaoException("Funcionário não bateu a meta e não pode ser promovido");
        }
        Cargo novoCargo = cargoAtual.getProximoCargo();
        funcionario.promover(novoCargo);
    }
}
