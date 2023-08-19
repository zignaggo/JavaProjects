

import java.util.ArrayList;

public class Cadastros {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    // ADICIONAR PESSOAS AO BANCO DE DADOS
    public void adicionarPessoas(Pessoa novaPessoa) throws IllegalArgumentException {
        pessoas.add(novaPessoa);
        System.out.println("\nPessoa Adicionada!");
    }

    // REMOVER PESSOAS DO BANCO DE DADOS
    public void removerPessoas(Pessoa pessoaParaRemover) {
        pessoas.remove(pessoaParaRemover);
    }

    public int totalCadastrados() {
        return pessoas.size();
    }

    public Pessoa procurarPessoaIndice(int indice) {
        return pessoas.get(indice);
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void mostraIventario(int indicePessoa) throws IndexOutOfBoundsException{
        ArrayList<Item> bolsa = pessoas.get(indicePessoa).getBolsa();
        if (bolsa.size() == 0) {
            System.out.println("\nInventário");
            System.out.println(pessoas.get(indicePessoa) + "\n" + "Bolsa: Nada aqui...");
        } else {
            System.out.println("\nInventário");
            System.out.println(pessoas.get(indicePessoa) + "\nBolsa: ");
            for (int indice = 0; indice < bolsa.size(); indice++) {
                System.out.println("[" + indice + "] - " + bolsa.get(indice));
            }
        }

    }

    
}
