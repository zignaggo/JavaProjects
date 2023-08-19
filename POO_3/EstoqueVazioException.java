public class EstoqueVazioException extends RuntimeException {
    
    public EstoqueVazioException(){
        super("\nEstoque Vazio! Por favor cadastre algum produto!");
    }
}
