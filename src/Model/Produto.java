package Model;

public class Produto {

    private int id;
    private String nome;
    private Double preco;
    private int quantidade;


    //Construtor
    public Produto(int id, String nome, Double preco, int quantidade){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

   public int getId(){
        return id;
   }

   public String getNome(){
        return nome;
   }

   public Double getPreco(){
        return preco;
   }

   public int getQuantidade(){
        return quantidade;
   }


   public void setId(int id){
        this.id = id;
   }

   public void setNome(String nome){
        this.nome = nome;
   }

   public void setPreco(Double preco){
        this.preco = preco;
   }

   public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
   }


    @Override
    public String toString() {
        return "Produto{" +
                "id= " + id +
                ", nome = '" + nome + '\'' +
                ", preco = " + preco +
                ", quantidade =" + quantidade +
                '}';
    }
}
