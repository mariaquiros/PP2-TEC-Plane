package TDA;

public class ColaPrioridad<T> implements IPrioridad {
	Cola[] ColaP;

	// método para crear un arreglo de colas
	public ColaPrioridad(int Tamaño) {
		ColaP = new Cola[Tamaño];
		int n = 0;
		while (n < Tamaño) {
			ColaP[n] = new Cola();
			n++;

		}

	}

	// método para agregar objetos al arreglo
	public void enqueue(Object element, int indice) {
		ColaP[indice].enqueue(element);
	}

	// Método para eliminar un objeto del arreglo de colas(elimina el primero)
	public T dequeue() {
		for (int i = 0; ColaP.length > i; i++) {
			if (ColaP[i].size() > 0)
				return (T) ColaP[i].dequeue();

		}
		return null;
	}

	// Método que retorna el primer objeto en el arreglo de colas
	public T First() {
		for (int i = 0; ColaP.length > i; i++) {
			if (ColaP[i].size() > 0)
				return (T) ColaP[i].first();

		}
		return null;
	}

}
