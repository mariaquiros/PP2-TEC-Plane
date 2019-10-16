package TDA;

public class ColaPrioridad <T>{
    LQueue[] ColaP; 
    //m�todo para crear un arreglo de colas
    public ColaPrioridad(int Tama�o){
        ColaP= new LQueue[Tama�o];
        int n=0;
        while(n<Tama�o){
          ColaP[n]=new LQueue();
          n++;
            
        }
    
    }
        //m�todo para agregar objetos al arreglo
        public void enqueue(T element,int indice){
        ColaP[indice].enqueue(element);
        }
        
        //M�todo para eliminar un objeto del arreglo de colas(elimina el primero)
        public T dequeue(){
            for (int i=0;ColaP.length>i;i++){
                if(ColaP[i].size()>0)return (T) ColaP[i].dequeue();
                
            }
            return null;
        }
        //M�todo que retorna el primer objeto en el arreglo de colas
        public T First(){
            for (int i=0;ColaP.length>i;i++){
                if(ColaP[i].size()>0)return (T) ColaP[i].first();
                
            }
            return null;
        }
        public static void main(String args[]) {
            ColaPrioridad Nueva=new ColaPrioridad(4);
            Nueva.enqueue("JOELBT", 3);
            Nueva.enqueue("ANA", 2);
            Nueva.enqueue("MANUEL", 3);
            Nueva.enqueue("JOSE", 1);
            Nueva.enqueue("PEPE", 1);
            Nueva.enqueue("JOEL", 3);
            Nueva.enqueue("CARLOS", 2);
            Nueva.enqueue("LUIS", 1);
            
            System.out.println(Nueva.First());
            while(Nueva.First()!=null){
                String Nueva2=(String) Nueva.dequeue();
                System.out.println("\n"+Nueva2);
            }
        }

}
