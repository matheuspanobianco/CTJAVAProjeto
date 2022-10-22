import java.util.Scanner;

public class MainConversorTemperatura {

    public static void main(String[] args) {

        boolean erro = false;

        while (!erro) {

            try {

                Scanner teclado = new Scanner(System.in);
                int quantidadeTemperaturas;
                int unidadeOrigem;
                int unidadeTransformada;

                System.out.println("Digite a quantidade de temperaturas a serem transformadas: ");
                quantidadeTemperaturas = teclado.nextInt();
                double[] temperaturasDigitadas = new double[quantidadeTemperaturas];
                double[] temperaturasTransformadas = new double[quantidadeTemperaturas];

                do {
                    System.out.println("Digite o número da opção da(s) temperatura(s) inserida(s):\n 1 - Celsius\n 2 - Kelvin\n 3 - Fahrenheit");
                    unidadeOrigem = teclado.nextInt();
                    System.out.println("Digite o número da opção da(s) temperatura(s) tranformada(s):\n 1 - Celsius\n 2 - Kelvin\n 3 - Fahrenheit");
                    unidadeTransformada = teclado.nextInt();
                } while (unidadeOrigem < 0 || unidadeOrigem > 3 || unidadeTransformada < 0 || unidadeTransformada > 3);

                for (int i = 0; i < temperaturasDigitadas.length; i++) {
                    System.out.println("Digite a " + (i + 1) + "ª temperatura a ser transformada:");
                    temperaturasDigitadas[i] = teclado.nextDouble();
                }

                switch (unidadeOrigem) {
                    case 1:
                        switch (unidadeTransformada) {
                            case 2:
                                for (int i = 0; i < temperaturasDigitadas.length; i++) {
                                    temperaturasTransformadas[i] = temperaturasDigitadas[i] + 273;
                                    System.out.println("A temperatura " + temperaturasDigitadas[i] + "ºC em Kelvin é: " + temperaturasTransformadas[i] + "ºK");
                                }
                                break;
                            case 3:
                                for (int i = 0; i < temperaturasDigitadas.length; i++) {
                                    temperaturasTransformadas[i] = (temperaturasDigitadas[i] * 1.8) + 32;
                                    System.out.println("A temperatura " + temperaturasDigitadas[i] + "ºC em Fahrenheit é: " + temperaturasTransformadas[i] + "ºF");
                                }
                                break;
                        }
                        break;

                    case 2:
                        switch (unidadeTransformada) {
                            case 1:
                                for (int i = 0; i < temperaturasDigitadas.length; i++) {
                                    temperaturasTransformadas[i] = temperaturasDigitadas[i] - 273;
                                    System.out.println("A temperatura " + temperaturasDigitadas[i] + "ºK em Celsius é: " + temperaturasTransformadas[i] + "ºC");
                                }
                                break;
                            case 3:
                                for (int i = 0; i < temperaturasDigitadas.length; i++) {
                                    temperaturasTransformadas[i] = ((temperaturasDigitadas[i] - 273) * 1.8) + 32;
                                    System.out.println("A temperatura " + temperaturasDigitadas[i] + "ºK em Fahrenheit é: " + temperaturasTransformadas[i] + "ºF");
                                }
                                break;
                        }
                        break;

                    case 3:
                        switch (unidadeTransformada) {
                            case 1:
                                for (int i = 0; i < temperaturasDigitadas.length; i++) {
                                    temperaturasTransformadas[i] = (temperaturasDigitadas[i] - 32) / 1.8;
                                    System.out.println("A temperatura " + temperaturasDigitadas[i] + "ºF em Celsius é: " + temperaturasTransformadas[i] + "ºC");
                                }
                                break;
                            case 2:
                                for (int i = 0; i < temperaturasDigitadas.length; i++) {
                                    temperaturasTransformadas[i] = ((temperaturasDigitadas[i] - 32) * (5 / 9d)) + 273;
                                    System.out.println("A temperatura " + temperaturasDigitadas[i] + "ºF em Kelvin é: " + temperaturasTransformadas[i] + "ºK");
                                }
                                break;
                        }
                        break;

                    default:
                        break;

                }

                somasEMedias(temperaturasDigitadas, temperaturasDigitadas, quantidadeTemperaturas, "A media das temperaturas antes da conversão é: ");

                somasEMedias(temperaturasDigitadas, temperaturasTransformadas, quantidadeTemperaturas, "A media das temperaturas depois da conversão é: ");

                erro = true;

            } catch (Exception e) {
                System.out.println("Dados invalidos, insira novamente...");
            }
        }
    }

    private static void somasEMedias(double[] temperaturasDigitadas, double[] temperaturasDigitadas1, int quantidadeTemperaturas, String x) {
        double somaDigitadas = 0;
        for (int i = 0; i < temperaturasDigitadas.length; i++) {
            somaDigitadas = somaDigitadas + temperaturasDigitadas1[i];
        }

        double mediaDigitadas = somaDigitadas / quantidadeTemperaturas;
        System.out.println(x + mediaDigitadas);
    }
}

