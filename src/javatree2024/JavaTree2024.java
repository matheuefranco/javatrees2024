package javatree2024;

import java.util.Scanner;

public class JavaTree2024 {

    static int menu(){
        Scanner leia = new Scanner(System.in);
        System.out.println("*** Arvore de Busca Binaria ***");
        System.out.println("1-Inserir");
        System.out.println("2-Percursos");
        System.out.println("3-Buscar");
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
                break;
                case 0: System.out.println("Saindo");
                break;
            }// fim switch
            System.out.println("Pressione uma tecla para continuar");
            leia.nextLine();// pausa
        }while(op!=0);

    }// fim main
    
}// fim classe
