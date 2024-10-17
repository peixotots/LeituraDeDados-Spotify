package util;

public class Util {

    public static String lerTexto(String pergunta) throws DadoInvalidoException {
        System.out.println(pergunta);
        String texto = entrada.nextLine();
        while (texto.isEmpty()) {
            System.err.println("Entrada inválida. Digite um texto válido.");
            texto = entrada.nextLine();
        }
        return texto;
    }


    public static int lerNumeroInteiro(String pergunta) throws OpcaoInvalidaException {
        System.out.println(pergunta);
        String texto = entrada.nextLine();
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            throw new OpcaoInvalidaException();
        }
    }

}
