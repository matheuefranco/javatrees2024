
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
                raiz.esquerda = add(raiz.esquerda,novoNo,verbose);
            }
            else{
                System.out.println("Direita");
                 leia.nextLine();
                raiz.direita = add(raiz.direita,novoNo,verbose);
             }
        
        return raiz;
    }// fim add
    
    
    public void preOrder(){
        preOrder(this.raiz);
    }
    private void preOrder(Node<T> raiz){
        if(raiz!=null){
            System.out.print(raiz.dado +"|");
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
            System.out.print(raiz.dado +"|");
            inOrder(raiz.direita);
        }// fim if 
    }// fim preOrder
   
    
    public void postOrder(){
        postOrder(this.raiz);
    }
    private void postOrder(Node<T> raiz){
        if(raiz!=null){
            postOrder(raiz.esquerda);
            postOrder(raiz.direita);
            System.out.print(raiz.dado +"|");
        }// fim if 
    }// fim inOrder
    
    // busca
    public T search(T dadoBusca){
        return search(this.raiz, dadoBusca);
    }
    private T search(Node<T> raiz, T dadoBusca){
        if(raiz==null)
            return null;
        if(raiz.dado.equals(dadoBusca))
            return raiz.dado;
        if(dadoBusca.compareTo(raiz.dado)<0)
            return search(raiz.esquerda,dadoBusca);
        else
            return search(raiz.direita,dadoBusca);
       
    }
    
}
