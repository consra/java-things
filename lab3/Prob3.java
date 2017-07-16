package lab3;

class MyArray {
    int v[];
    int size;
    
    public MyArray() {
        this(100);
    }
    
    public MyArray(int length) {
        this.size = 0;
        v = new int[length];
    }
    
    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }
    
    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }
    
    public int getSize() {
        return this.size;
    }
}

class MyQueue
{
	MyArray kek;
	int infinite = 9500;
	int first;
	int last;
	int size;
	public MyQueue()
	{
		kek = new MyArray(infinite);
		first = 0;
		last = 0;
		size = kek.size;
	}
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty ()
	{
		return (size == 0);
	}
	
	public void enqueue (int value)
	{
		kek.set(last, value);
		last++;
	}
	public int dequeue ()
	{
		int meh = this.first;
		this.first++;
		return this.kek.get(meh);
	}
	
	public String toString()
	{
		String result = "Elementele din coada sunt: ";
		for (int i = this.first; i < this.last; ++i)
			result = result + this.kek.v[i] + " ";
		return result;
	}
	
}

public class Prob3 {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(-1);
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue);
        queue.enqueue(9);
        queue.enqueue(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(22);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("");
        System.out.println(queue);

	}

}
