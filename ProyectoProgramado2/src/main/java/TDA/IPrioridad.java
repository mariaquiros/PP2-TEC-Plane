package TDA;

public interface IPrioridad <T>{
	
	public void enqueue(Object element,int indice);
	public T dequeue();
	public T First();
}
