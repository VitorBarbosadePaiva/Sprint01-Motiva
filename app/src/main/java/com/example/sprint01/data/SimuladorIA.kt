package com.example.sprint01.data

import com.example.sprint01.domain.TrechoRodovia

class SimuladorIA {
    fun obterTrechosMonitorizados(): List<TrechoRodovia> {
        return listOf(
            TrechoRodovia(1, "Km 45 - Rodovia Norte", "15/10/2023", "Verde", 15),
            TrechoRodovia(2, "Km 82 - Rodovia Sul", "10/10/2023", "Vermelho", 85),
            TrechoRodovia(3, "Km 12 - Via Expressa", "12/10/2023", "Amarelo", 45),
            TrechoRodovia(4, "Km 105 - Rodovia Leste", "01/10/2023", "Vermelho", 90)
        )
    }
}