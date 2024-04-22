#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ALUNOS 100
#define MAX_NOME 50
#define MAX_CURSO 50
#define ARQUIVO_ENTRADA "C:\\ED_TP01\\TP01\\DadosEntrada.txt"
#define ARQUIVO_SAIDA "C:\\ED_TP01\\TP01\\SituacaoFinal.txt"

typedef struct {
    char nome[MAX_NOME];
    char telefone[15];
    char curso[MAX_CURSO];
    float notas[2];
    float media;
    char situacao[10];
} Aluno;

void lerAlunos(Aluno alunos[], int *totalAlunos) {
    FILE *arquivo = fopen(ARQUIVO_ENTRADA, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        exit(1);
    }

    *totalAlunos = 0;
    while (fscanf(arquivo, "%[^,],%[^,],%[^,],%f,%f\n", alunos[*totalAlunos].nome,
                alunos[*totalAlunos].telefone, alunos[*totalAlunos].curso,
                &alunos[*totalAlunos].notas[0], &alunos[*totalAlunos].notas[1]) != EOF) {
        (*totalAlunos)++;
    }

    fclose(arquivo);
}

void calcularMediaSituacao(Aluno alunos[], int totalAlunos) {
    for (int i = 0; i < totalAlunos; i++) {
        alunos[i].media = (alunos[i].notas[0] + alunos[i].notas[1]) / 2.0;
        if (alunos[i].media >= 7.0) {
            strcpy(alunos[i].situacao, "APROVADO");
        } else {
            strcpy(alunos[i].situacao, "REPROVADO");
        }
    }
}

void gerarArquivoSaida(Aluno alunos[], int totalAlunos) {
    FILE *arquivo = fopen(ARQUIVO_SAIDA, "w");
    if (arquivo == NULL) {
        printf("Erro ao criar o arquivo de saída.\n");
        exit(1);
    }

    for (int i = 0; i < totalAlunos; i++) {
        fprintf(arquivo, "%s, %.2f, %s\n", alunos[i].nome, alunos[i].media, alunos[i].situacao);
    }

    fclose(arquivo);
}

int main() {
    Aluno alunos[MAX_ALUNOS];
    int totalAlunos;

    lerAlunos(alunos, &totalAlunos);
    calcularMediaSituacao(alunos, totalAlunos);
    gerarArquivoSaida(alunos, totalAlunos);

    printf("Arquivo SituacaoFinal.csv gerado com sucesso!\n");

    return 0;
}
