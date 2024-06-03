#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "cidades.h"

Estrada *getEstrada(const char *nomeArquivo) {
    FILE *arquivo = fopen(nomeArquivo, "r");
    if (!arquivo) {
        return NULL;
    }

    Estrada *estrada = (Estrada *)malloc(sizeof(Estrada));
    if (!estrada) {
        fclose(arquivo);
        return NULL;
    }

    fscanf(arquivo, "%d", &(estrada->T));
    fscanf(arquivo, "%d", &(estrada->N));

    estrada->C = (Cidade *)malloc(estrada->N * sizeof(Cidade));
    if (!estrada->C) {
        free(estrada);
        fclose(arquivo);
        return NULL;
    }

    for (int i = 0; i < estrada->N; i++) {
        fscanf(arquivo, "%d %s", &(estrada->C[i].Posicao), estrada->C[i].Nome);
    }

    fclose(arquivo);
    return estrada;
}

double calcularMenorVizinhanca(const char *nomeArquivo) {
    Estrada *estrada = getEstrada(nomeArquivo);
    if (!estrada) {
        return -1;
    }

    double menorVizinhanca = estrada->T;
    for (int i = 0; i < estrada->N; i++) {
        double vizinhanca;
        if (i == 0) {
            vizinhanca = (estrada->C[i + 1].Posicao - estrada->C[i].Posicao) / 2.0;
        } else if (i == estrada->N - 1) {
            vizinhanca = (estrada->C[i].Posicao - estrada->C[i - 1].Posicao) / 2.0;
        } else {
            double vizinhancaEsquerda = (estrada->C[i].Posicao - estrada->C[i - 1].Posicao) / 2.0;
            double vizinhancaDireita = (estrada->C[i + 1].Posicao - estrada->C[i].Posicao) / 2.0;
            vizinhanca = vizinhancaEsquerda < vizinhancaDireita ? vizinhancaEsquerda : vizinhancaDireita;
        }
        if (vizinhanca < menorVizinhanca) {
            menorVizinhanca = vizinhanca;
        }
    }

    free(estrada->C);
    free(estrada);
    return menorVizinhanca;
}

char *cidadeMenorVizinhanca(const char *nomeArquivo) {
    Estrada *estrada = getEstrada(nomeArquivo);
    if (!estrada) {
        return NULL;
    }

    double menorVizinhanca = estrada->T;
    int indiceMenorVizinhanca = 0;
    for (int i = 0; i < estrada->N; i++) {
        double vizinhanca;
        if (i == 0) {
            vizinhanca = (estrada->C[i + 1].Posicao - estrada->C[i].Posicao) / 2.0;
        } else if (i == estrada->N - 1) {
            vizinhanca = (estrada->C[i].Posicao - estrada->C[i - 1].Posicao) / 2.0;
        } else {
            double vizinhancaEsquerda = (estrada->C[i].Posicao - estrada->C[i - 1].Posicao) / 2.0;
            double vizinhancaDireita = (estrada->C[i + 1].Posicao - estrada->C[i].Posicao) / 2.0;
            vizinhanca = vizinhancaEsquerda < vizinhancaDireita ? vizinhancaEsquerda : vizinhancaDireita;
        }
        if (vizinhanca < menorVizinhanca) {
            menorVizinhanca = vizinhanca;
            indiceMenorVizinhanca = i;
        }
    }

    char *cidade = (char *)malloc(strlen(estrada->C[indiceMenorVizinhanca].Nome) + 1);
    strcpy(cidade, estrada->C[indiceMenorVizinhanca].Nome);

    free(estrada->C);
    free(estrada);
    return cidade;
}
