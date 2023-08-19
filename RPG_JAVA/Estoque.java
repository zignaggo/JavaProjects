
import java.util.ArrayList;

public class Estoque {
    private ArrayList<Item> estoqueItens = new ArrayList<>();

    public void adicionarItens(Item item){
        estoqueItens.add(item);
    }

    public void removerItens(Item item){
        estoqueItens.remove(item);
    }

    public int totalItens(){
        return estoqueItens.size(); 
    }

    public Item procurarItensIndice(int indice){
        return estoqueItens.get(indice);
    }

    public void adicionaQuantidade(int indice, int quantidade){
        estoqueItens.get(indice).adicionarQuantidade(quantidade);
    }

    public void venderItens(int indice, int quantidade){
        estoqueItens.get(indice).retirarQuantidade(quantidade);
    }
    
    public ArrayList<Item> getEstoque() {
        return estoqueItens;
    }
}
