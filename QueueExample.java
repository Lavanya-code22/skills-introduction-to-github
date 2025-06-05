//queue operatin
import java.util.LinkedList;
public class QueueExample{
public static void main(String[]args){
	Queue<Integer>q=new LinkedList<>();
//enqueue elements
q.offer(10);
q.offer(20);
q.offer(30);
System.out.println("Queue:"+q);
//peek front element
System.out.println("Front:"+q.peek());
System.out.println("Queue after operations:"+q);
}
}
