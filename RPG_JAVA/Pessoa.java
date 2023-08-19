
import java.util.ArrayList;

public class Pessoa{
    private String nome;
    private Double carteira;
    private Double valorGasto;
    private ArrayList<Item> bolsa = new ArrayList<>();

    public Pessoa(String nome, Double carteira){
        this.nome = nome;
        this.carteira = carteira;
    }


    // GETS
    public String getNome() {
        return nome;
    }

    public Double getCarteira() {
        return carteira;
    }

    // SETS
    public Double getValorGasto() {
        return valorGasto;
    }

    public void setMoeda(Double moeda) {
        this.carteira = moeda;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void gastar(Double valor){
        this.carteira -= valor;
    }

    
    public void comprar(double valor){
        if(this.carteira - valor >= 0){
            this.carteira -= valor;
            System.out.println("\nCompra Realizada!");
        }else{
           throw new IllegalArgumentException("\nSaldo insuficiente: "+this.carteira+"\n Total-Compra: "+valor);
        }

    }

    // ADICIONAR ITEM NA BOLSA
    public void adicionarItemBolsa(Item item){
        if(bolsa.contains(item) == true){
            bolsa.get(bolsa.indexOf(item)).adicionarQuantidadeIp(item.getQuantidade(), item);
        }
        this.bolsa.add(item);
    }


    public void retirarItemBolsa(Item item){
        if(bolsa.contains(item) == true){
            bolsa.get(bolsa.indexOf(item)).retirarQuantidade(item.getQuantidade());
        }
    }

    public ArrayList<Item> getBolsa(){
        return bolsa;
    }

    @Override
    public String toString() {
        return "Nome: "+this.nome+" | Saldo Carteira: " + this.carteira;
    }
}