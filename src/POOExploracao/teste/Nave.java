package POOExploracao.teste;

public class Nave extends IDCounter{

    private static int contador = 1;

    private String nome;
    private String tipo;
    private int capacidade;

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

   public int getId() {
        return super.getId();
   }

    public Nave (String nome, String tipo, int capacidade){
        super(contador++);
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

}
