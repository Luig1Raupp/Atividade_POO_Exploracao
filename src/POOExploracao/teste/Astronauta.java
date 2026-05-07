package POOExploracao.teste;

public class Astronauta extends IDCounter{

    private static int contador = 1;

    private String nome;
    private String habilidade;

    public int getId() {
        return super.getId();
    }

    public String getNome() {
        return nome;
    }

    public String getHabilidade() {
        return habilidade;
    }


    public Astronauta(String nome, String habilidade){
        super(contador++);
        this.nome = nome;
        this.habilidade = habilidade;
    }

    public void exibirAstronauta(){
        System.out.println("ID: " + super.getId() + "Nome: " + nome + "Habilidade: " + habilidade);
    }


}


