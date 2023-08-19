
public class Item {
    private String nome;
    private Double valor;
    private String tipo;
    private int quantidade;



    public Item(String nome, Double valor, String tipo, int quantidade){
        this.nome = nome;
        this.tipo = tipo;

        if(valor > 0){
            this.valor = valor;
        }else{
            throw new IllegalArgumentException("\nValor menor ou igual a 0!");
        }

        if(quantidade >= 0){
            this.quantidade = quantidade;
        }else{
            throw new IllegalArgumentException("\nQuantidade de itens não pode ser menor que 0!");
        }
    }
    
    // GETS
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // SETS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade > 0){
            this.quantidade = quantidade;
        }else{
            throw new IllegalArgumentException("\nQuantidade de item deve ser maior que 0!");
        }
        
    }

    public void adicionarQuantidade(int valor){
        if(valor > 0){
            this.quantidade += valor;
        }else{
            throw new IllegalArgumentException("\nValor menor ou igual a 0!");
        }
    }

    public void adicionarQuantidadeIp(int valor, Item item){
        if(valor > 0){
            item.quantidade += valor;
        }else{
            throw new IllegalArgumentException("\nValor menor ou igual a 0!");
        }
    }

    public void retirarQuantidade(int valor){
        if(valor > 0 ){
            if(this.quantidade >= valor){
                this.quantidade -= valor;
            }else{
                throw new IllegalArgumentException("\nValor maior do que o disponível!");
            }
        }else{
            throw new IllegalArgumentException("\nValor menor ou igual a 0!");
        }
    }

    public Double calcularTotal(int quantidade){
        return quantidade * this.valor;
    }
    // TABELA ITENS

    @Override
    public String toString() {
    
        return "Nome: "+this.nome +
               " | Tipo: "+this.tipo +
               " | Quantidade: "+this.quantidade +
               " | Valor: "+this.valor;
    }
}
