package javatree2024;

import java.util.Scanner;

public class JavaTree2024 {

    static int menu(){
        Scanner leia = new Scanner(System.in);
        System.out.println("*** Arvore de Busca Binaria ***");
        System.out.println("1-Inserir");
        System.out.println("2-Pre Ordem");
        System.out.println("0-Sair");
        int op = leia.nextInt();
        return op;
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner leia = new Scanner(System.in);
        int op;
        do{
            op = menu();
            switch(op){
                case 1: System.out.println("Valor:");
                        Integer key = leia.nextInt();
                        bst.add(key,true);
                break;
                case 2: System.out.println("Pre ordem");
                        bst.preOrder();
                break;
                case 0: System.out.println("Saindo");
                break;
            }// fim switch
            System.out.println("Pressione uma tecla para continuar");
            leia.nextLine();// pausa
        }while(op!=0);

    }// fim main
    
}// fim classe
