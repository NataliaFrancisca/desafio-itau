package br.com.nat.desafioitau.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.DoubleSummaryStatistics;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticaDTO {
    private long count;
    private double sum;
    private double min;
    private double max;
    private double average;

    public static EstatisticaDTO retornarEstatisticasVazias(){
        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();

        estatisticaDTO.setCount(0);
        estatisticaDTO.setSum(0);
        estatisticaDTO.setMin(0);
        estatisticaDTO.setMax(0);
        estatisticaDTO.setAverage(0);

        return estatisticaDTO;
    }

    public static EstatisticaDTO retornarEstatisticasCompletas(DoubleSummaryStatistics valores) {
        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();

        estatisticaDTO.setCount(valores.getCount());
        estatisticaDTO.setSum(valores.getSum());
        estatisticaDTO.setMin(valores.getMin());
        estatisticaDTO.setMax(valores.getMax());
        estatisticaDTO.setAverage(valores.getAverage());

        return estatisticaDTO;
    }
}

