package POOExploracao.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorExploracaoEspacial {

    public List<Astronauta> astronautas = new ArrayList<>();
    public List<Nave> naves = new ArrayList<>();
    public List<Missao> missoes = new ArrayList<>();


    public void sistem() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        Missao missaoteste = new Missao("Lua", "Rua", "2020-20-20", "Falha");
        missoes.add(missaoteste);
        Nave naveteste = new Nave("Flamengo", "Eletrica", 2);
        naves.add(naveteste);
        Astronauta astronautateste = new Astronauta("Luis", "Racha");
        astronautas.add(astronautateste);


        do {
            System.out.println("\n--- Sistema de Gerenciamento de Exploração Espacial ---");
            System.out.println("1. Adicionar Missão");
            System.out.println("2. Adicionar Nave Espacial");
            System.out.println("3. Adicionar Astronauta");
            System.out.println("4. Listar Missões");
            System.out.println("5. Listar Naves");
            System.out.println("6. Listar Astronautas");
            System.out.println("7. Associar Nave a Missão");
            System.out.println("8. Associar Astronauta a Missão");
            System.out.println("9. Atualizar Status da Missão");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome da Missão: ");
                    String nomeMissao = scanner.nextLine();
                    System.out.print("Objetivo da Missão: ");
                    String objetivoMissao = scanner.nextLine();
                    System.out.print("Data de Lançamento (AAAA-MM-DD): ");
                    String dataLancamento = scanner.nextLine();
                    System.out.print("Status (Planejada, Em Andamento, Concluída, Cancelada): ");
                    String statusMissao = scanner.nextLine();
                    Missao missao = new Missao(nomeMissao, objetivoMissao, dataLancamento, statusMissao);
                    missoes.add(missao);
                    break;
                case 2:
                    System.out.print("Nome da Nave: ");
                    String nomeNave = scanner.nextLine();
                    System.out.print("Tipo da Nave: ");
                    String tipoNave = scanner.nextLine();
                    System.out.print("Capacidade da Nave: ");
                    int capacidadeNave = scanner.nextInt();
                    Nave nave = new Nave(nomeNave, tipoNave, capacidadeNave);
                    naves.add(nave);
                    break;
                case 3:
                    System.out.print("Nome do Astronauta: ");
                    String nomeAstronauta = scanner.nextLine();
                    System.out.print("Especialidade do Astronauta: ");
                    String especialidadeAstronauta = scanner.nextLine();
                    Astronauta astronauta = new Astronauta(nomeAstronauta, especialidadeAstronauta);
                    astronautas.add(astronauta);
                    break;
                case 4:
                    listarMissoes();
                    break;
                case 5:
                    listarNaves();
                    break;
                case 6:
                    listarAstronautas();
                    break;
                case 7:
                    System.out.print("ID da Missão para associar nave: ");
                    int idMissao = scanner.nextInt();
                    System.out.print("ID da Nave para associar: ");
                    int idNave = scanner.nextInt();
                    associarNaveAMissao(idMissao, idNave);
                    break;
                case 8:
                    System.out.print("ID da Missão para associar astronauta: ");
                    int idMissaoAssocAstronauta = scanner.nextInt();
                    System.out.print("ID do Astronauta para associar: ");
                    int idAstronautaAssoc = scanner.nextInt();
                    associarAstronautaAMissao(idMissaoAssocAstronauta, idAstronautaAssoc);
                    break;
                case 9:
                    System.out.print("ID da Missão para atualizar status: ");
                    int idMissaoAtualizar = scanner.nextInt();
                    atualizarStatusMissao(idMissaoAtualizar);
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void listarAstronautas() {
        System.out.println("\n--- Lista de Astronautas ---");
        if (astronautas.isEmpty()) {
            System.out.println("Nenhum astronauta cadastrado.");
            return;
        }
        for (Astronauta astronauta: astronautas) {
            System.out.println("ID: " + astronauta.getId() + " | Nome: " + astronauta.getNome() + " | Especialidade: " + astronauta.getHabilidade());
        }
    }

    public void listarMissoes() {
        System.out.println("\n--- Lista de Missões ---");
        if (missoes.isEmpty()) {
            System.out.println("Nenhuma missão cadastrada.");
            return;
        }
        for (Missao missao: missoes) {
            String nomeNave = null;
            String nomeAstronauta = null;

            if (missao.getNave() != null){
                nomeNave = missao.getNave().getNome();
            }

            if (missao.getAstronauta() != null){
                nomeAstronauta = missao.getAstronauta().getNome();
            }

            System.out.println("ID: " + missao.getId() + " | Nome: " + missao.getNome() + " | Status: " + missao.getStatus() +
                    " | Nave: " + nomeNave + " | Astronautas: " + nomeAstronauta );
        }
    }

    public void listarNaves() {
        System.out.println("\n--- Lista de Naves Espaciais ---");
        if (naves.isEmpty()) {
            System.out.println("Nenhuma nave cadastrada.");
            return;
        }
        for (Nave nave: naves) {
            System.out.println("ID: " + nave.getId() + " | Nome: " + nave.getNome() + " | Tipo: " + nave.getTipo() + " | Cap: " + nave.getCapacidade());
        }
    }

    public void associarNaveAMissao(int idMissao, int idNave) {

        Nave naveEncontrada = null;

        for (Nave nave: naves) { //String[] -> Nve
            if (nave.getId() == idNave) { // [0] -> nave.id
                naveEncontrada = nave;
                break;
            }
        }

        for (Missao missao : missoes) {
            if (missao.getId() == idMissao && naveEncontrada != null) {
                    missao.setNave(naveEncontrada);
                    System.out.println("Nave " + naveEncontrada.getNome() + " associada à missão ID " + missao.getId());
                    return;
            }
            System.out.println("Missão ou Nave não encontrada.");
        }

    }

    public void atualizarStatusMissao(int idMissao) {
        Scanner scanner = new Scanner(System.in);

        for (Missao missao : missoes) {
            System.out.print("Novo Status (Planejada, Em Andamento, Concluída, Cancelada): ");
            String novoStatus = scanner.next();
            if (missao.getId() == idMissao && novoStatus != null) {
                missao.setStatus(novoStatus);
                System.out.println("Status atualizado com sucesso!");
                return;
            }

            System.out.println("Missão não encontrada.");
        }
    }

    public void associarAstronautaAMissao(int idMissao, int idAstronauta) {
        Astronauta astronautaEncontrado = null;

        for (Astronauta astronauta : astronautas) {
            if (astronauta.getId() == idAstronauta) {
                astronautaEncontrado = astronauta;
               break;
           }
       }

       for (Missao missao : missoes) {
           if (missao.getId() == idMissao && astronautaEncontrado != null) {
            missao.setAstronauta(astronautaEncontrado);
            System.out.println("Astronauta " + astronautaEncontrado.getNome() + " associado à missão ID " + missao.getId());
            break;
           }
       }

    }


}
 