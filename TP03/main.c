#include <stdio.h>
#include <stdlib.h>
#include "cidades.h"

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Uso: %s <nome_do_arquivo>\n", argv[0]);
        return 1;
    }

    const char *nomeArquivo = argv[1];

    Estrada *estrada = getEstrada(nomeArquivo);
    if (!estrada) {
        fprintf(stderr, "Erro ao ler o arquivo.\n");
        return 1;
    }

    double menorVizinhanca = calcularMenorVizinhanca(nomeArquivo);
    char *cidade = cidadeMenorVizinhanca(nomeArquivo);

    printf("A menor vizinhança é: %.2f\n", menorVizinhanca);
    printf("A cidade com a menor vizinhança é: %s\n", cidade);

    free(cidade);
    free(estrada->C);
    free(estrada);

    return 0;
}
