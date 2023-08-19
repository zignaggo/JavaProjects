import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    private ArrayList<Item> estoqueItems = new ArrayList<>();
    private Input input = new Input();
    private Scanner inputNormal = new Scanner(System.in);

    // Menu dos Itens
    public void menuTiposItens() {
        System.out.println(
                "\n|==========| " + "                Tipos de Itens            " + "  |==========|" +
                        "\n|==========| [1] - Doces                     " + "            |==========|" +
                        "\n|==========| [2] - Salgados                " + "              |==========|" +
                        "\n|==========| [3] - Bebidas                    " + "           |==========|" +
                        "\n|==========| [4] - Outro       " + "                          |==========|" +
                        "\nResposta: ");
    }

    //
    public void cadastrarItem() {
        int resposta = -1;
        while (resposta == -1) {
            menuTiposItens();
            resposta = input.getInt();
            try {
                verificaTipoItem(resposta);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

    }

    public void verificaTipoItem(int resposta) {
        if (resposta == 1) {
            try {
                System.out.println("\nCADASTRAR ITEM");

                System.out.println("Nome: ");
                String nome = inputNormal.next();

                System.out.println("Preço da Compra: ex: 1,5 ");
                Double precoCompra = inputNormal.nextDouble();

                System.out.println("Preço da Venda: ex: 2,5");
                Double precoVenda = inputNormal.nextDouble();

                System.out.println("Quantidade Comprada: ");
                int qtdComprada = inputNormal.nextInt();

                Item novoItem = new Doces(nome, precoCompra, precoVenda, qtdComprada);
                adicionarAoEstoque(novoItem);
                Collections.sort(estoqueItems);
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor válido!");
            }
        } else if (resposta == 2) {
            try {
                System.out.println("\nCADASTRAR ITEM");

                System.out.println("Nome: ");
                String nome = inputNormal.next();

                System.out.println("Preço da Compra: ex: 1,5 ");
                Double precoCompra = inputNormal.nextDouble();

                System.out.println("Preço da Venda: ex: 2,5");
                Double precoVenda = inputNormal.nextDouble();

                System.out.println("Quantidade Comprada: ");
                int qtdComprada = inputNormal.nextInt();

                Item novoItem = new Salgados(nome, precoCompra, precoVenda, qtdComprada);
                adicionarAoEstoque(novoItem);
                Collections.sort(estoqueItems);
            } catch (InputMismatchException e) {
                System.out.println("\nDigite um valor válido!");
            }
        } else if (resposta == 3) {
            try {
                System.out.println("\nCADASTRAR ITEM");

                System.out.println("Nome: ");
                String nome = inputNormal.next();

                System.out.println("Preço da Compra: ex: 1,5 ");
                Double precoCompra = inputNormal.nextDouble();

                System.out.println("Preço da Venda: ex: 2,5");
                Double precoVenda = inputNormal.nextDouble();

                System.out.println("Quantidade Comprada: ");
                int qtdComprada = inputNormal.nextInt();

                Item novoItem = new Bebidas(nome, precoCompra, precoVenda, qtdComprada);
                adicionarAoEstoque(novoItem);
                Collections.sort(estoqueItems);
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor válido!");
            }
        } else if (resposta == 4) {
            try {
                System.out.println("\nCADASTRAR ITEM");

                System.out.println("Nome: ");
                String nome = inputNormal.next();

                System.out.println("Descrição: ");
                String descricao = inputNormal.next();

                System.out.println("Preço da Compra: ex: 1,5 ");
                Double precoCompra = inputNormal.nextDouble();

                System.out.println("Preço da Venda: ex: 2,5");
                Double precoVenda = inputNormal.nextDouble();

                System.out.println("Quantidade Comprada: ");
                int qtdComprada = inputNormal.nextInt();

                Item novoItem = new Item(nome, descricao, precoCompra, precoVenda, qtdComprada);
                adicionarAoEstoque(novoItem);
                Collections.sort(estoqueItems);
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor válido!");
            }
        } else {
            throw new IllegalArgumentException("\nEscolha uma das opções mostradas!");
        }
    }

    public Double totalComprados(){
        Double total = 0.0;
        for(int indice = 0;indice<estoqueItems.size();indice++){
            total += estoqueItems.get(indice).calcularGastos();
        }
        return total;
    }

    public Double totalVendidos(){
        Double total = 0.0;
        for(int indice = 0;indice<estoqueItems.size();indice++){
            total += estoqueItems.get(indice).calcularVendas();
        }
        return total;
    }

    // ADICIONA ITEM NA LISTA
    public void adicionarAoEstoque(Item item) {
        this.estoqueItems.add(item);
    }

    // ADICIONA A QUANTIDADE DE ITENS VENDIDOS E RETIRA SE ESTIVER EM 0
    public void darBaixaItem(Item item, int quantidade) {
        if (item.getEstoque() - quantidade < 0) {
            throw new IllegalArgumentException("Quantidade selecionada maior que a disponível");
         }
        //else if(item.getEstoque() - quantidade == 0){
        //     removeItem(item, estoqueItems);
        // } 
        else {
            item.setQtdVendida(quantidade);
        }

    }

    // REMOVE ITEM DA LISTA
    public void removeItem(Item item, List<Item> lista) {
        lista.remove(item);
    }

    // MÉTODO QUE VENDE O ITEM EM SI
    public void venderItem() throws IndexOutOfBoundsException {

        System.out.println("-------- VENDER ITEM --------");
        mostrarItensEstoque();
        System.out.println("\nEscolha um Item: ");
        int respostaItem = inputNormal.nextInt();
        System.out.println("Digite a quantidade de itens que deseja vender: ");
        int respostaQtd = inputNormal.nextInt();
        darBaixaItem(estoqueItems.get(respostaItem), respostaQtd);

    }

    public ArrayList<Item> getEstoqueItems() {
        return estoqueItems;
    }

    // MENU DE ITENS
    public void mostrarItensEstoque() {

        if (this.estoqueItems.size() != 0) {
            System.out.println("\nLISTA DE ITENS NO ESTOQUE\n");
            for (int indice = 0; indice < estoqueItems.size(); indice++) {
                System.out.println("[" + indice + "] - " + estoqueItems.get(indice).getNome() + " | Quantidade: "
                        + estoqueItems.get(indice).getEstoque() + " | Tipo: "
                        + estoqueItems.get(indice).getDescricao());
            }
        } else {
            throw new EstoqueVazioException();
        }
    }

    // ORDENA A LISTA POR QUANTIDADE DE ESTOQUE
    public void ordernarLista() {
        Collections.sort(estoqueItems);
    }

    // GERA UM NOVO ARRAYLIST CONTENDO OS COM QUANTIDADE MENOR QUE 50
    public ArrayList<Item> pegarItensAbaixo50(ArrayList<Item> lista) {
        ArrayList<Item> lista50Menos = new ArrayList<>();
        for (int indice = 0; indice < lista.size(); indice++) {
            if (lista.get(indice).getEstoque() < 50) {
                lista50Menos.add(lista.get(indice));
            }
        }
        return lista50Menos;
    }

    // MENU DE ITENS COM QUANTIDADE ABAIXO DE 50
    public void mostrarItensAbaixo50() {
        if (estoqueItems.size() != 0) {
            System.out.println("LISTA ITENS DO ESTOQUE COM QUANTIDADE BAIXA ( < 50)");
            for (int indice = 0; indice < pegarItensAbaixo50(estoqueItems).size(); indice++) {
                System.out.println(
                        "[" + indice + "] - " + pegarItensAbaixo50(estoqueItems).get(indice).getNome()
                                + "| Quantidade: "
                                + pegarItensAbaixo50(estoqueItems).get(indice).getEstoque());
            }
        } else {
            throw new EstoqueVazioException();
        }
    }

    // ADICIONA ITENS NO ESTOQUE
    public void alterarQuantidadeEstoque() throws IndexOutOfBoundsException {

        mostrarEstoque();

        System.out.println("\nEscolha um Item: ");
        int respostaItem = inputNormal.nextInt();

        Item item = estoqueItems.get(respostaItem);

        System.out.println("\nDigite a quantidade desejada: ");
        int respostaQtd = inputNormal.nextInt();

        item.alterarEstoque(respostaQtd);
    }

    // REMOVER ITENS DO ESTOQUE

    public void removerItensEstoque() throws IndexOutOfBoundsException {
        mostrarEstoque();

        System.out.println("\nEscolha um Item: ");
        int respostaItem = inputNormal.nextInt();

        Item item = estoqueItems.get(respostaItem);

        removeItem(item, estoqueItems);
    }

    public void mostrarEstoque() {

        if (estoqueItems.size() != 0) {
            System.out.println("\nLISTA DE ITENS NO ESTOQUE\n");
            for (int indice = 0; indice < estoqueItems.size(); indice++) {
                System.out.println("[" + indice + "] - " + estoqueItems.get(indice).getNome() + "| Quantidade: "
                        + estoqueItems.get(indice).getEstoque());
            }
        } else {
            throw new EstoqueVazioException();
        }
    }

    public void mostrarSaldoIndividual() {
        if (estoqueItems.size() != 0) {
            System.out.println("\nSALDO DE ITENS NO ESTOQUE\n");
            for (int indice = 0; indice < estoqueItems.size(); indice++) {
                System.out.println("[" + indice + "] - " + estoqueItems.get(indice).getNome() + " | Receita: "
                        + estoqueItems.get(indice).calcularReceita() + " | Vendidos: " + estoqueItems.get(indice).getQtdVendida() + " | Comprados: " + estoqueItems.get(indice).getQtdComprada() + " | Preço-Compra: " + estoqueItems.get(indice).getPrecoCompra() + " | Preço-Venda: " + estoqueItems.get(indice).getPrecoVenda());
            }
        } else {
            throw new EstoqueVazioException();
        }
    }



    
}
