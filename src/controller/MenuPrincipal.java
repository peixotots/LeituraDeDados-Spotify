package controller;
import exception.OpcaoInvalidaException;
import util.Util;

import java.util.List;

public class MenuPrincipal extends Menu {
    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("FILTRO", List.of("...", "...", "...", "Sair"));

        int opcaoSelecionada = 0;

        do {
            try {
                System.out.println(menu);
                opcaoSelecionada = Util.lerNumeroInteiro("DIGITE UMA OPÇÃO:");
                switch (opcaoSelecionada) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.err.println("Encerrando o programa...");
                        break;
                    default:
                        throw new OpcaoInvalidaException();
                }
            } catch (OpcaoInvalidaException e) {
                System.err.println("Opção inválida! Por favor, digite uma opção válida.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (opcaoSelecionada != 5);
    }
}