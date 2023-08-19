public class Item implements Comparable<Item>{
    private String nome;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private int qtdComprada;
    private int qtdVendida = 0;
    private int estoque;

    public Item(String nome, String descricao, double precoCompra, double precoVenda, int qtdComprada){
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        
        // EXCESSÕES
        if(qtdComprada > 0){
            this.qtdComprada = qtdComprada;
            this.estoque = qtdComprada;
        }else{
            throw new IllegalArgumentException("Quantidade do item inválida!");
        }

        if(precoVenda <= 0 || precoCompra <= 0){
            throw new IllegalArgumentException("Preço de Compra e/ou Venda inválidos:");
        }else{
            if(precoVenda > precoCompra){
                this.precoVenda = precoVenda;
            }else{
                throw new IllegalArgumentException("Preço de Venda menor que o de compra!");
            }
        }

        

    }


    @Override
    public String toString() {
        String string = "Nome:" + this.nome + 
                        "\nDescrição: " + this.descricao +
                        "\nPreço de Compra: " + this.precoCompra +
                        "\nPreço de Venda: " + this.precoVenda +
                        "\nEstoque: " + this.estoque + " Itens";
        return string;
    }

    // GETS PADRÕES
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }
    
    public double getPrecoVenda() {
        return precoVenda;
    }

    public int getQtdComprada() {
        return qtdComprada;
    }

    public int getQtdVendida() {
        return qtdVendida;
    }

    public int getEstoque() {
        return estoque;
    }

    // SETS PADRÕES
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }
    
    public void setPrecoVenda(double precoVenda) {
        if(precoVenda > this.precoCompra){
            this.precoVenda = precoVenda;
        }else{
            throw new IllegalArgumentException("Preço de Venda menor que o de compra!");
        }
    }

    // QUANTIDADE ITENS 
    public void alterarEstoque(int qtdItens) {
        if(qtdItens > 0){
            this.qtdComprada += qtdItens;
            this.estoque = this.qtdComprada - this.qtdVendida;
        }else{
            throw new IllegalArgumentException("Quantidade do item inválida!");
        }
    }


    // CALCULAR RECEITA;
    public double calcularVendas(){
        double total = this.precoVenda * this.qtdVendida;
        return total;
    }

    public double calcularGastos(){
        double total = this.precoCompra * this.qtdComprada;
        return total;
    }

    public double calcularReceita(){
        return calcularVendas() - calcularGastos();
    }

    // ADICIONAR QUANTIDADE VENDIDA E RETIRAR DOE ESTOQUE
    public void setQtdVendida(int qtdVendida) {
        if(qtdVendida <= this.qtdComprada && qtdVendida > 0){
            this.qtdVendida += qtdVendida;
            this.estoque -= qtdVendida;
        }else{
            throw new IllegalArgumentException("A quantidade de itens vendidos tem que ser maior que 0!");
         }
        //     throw new IllegalArgumentException("Quantidade de itens vendidos maior que comprados!");
        // }
    }

    // COMPARAÇÃO ENTRE CONTAS COM PARÂMETRO DE NÚMERO NO ESTOQUE
    @Override
    public int compareTo(Item outraConta) {
        if(this.estoque < outraConta.estoque){
            return -1;
        }

        if(this.estoque > outraConta.estoque){
            return 1;
        }

        return 0;
    }


}