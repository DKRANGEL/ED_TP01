#include <stdio.h>
#include <stdlib.h>

typedef struct {
    float X;
    float Y;
} Ponto;

// Função para calcular a área de um triângulo
float AreaTriangulo(Ponto A, Ponto B, Ponto C) {
    return abs((A.X * (B.Y - C.Y) + B.X * (C.Y - A.Y) + C.X * (A.Y - B.Y)) / 2.0);
}

// Função para ler os vértices do polígono de um arquivo
Ponto *lerVertices(FILE *arquivo, int *numVertices) {
    fscanf(arquivo, "%d", numVertices);
    Ponto *vertices = (Ponto *)malloc(*numVertices * sizeof(Ponto));
    for (int i = 0; i < *numVertices; i++) {
        fscanf(arquivo, "%f %f", &vertices[i].X, &vertices[i].Y);
    }
    return vertices;
}

// Função para calcular a área do polígono
float AreaPoligono(Ponto *vertices, int numVertices) {
    float areaTotal = 0;
    for (int i = 1; i < numVertices - 1; i++) {
        areaTotal += AreaTriangulo(vertices[0], vertices[i], vertices[i + 1]);
    }
    return areaTotal;
}

int main() {
    FILE *arquivo = fopen("TrianguloABC.txt", "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
    }

    int numVertices;
    Ponto *vertices = lerVertices(arquivo, &numVertices);
    fclose(arquivo);

    float area = AreaPoligono(vertices, numVertices);
    printf("A área do polígono é %.2f\n", area);

    free(vertices);

    return 0;
}
