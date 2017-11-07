// Varun Ravi
// November 6th, 2017
// BinaryHeap


class Node
{
	int data;
	Node left;
	Node right;
}

public class BinaryHeap
{
	int size;
	int a[];
	//ArrayList<Integer> list;
	
	public BinaryHeap() 
	{
		a = new int[50];
		//list = new ArrayList<Integer>();
		size = 0;
	}
	
	public void add (int num)
	{
		int current;

		size++;
		if(a.length <= size)
			increaseSize();
				
		a[size] = num;	
		current = size;
		
		while (a[current] < a[parent(current)])
		{
			swap(current, parent(current));
			current = parent(current);
		}
		
	}
	
	public int remove()
	{ 
		int priority;
		
		if (size == 1)
		{
			priority = a[size--];
			return priority;
		}
		
		if (size > 1)
		{
			priority = a[1];
			swap(1, size--);
			siftdown(1);
			
			return priority;
		}	
		return 0;
	}
		
	public void swap (int pos, int pos_2)
	{
		int temp = a[pos];
		a[pos] = a[pos_2];
		a[pos_2] = temp;
	}
		
	private void siftdown(int position)
	{
		int child;
		
		if(isleaf(position))
			return;

		child = leftchild(position);
		
		if (rightchild(position) <= size)
			if (a[rightchild(position)] < a[child])
				child = rightchild(position);
		
		if (a[child] < a[position])
		{
			swap(child, position);
			siftdown(child);
		}
	
	}
	
	public int leftchild (int pos)
	{
		return 2 * pos;
	}
				
	public int rightchild (int pos)
	{
		return 2 * pos + 1;
	}
	
	
	public int parent (int pos)
	{
		return pos/2;
	}
	
	private boolean isleaf(int pos)
	{
		return ((pos > size/2) && (pos <= size));
	}
	
	public void increaseSize() 
	{
		   int[] temp = new int [a.length *2];
		   
		   for (int i = 0; i < a.length; i++)
		      temp[i] = a[i];

		   a = temp;
		   
	}
	
}