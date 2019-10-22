package TDA;
import java.io.Serializable;



public class Cola<T> implements Serializable {
	
	private class Node<T> implements Serializable{
		
	    private T element;
	    private Node<T> next;
	   /**
	    * Metodo constructor del nodo con atrubitos nulos
	    */
	    public Node() {
	        this.element = null;
	        this.next = null;
	    }
	    /**
	     * Metodo constructor de nodo que recibe el atributo element
	     * @param element
	     */
	    public Node(T element) {
	        this.element = element;
	        this.next = null;
	    }
	    /**
	     * Metodo constructor de nodo que recibe los dos atributos
	     * @param element
	     * @param next
	     */
	    public Node(T element, Node<T> next) {
	        this.element = element;
	        this.next = next;
	    }
	   /**
	    * Metodo que obtine el element
	    * @return element
	    */
	    public T getElement() {
	        return this.element;
	    }
	    /**
	     * Metodo que cambia el element
	     * @param element
	     */
	    public void setElement(T element) {
	        this.element = element;
	    }
	    /**
	     * Metodo que obtiene  next
	     * @return next
	     */
	    public Node<T> getNext() {
	        return this.next;
	    }
	    /**
	     * metodo que cambia el next
	     * @param next
	     */
	    public void setNext(Node<T> next) {
	        this.next = next;
	    }
	}
	//Atributos de la cola
	private Node<T> front;
	private Node<T> rear;
	private int size;
	/**
	 * Metodo construsctor de la cola
	 */
	public Cola() {
		this.front = new Node<T>();
		this.rear = this.front;
		this.size = 0;
	}
	/**
	 * Metodo que inserta en la cola un elemento
	 * @param element
	 */
	public void enqueue(T element) {
		this.rear.setNext(new Node<T>(element, null));
		this.rear = rear.getNext();
		this.size++;
	}
	/**
	 * Metodo que saca de la cola un elemento
	 * @return temp
	 */
	public T dequeue() {
		if(this.size == 0) {
			System.out.println("Pila Vacia");
			return null;
		}
		T temp = this.front.getNext().getElement();
		Node<T> nTemp = this.front.getNext();
		this.front.setNext(nTemp.getNext());
		if (this.rear == nTemp) {
			this.rear = this.front;
		}
		this.size--;
		return temp;
	}
	/**
	 * Metodo que devuelve el primer elemento de la cola
	 * @return element
	 */
	public T first() {
		if(this.size == 0) {
			System.out.println("Pila Vacia");
			return null;
		}
		return this.front.getNext().getElement();
	}
	/**
	 * Metodo que obtiene el tama�o de cola
	 * @return size
	 */
	public int size() {
		return this.size;
	}
}