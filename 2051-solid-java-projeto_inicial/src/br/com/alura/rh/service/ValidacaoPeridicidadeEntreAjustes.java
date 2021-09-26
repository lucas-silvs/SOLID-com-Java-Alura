package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeridicidadeEntreAjustes implements  ValidacaoReajuste{
    public void  validar(Funcionario funcionario, BigDecimal aumento){
        LocalDate dataAtual = LocalDate.now();
        LocalDate DataUltimoReajuste = funcionario.getDataUltimoReajuste();

        long mesesDeseUltimoReajuste = ChronoUnit.MONTHS.between(DataUltimoReajuste, dataAtual);

        if(mesesDeseUltimoReajuste < 6){
            throw  new ValidacaoException("Intervalo entre reajuste deve ser no mínimo 6 meses");
        }

    }
}
