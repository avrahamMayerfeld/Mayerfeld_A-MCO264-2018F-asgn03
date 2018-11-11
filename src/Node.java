
public class Node<T> {
	private T data;
	private Node<T> nextNode;
	private Node<T> prevNode;  
	
	 
    public Node(T data){
        this.data = data;
        nextNode = null;
        prevNode = null;
    }
    
    public void setData(T data) {
    	this.data = data;
    }
    
    public T getData(){
        return data;
    }
    
    public void setNext(Node<T> node){
        this.nextNode = node;
    }
    
    public Node<T> getNext(){
        return nextNode;
    }
    
    public void setPrev(Node<T> node){
        this.prevNode = node;
    }
    
    public Node<T> getPrev(){
        return prevNode;
    }
    
}
