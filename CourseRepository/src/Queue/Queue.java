package Queue;

//Using array we create a circular queue
public class Queue {

        int[] arr;

        //current size
        int cs;

        //max size
        int ms;
        int front;
        int rear;

        Queue(int default_size){
            ms = default_size;
            arr = new int[ms];
            cs = 0;
            front = 0;
            rear = ms - 1;
        }
        boolean full(){
            return cs==ms;
        }
        boolean empty(){
            return cs==0;
        }

        void push(int data){
            if(!full()){
                //take the rear to the next index
                rear = (rear + 1)%ms;
                arr[rear] = data;
                cs++;
            }
        }

        void pop(){
            if(!empty()){
                //take the front pointer forward
                front = (front + 1)%ms;
                cs--;
            }
        }

        int getFront(){
            return arr[front];
        }
}
