
package javatree2024;
public class Node<T extends Comparable<T>> {
    T dado;
    Node<T> direita;
    Node<T> esquerda;
    int fb;
    public Node(T novoDado){
        this.dado = novoDado;
        this.esquerda = null;
        this.direita = null;
        this.fb=0;
    }
}
