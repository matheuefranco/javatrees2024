package javatree2024;

import java.io.*;
import java.util.Scanner;

public class JavaTree2024 {

     private static void carregaArquivo(BinarySearchTree<Aluno> tree, int numRegistros){
     String csvFile = "dados.csv";
        String line = "";
        String[] leitura = null;
        int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null && i<numRegistros) {
                Aluno aluno = new Aluno();
                leitura = line.split(",");
                aluno.setId(Integer.parseInt(leitura[0]));
                aluno.setNome(leitura[1]);
                tree.add(aluno); 
                i++;
            }// fim percurso no arquivo
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    static int menu(){
        Scanner leia = new Scanner(System.in);
        System.out.println("*** Arvore de Busca Binaria ***");
        System.out.println("1-Inserir");
        System.out.println("2-Percursos");
        System.out.println("3-Buscar");
        System.out.println("4-Carregar");
        System.out.println("5-Remover");
        System.out.println("0-Sair");
        int op = leia.nextInt();
        return op;
    }
    
    public static void main(String[] args) {
        BinarySearchTree<Aluno> bst = new BinarySearchTree();
        Scanner leia = new Scanner(System.in);
        int op;
        do{
            op = menu();
            switch(op){
                case 1: Aluno al = new Aluno();
                        System.out.print("ID:");
                        al.setId(leia.nextInt());
                        leia.nextLine();
                        System.out.print("Nome:");
                        al.setNome(leia.nextLine());
                        bst.add(al,true);
                break;
                case 2: System.out.println("Pre ordem");
                        bst.preOrder();
                        System.out.println("Em ordem");
                        bst.inOrder();
                        System.out.println("Pos ordem");
                        bst.postOrder();
                break;
                case 3: System.out.print("ID para buscar:");
                        Aluno alBusca = new Aluno();
                        alBusca.setId(leia.nextInt());
                        alBusca = bst.search(alBusca);
                        if(alBusca==null)
                            System.out.println("Id nao encontrado");
                        else
                            System.out.println("Nome:"+alBusca.getNome());
                        System.out.println("Comparacoes:"+bst.comparacoes);
                break;
                case 4: System.out.println("Qtde de registros para carregar:");
                        int qtdReg = leia.nextInt();
                        carregaArquivo(bst, qtdReg);
                break;
                 case 5: System.out.print("ID para remover:");
                        Aluno alRemover = new Aluno();
                        alRemover.setId(leia.nextInt());
                        bst.remove(alRemover);
                break;
                case 0: System.out.println("Saindo");
                break;
            }// fim switch
            System.out.println("Pressione uma tecla para continuar");
            leia.nextLine();// pausa
        }while(op!=0);

    }// fim main
    
}// fim classe
