
package javatree2024;

import java.util.Scanner;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> raiz;
    public BinarySearchTree(){
        this.raiz=null;
    }
    
    public void add(T novoDado){
        Node novoNo = new Node(novoDado);
        this.raiz = add(raiz, novoNo); 
    }
    
    public void add(T novoDado, boolean verbose){
        Node novoNo = new Node(novoDado);
        if(verbose==true)
            this.raiz = add(raiz, novoNo, verbose); 
    }
    
    private Node<T> add(Node<T> raiz, Node<T> novoNo){
        if(raiz == null)
            return novoNo;
        else 
            if(novoNo.dado.compareTo(raiz.dado)<0)
                raiz.esquerda = add(raiz.esquerda,novoNo);
        else
                raiz.direita = add(raiz.direita,novoNo);
        
        return raiz;
    }// fim add
    
    private Node<T> add(Node<T> raiz, Node<T> novoNo, boolean verbose){
        Scanner leia = new Scanner(System.in);
        if(raiz == null){
            System.out.println("Dado inserido:"+novoNo.dado);
            leia.nextLine();// pausa
            return novoNo;
        }
        else 
            if(novoNo.dado.compareTo(raiz.dado)<0){
                System.out.println("Esquerda");
                leia.nextLine();// pausa
                raiz.esquerda = add(raiz.esquerda,novoNo,true);
            }
            else{
                System.out.println("Direita");
                 leia.nextLine();
                raiz.direita = add(raiz.direita,novoNo,true);
             }
        
        return raiz;
    }// fim add
    
    
    public void preOrder(){
        preOrder(this.raiz);
    }
    private void preOrder(Node<T> raiz){
        if(raiz!=null){
            System.out.println(raiz.dado +"|");
            preOrder(raiz.esquerda);
            preOrder(raiz.direita);
        }// fim if 
    }// fim preOrder
    public void inOrder(){
        inOrder(this.raiz);
    }
    private void inOrder(Node<T> raiz){
        if(raiz!=null){
            inOrder(raiz.esquerda);
            System.out.println(raiz.dado +"|");
            inOrder(raiz.direita);
        }// fim if 
    }// fim inOrder
    public void postOrder(){
        inOrder(this.raiz);
    }
    private void postOrder(Node<T> raiz){
        if(raiz!=null){
            postOrder(raiz.esquerda);
            postOrder(raiz.direita);
            System.out.println(raiz.dado +"|");
        }// fim if 
    }// fim inOrder
    
}
