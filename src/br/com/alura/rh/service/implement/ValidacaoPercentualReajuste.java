package br.com.alura.rh.service.implement;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.ValidacaoReajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    private String reajusteMaximo;

    public String getReajusteMaximo() {
        return reajusteMaximo;
    }

    public void setReajusteMaximo(String reajusteMaximo) {
        this.reajusteMaximo = reajusteMaximo;
    }

    public void validar(Funcionario funcionario, BigDecimal aumento){
        BigDecimal percentualReajuste = aumento.divide(funcionario.getSalario(), RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal(this.reajusteMaximo))>0){
            throw new ValidacaoException("Reajuste não pode ser superior a " + this.reajusteMaximo + " %");
        }
        
    }
}
