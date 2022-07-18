package domain

import domain.Boletim
import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {

	private lateinit var criterioAtual : CriterioDeAprovacao

	// Configura critério a ser usado
	fun defineCriterio(criterio : CriterioDeAprovacao) {
		criterioAtual = criterio
	}

	// Gera o boletim fechado
	fun fechaBoletim(boletim : Boletim) : BoletimFechado{
		return BoletimFechado(
			mediaEPs = boletim.mediaEPs,
            mediaMiniEPs = boletim.mediaMiniEPs,			
            mediaFinal = criterioAtual.mediaFinal(boletim),
			foiAprovado = criterioAtual.estaAprovado(boletim)
        )
	}
}
