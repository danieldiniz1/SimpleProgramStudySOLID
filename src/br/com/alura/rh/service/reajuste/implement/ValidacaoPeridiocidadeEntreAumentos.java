package br.com.alura.rh.service.reajuste.implement;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.reajuste.ValidacaoReajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeridiocidadeEntreAumentos implements ValidacaoReajuste {

    private LocalDate dataAtual = LocalDate.now();
    private Long minimoMesesParaAumento = 6L; // valor defaut é 6 meses, regra de negócio;

    public void alteraMinimoMesesParaAumento(Long minimoMesesParaAumento) {
        this.minimoMesesParaAumento = minimoMesesParaAumento;
    }

    public void validar(Funcionario funcionario, BigDecimal aumento){
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        if (ChronoUnit.MONTHS.between(this.dataAtual, dataUltimoReajuste) < minimoMesesParaAumento) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser, de no mínimo, 6 meses a contar do" +
                    "útimo reajuste");
        }
    }
}
