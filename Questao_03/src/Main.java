import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite as medidas dos lados do triângulo X:");
        double aX = scanner.nextDouble();
        double bX = scanner.nextDouble();
        double cX = scanner.nextDouble();

        System.out.println("Digite as medidas dos lados do triângulo Y:");
        double aY = scanner.nextDouble();
        double bY = scanner.nextDouble();
        double cY = scanner.nextDouble();

        Triangulo trianguloX = new Triangulo(aX, bX, cX);
        Triangulo trianguloY = new Triangulo(aY, bY, cY);

        double areaX = trianguloX.calcularArea();
        double areaY = trianguloY.calcularArea();

        System.out.printf("Área do triângulo X: %.2f\n", areaX);
        System.out.printf("Área do triângulo Y: %.2f\n", areaY);

        if (areaX > areaY) {
            System.out.println("O triângulo X possui a maior área.");
        } else if (areaY > areaX) {
            System.out.println("O triângulo Y possui a maior área.");
        } else {
            System.out.println("Os triângulos possuem áreas iguais.");
        }

        scanner.close();
    }
}