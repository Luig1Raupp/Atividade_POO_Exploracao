package POOExploracao.teste;

public class Missao extends IDCounter {
    private static int contador = 1;

    private Nave nave;
    private Astronauta astronauta;
    private String nome;
    private String objetivo;
    private String dataLancamento;
    private String status;

    public int getId() {
        return super.getId();
    }

    public Nave getNave() {
        return nave;
    }

    public Astronauta getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Missao (String nome, String objetivo, String dataLancamento, String status){
        super(contador++);
        this.nome = nome;
        this.objetivo = objetivo;
        this.dataLancamento = dataLancamento;
        this.status = status;
    }


}
