import java.util.Scanner;
class maxHeapObject
{
    public final int MAX_SIZE = 100;
    public int[] heap;
    public int heap_length;
    maxHeapObject()
    {
        heap = new int[MAX_SIZE];
        heap_length = 0;
    }
    maxHeapObject(int arr[])
    {
        heap = arr;
        heap_length = heap.length-1;
        for(int i=heap_length/2;i>0;i--)
            heapify(i);
    }
    public void heapify(int index)
    {
        int l1 = 2*index;
        int l2 = (2*index) + 1;
        int largest = index;
        if(l1<=this.heap_length && this.heap[l1]>this.heap[largest])
            largest = l1;
        if(l2<=this.heap_length && this.heap[l2]>this.heap[largest])
            largest = l2;
        if(largest!=index)
        {
            int temp = this.heap[index];
            this.heap[index] = this.heap[largest];
            this.heap[largest] = temp;
            this.heapify(largest);
        }
    }
    public void insertKey(int x)
    {
        if(heap_length==MAX_SIZE-1)
            System.out.println("Overflow");
        else
        {
            heap[++heap_length] = x;
            int parent = heap_length/2,child = heap_length;
            while (parent>0 && heap[parent]<heap[child])
            {
                int temp = heap[parent];
                heap[parent] = heap[child];
                heap[child] = temp;
                child = parent;
                parent/=2;
            }
        }
    }
    public void increaseKey(int i,int new_val)
    {
        if(new_val<=heap[i])
        {
            System.out.println("Value Error");
            return;
        }
        heap[i] = new_val;
        while (i>=2 && (heap[i]>heap[i/2]))
	    {
            int temp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = temp;
		    i/=2;
	    }
    }
    public void decreaseKey(int i,int new_val)
    {
        if (new_val>=heap[i])
	    {
		    System.out.println("Value Error");
		    return;
	    }
	    heap[i] = new_val;
	    heapify(i);
    }
    public void peek()
    {
        if(heap_length!=0)
            System.out.println(heap[1]);
        else
            System.out.println("Underflow");
    }
    public void poll()
    {
        if(heap_length!=0)
        {
            if(heap_length>1)
            {
                int temp = heap[1];
                heap[1] = heap[heap_length];
                heap[heap_length] = temp;
                System.out.println(heap[heap_length--]);
                heapify(1);
            }
            else
                System.out.println(heap[heap_length--]);
        }
        else
            System.out.println("Underflow");
    }
}
public class maxHeap
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //Overloaded constructors to assign arrays or an empty heap
        
        /*int arr[] = {0,2111,4,5,21111,10,12,100};
        maxHeapObject obj = new maxHeapObject(arr);
        obj.increaseKey(2,999999);
        obj.peek();
        maxHeapObject obj = new maxHeapObject();*/
    }
}