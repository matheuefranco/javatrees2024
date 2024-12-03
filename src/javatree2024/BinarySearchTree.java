
package javatree2024;

import java.util.Scanner;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> raiz;
    public int comparacoes;
    
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
        else
            this.raiz = add(raiz,novoNo);
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
        comparacoes=0;
        return search(this.raiz, dadoBusca);
    }
    private T search(Node<T> raiz, T dadoBusca){
        comparacoes++;
        if(raiz==null)
            return null;
        if(raiz.dado.equals(dadoBusca))
            return raiz.dado;
        if(dadoBusca.compareTo(raiz.dado)<0)
            return search(raiz.esquerda,dadoBusca);
        else
            return search(raiz.direita,dadoBusca);
       
    }
    
     private Node<T> removeNode(Node<T> raiz) {
    	Node<T> nova, pai;
        if(raiz.direita==null){
        	nova = raiz.esquerda;
        	return nova;
    	}
    	// percorrer até achar o menor da direita
    	pai = raiz; nova= raiz.direita;
        while(nova.esquerda!=null){
                    	pai=nova;
                    	nova = nova.esquerda;
        	}// fim while
    	
    	// reorganizar os ponteiros
        	if(pai!=raiz){
                    	pai.esquerda = nova.direita;
                    	nova.direita = raiz.direita;
        	}
                nova.esquerda = raiz.esquerda;
        System.out.println("Retornando nova raiz:"+nova.dado);
        	return nova;}
 
public void remove(T dadoRemover) {
	raiz = remove(this.raiz, dadoRemover);
}
 
private Node<T> remove(Node<T> raiz, T dadoRemover) {
	    	if(raiz==null){
                System.out.println("Não encontrado - :(");
                    	return null;    	}
        	if(raiz.dado.equals(dadoRemover)){
                System.out.println("Encontrado - removendo");
                    	return removeNode(raiz);    	}
        	if(dadoRemover.compareTo(raiz.dado)<0)
                    	raiz.esquerda = remove(raiz.esquerda,dadoRemover);
        	else
        		raiz.direita = remove(raiz.direita,dadoRemover);
        	
    	return raiz;
}// fim buscaRemove


    
}
