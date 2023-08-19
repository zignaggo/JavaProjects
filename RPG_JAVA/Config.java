
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Config {
    private Cor cor = new Cor();
    private Cadastros cadastrados = new Cadastros();
    private Estoque estoqueConfig = new Estoque();
    private Input input = new Input();

    // MENUS

    public void menuConfig(){
        System.out.println(
                           "\n| ------------|CONFIG|------------- |"+
                         "\n| "+cor.ansi_green+"[1] - Cadastrar Pessoas"+cor.ansi_reset+"           |"+
                         "\n| "+cor.ansi_red_under+"[2] - Remover Pessoas"+cor.ansi_reset+"             |"+
                         "\n| "+cor.ansi_purple+"[3] - Mostrar Todos Cadastros"+cor.ansi_reset+"     |"+
                         "\n| _________________________________ |"+
                         "\n| "+cor.ansi_green+"[4] - Cadastrar Itens no Estoque"+cor.ansi_reset+"  |"+
                         "\n| "+cor.ansi_red_under+"[5] - Remover Itens no Estoque"+cor.ansi_reset+"    |"+
                         "\n| "+cor.ansi_cyan+"[6] - Adicionar Itens no Estoque"+cor.ansi_reset+"  |"+
                         "\n| "+cor.ansi_purple+"[7] - Mostrar Estoque"+cor.ansi_reset+"             |"+
                         "\n| "+cor.ansi_red+"[0] - Voltar"+cor.ansi_reset+"                      |"+
                         "\n| --------------------------------- |"+
                         "\nResposta: "
                         );
    }

    public void executaConfig(int resposta){
        if(resposta == 1){
            cadastrarPessoa();
        }else if(resposta == 2){
            try {
                removerPessoas();
            } catch (SemAlgoCadastrado e) {
                System.out.println(e.getMessage());
            }
        
        }else if(resposta == 3){
            try {
                mostrarPessoasCadastradas();
            } catch (SemAlgoCadastrado e) {
                System.out.println(e.getMessage());
            }
        }else if(resposta == 4){
            cadastrarItem();
        }else if(resposta == 5){
            try {
                removerItem();
            } catch (SemAlgoCadastrado e) {
                System.out.println(e.getMessage());
            }
        }else if(resposta == 6){
            try {
                adicionarEstoqueItens();
            } catch (SemAlgoCadastrado e) {
                System.out.println(e.getMessage());
            }
        }else if(resposta == 7){
            try {
                mostrarTodosItens();
            } catch (SemAlgoCadastrado e) {
                System.out.println(e.getMessage());
            }
        }else if(resposta == 0){
        }else{
            throw new IllegalArgumentException("\nEscolha uma das opções mostradas!");  
        }
    }

    public void startConfig(){
        int resposta = -1;
        while (resposta != 0) {
            menuConfig();
            resposta = input.getIntLoop();
            try {
                executaConfig(resposta);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // LOJA

    

    // ITENS 1.0
    public void cadastrarItem() {
        try {
            System.out.println("\nCADASTRAR ITEM");

            System.out.println("Nome do Item: ");
            String nome = input.getString();

            System.out.println("Tipo do Item: ");
            String tipo = input.getString();

            System.out.println("Valor do Item: ex: 1,5 ");
            Double valor = input.getDouble();

            System.out.println("Quantidade Comprada: ");
            int qtdComprada = input.getInt();

            Item novoItem = new Item(nome, valor, tipo, qtdComprada);
            estoqueConfig.adicionarItens(novoItem);
            System.out.println("Cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("\nDigite um valor válido!");
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        
    }

    // ITENS 1.1
    public void mostrarTodosItens() {
        if (estoqueConfig.totalItens() != 0) {
            System.out.println("\nITENS CADASTRADOS NO ESTOQUE");
            for (int indice = 0; indice < estoqueConfig.totalItens(); indice++) {
                System.out.println("[" + indice + "] - " + estoqueConfig.procurarItensIndice(indice).toString());
            }
        } else {
            throw new SemAlgoCadastrado("Item");
        }
    }

    // ITENS 1.2
    public void removerItem() {
        mostrarTodosItens();
        try {
            System.out.println("\nResposta: ");
            int resposta = input.getInt();
            estoqueConfig.removerItens(estoqueConfig.procurarItensIndice(resposta));
            System.out.println("\nItem removido com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("\nDigite um valor válido!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nItem não encontrado!");
        }
        
    }

    // PESSOAS 1.0
    public void cadastrarPessoa() {
        try {
            System.out.println("\nCADASTRAR PESSOAS");

            System.out.println("Nome: ");
            String nome = input.getString();

            System.out.println("Valor na Carteira: ex: 100,5 ");
            Double valor = input.getDouble();

            Pessoa novaPessoa = new Pessoa(nome, valor);
            cadastrados.adicionarPessoas(novaPessoa);
            System.out.println("\nCadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("\nDigite um valor válido!");
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
    }

    // PESSOAS 1.1
    public void removerPessoas() throws SemAlgoCadastrado{
        mostrarPessoasCadastradas();
        try {
            System.out.println("\nResposta: ");
            int resposta = input.getInt();
            cadastrados.removerPessoas(cadastrados.procurarPessoaIndice(resposta));
            System.out.println("\nPessoa removida com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("\nDigite um valor válido!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nPessoa não encontrada!");
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        
    }

    // PESSOAS 1.2
    public void mostrarPessoasCadastradas() {
        if (cadastrados.totalCadastrados() != 0) {
            System.out.println("\nPESSOAS CADASTRADAS");
            for (int indice = 0; indice < cadastrados.totalCadastrados(); indice++) {
                System.out.println("[" + indice + "] - " + cadastrados.procurarPessoaIndice(indice).toString());
            }
        } else {
            throw new SemAlgoCadastrado("Pessoa");
        }
    }


    public void adicionarEstoqueItens(){
        mostrarTodosItens();
        try {
            System.out.println("\nResposta: ");
            int resposta = input.getInt();
            System.out.println("Quantidade a adicionar: ");
            int quantidade = input.getInt();
            estoqueConfig.adicionaQuantidade(resposta, quantidade);
        } catch (InputMismatchException e) {
            System.out.println("\nDigite um valor válido!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nItem não encontrado!");
        }
    }

    public ArrayList<Item> getEstoqueItens(){
        return estoqueConfig.getEstoque();
    }

    public ArrayList<Pessoa>  getCadastrados() {
        return cadastrados.getPessoas();
    }

    public void mostraInventario(int indicePessoa){
        cadastrados.mostraIventario(indicePessoa);
    }
}
