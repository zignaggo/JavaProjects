public class Cantina {
    // ARRUMAR A PARTE DA RECEITA QUE ESTÁ FALTANDO AINDA
    private Estoque estoqueCantina = new Estoque();
    // private LimparConsole console = new LimparConsole();
    private Input input = new Input();
    private Cor cor = new Cor();
    private double totalVendidos;
    private double totalComprados;

    public void menu() {
        System.out.println(
                "\n|==========| " + "                Cantina-IFAL            " + "       |==========|" +
                        "\n|==========| [1] - Cadastrar itens no Estoque" + "               |==========|" +
                        "\n|==========| [2] - Remover itens do Estoque" + "                 |==========|" +
                        "\n|==========| [3] - Adicionar itens ao Estoque " + "              |==========|" +
                        "\n|==========| [4] - Vender Itens" + "                             |==========|" +
                        "\n|==========| [5] - Resumo itens do Estoque" + "                  |==========|" +
                        "\n|==========| [6] - Itens com Estoque baixo de 50" + "            |==========|" +
                        "\n|==========| [7] - Receita total(Lucros e/ou Prejuísos)" + "     |==========|" +
                        "\n|==========| [8] - Receita por Item(Lucros e/ou Prejuísos)" + "  |==========|" +
                        "\n|==========| " + cor.ansi_red + "[0] - Finalizar programa   " + cor.ansi_reset
                        + "               " + "     |==========|" + "\nResposta: ");
    }

    public void mostraReceitaGeral(double totalGastos, double totalVendidos){
        System.out.println("\nTotal Gastos: "+ totalGastos + "\nTotal Vendidos: " + totalVendidos + "\nReceita: " + (totalVendidos-totalGastos));
    }
    
    public void executa(int resposta) {
               if (resposta == 1) {
            try {
                estoqueCantina.cadastrarItem();
                this.totalComprados = estoqueCantina.totalComprados();
                this.totalVendidos = estoqueCantina.totalVendidos();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else if (resposta == 2) {
            try {
                estoqueCantina.removerItensEstoque();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\nItem não encontrado!");
            } catch (EstoqueVazioException e) {
                System.out.println(e.getMessage());
            }
        } else if (resposta == 3) {
            try {
                estoqueCantina.alterarQuantidadeEstoque();
                this.totalComprados = estoqueCantina.totalComprados();
                this.totalVendidos = estoqueCantina.totalVendidos();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Item não encontrado!");
            } catch (EstoqueVazioException e) {
                System.out.println(e.getMessage());
            }
        } else if (resposta == 4) {
            try {
                estoqueCantina.venderItem();
                this.totalVendidos = estoqueCantina.totalVendidos();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Item não encontrado!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (EstoqueVazioException e) {
                System.out.println(e.getMessage());
            }
        } else if (resposta == 5) {
            try {
                estoqueCantina.mostrarItensEstoque();
            } catch (EstoqueVazioException e) {
                System.out.println(e.getMessage());
            }
        } else if (resposta == 6) {
            try {
                estoqueCantina.mostrarItensAbaixo50();
            } catch (EstoqueVazioException e) {
                System.out.println(e.getMessage());
            }
        } else if (resposta == 7) {
            mostraReceitaGeral(this.totalComprados, this.totalVendidos);
        } else if(resposta == 8){
            try {
                estoqueCantina.mostrarSaldoIndividual();
            } catch (EstoqueVazioException e) {
                System.out.println(e.getMessage());
            }
        } else if (resposta == 0) {
        } else {
            throw new IllegalArgumentException("\nEscolha uma das opções mostradas!");
        }
    }

    public void start() {
        int resposta = -1;
        while (resposta != 0) {
            menu();
            resposta = input.getInt();
            try {
                executa(resposta);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    
}
