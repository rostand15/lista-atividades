import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Projeto {
    public static void main(String[]args) {

            ArrayList<Atividade> atividades = new ArrayList<Atividade>();
            Scanner sc = new Scanner(System.in);

            while (true){
                System.out.println("-".repeat(5)+"MENU DO SISTEMA"+"-".repeat(5));
                System.out.println("1)Adicionar atividade " +
                        "\n2)Listar Atividades " +
                        "\n3)Excluir Atividade pelo Título " +
                        "\n4)Pesquisar Atividade por Título " +
                        "\n5)Atualizar Atividade pelo Título " +
                        "\n6)Iniciar Atividade " +
                        "\n7)Finalizar Atividade " +
                        "\n8)Listar por status" +
                        "\n9)Listar por usuário" +
                        "\n10)Sair do Sistema " +
                        "\nEscolha a opção desejada:");
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1: {
                        System.out.println("Digite o nome da nova atividade: ");
                        String titulo = sc.nextLine();
                        System.out.print("Digite a descrição da nova atividade: ");
                        String descricao = sc.nextLine();
                        System.out.print("Digite o usuário para a nova atividade: ");
                        String usuario = sc.nextLine();
                        System.out.print("A atividade tem prazo? (s/n): ");
                        String temPrazo = sc.nextLine();

                        if (temPrazo.equalsIgnoreCase("s")) {
                            System.out.print("Digite o prazo (AAAA-MM-DD): ");
                            String dataStr = sc.nextLine();

                            try {
                                LocalDate prazo = LocalDate.parse(dataStr);
                                atividades.add(new AtividadePrazo(titulo, descricao, usuario, prazo));
                            } catch (Exception e) {
                                System.out.println("Data inválida! Atividade será criada sem prazo.");
                                atividades.add(new AtividadeComum(titulo, descricao, usuario));
                            }
                        } else {
                            atividades.add(new AtividadeComum(titulo, descricao, usuario));
                        }
                        System.out.println("Atividade cadastrada com sucesso!");

                        break;
                    }

                    case 2: {
                        if(atividades.isEmpty()){
                            System.out.println("Sua lista está vazia");}
                        else {
                            System.out.println("LISTA DE ATIVIDADES");
                            for (int i = 0; i < atividades.size(); i++) {
                                System.out.println((i+1) + "-" + atividades.get(i));}
                        }
                    break;
                    }

                    case 3: {
                        System.out.println("Digite a atividade que deseja remover: ");
                        String excluir = sc.nextLine();
                        boolean removida = false;

                        for (int i = 0; i < atividades.size(); i++) {
                            Atividade a = atividades.get(i);
                            if (a.getTitulo().equals(excluir)) {
                                atividades.remove(i);
                                removida = true;
                                break;
                            }
                        }
                        if (removida) {
                            System.out.println("Atividade removida.");}
                        else {
                            System.out.println("Atividade não encontrada.");
                        }


                    break;
                    }
                    case 4: {
                        System.out.print("Digite o título para buscar: ");
                        String buscar = sc.nextLine();
                        boolean encontrada = false;
                        for (Atividade a : atividades) {
                            if (a.getTitulo().equals(buscar)) {
                                System.out.println("Encontrada: " + a);
                                System.out.println("Descrição: " + a.getDescricao());
                                encontrada = true;
                                break;
                            }
                        }
                        if (!encontrada ) {
                            System.out.println("Atividade não encontrada.");
                        }
                        break;

                    }
                    case 5: {
                        System.out.print("Digite o título da atividade a atualizar: ");
                        String atual = sc.nextLine();
                        Atividade atividadeAtualizar = null;
                        for (Atividade a : atividades) {
                            if (a.getTitulo().equals(atual)) {
                                atividadeAtualizar = a;
                                break;
                            }
                        }
                        if (atividadeAtualizar != null) {
                            System.out.print("Digite o novo título: ");
                            String novoTitulo = sc.nextLine();
                            System.out.print("Digite a nova descrição: ");
                            String novaDescricao = sc.nextLine();
                            System.out.print("Digite o novo usuário: ");
                            String novoUsuario = sc.nextLine();

                            atividadeAtualizar.atualizarDescricao(novaDescricao);
                            atividadeAtualizar.atualizarTitulo(novoTitulo);
                            atividadeAtualizar.atualizarUsuario(novoUsuario);
                            System.out.println("Atividade atualizada!");
                        } else {
                            System.out.println("Atividade não encontrada.");
                        }
                        break;
                    }

                    case 6: {
                        System.out.print("Digite o título da atividade para iniciar: ");
                        String tituloIniciar = sc.nextLine();

                        boolean encontrada = false;
                        for (Atividade atividade : atividades) {
                            if (atividade.getTitulo().equals(tituloIniciar)) {
                                atividade.iniciar();
                                System.out.println("Atividade iniciada.");
                                encontrada = true;
                                break;
                            }
                        }

                        if (!encontrada) {
                            System.out.println("Atividade não encontrada.");
                        }
                        break;
                    }

                    case 7: {
                        System.out.print("Digite o título da atividade para finalizar: ");
                        String tituloFinalizar = sc.nextLine();

                        boolean encontrada = false;
                        for (Atividade atividade : atividades) {
                            if (atividade.getTitulo().equals(tituloFinalizar)) {
                                atividade.finalizar();
                                System.out.println(atividade.verificar());
                                System.out.println("Atividade finalizada.");
                                encontrada = true;
                                break;
                            }
                        }

                        if (!encontrada) {
                            System.out.println("Atividade não encontrada.");
                        }
                        break;
                    }
                    case 8: {
                        System.out.print("Digite o status para listar (Pendente, Em andamento, finalizada): ");
                        String statusBuscado = sc.nextLine();

                        boolean encontrou = false;
                        for (Atividade atividade : atividades) {
                            if (atividade.getStatus().equalsIgnoreCase(statusBuscado)) {
                                System.out.println(atividade);
                                encontrou = true;
                            }
                        }

                        if (!encontrou) {
                            System.out.println("Nenhuma atividade encontrada com o status informado.");
                        }

                        break;
                    }
                    case 9: {
                        System.out.println("Digite o nome do usuário para listar todas as suas atividades.");
                        String usuarioBuscado = sc.nextLine();

                        boolean encontrou = false;
                        for (Atividade atividade : atividades) {
                            if (atividade.getUsuario().equalsIgnoreCase(usuarioBuscado)){
                                System.out.println(atividade);
                                encontrou = true;
                            }
                        }
                        if (!encontrou){
                            System.out.println("Nenhuma atividade encontrada para o usuário informado.");
                        }
                        break;

                    }

                    case 10: {
                        System.out.println("Saindo do sistema...");
                        sc.close();
                        return;
                    }

                    default: {
                        System.out.println("Opção inválida!");
                        break;
                    }
                }
            }
    }
}
