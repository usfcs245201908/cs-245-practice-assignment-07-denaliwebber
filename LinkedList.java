public class LinkedList<T> implements List<T>
{
	Node head;
	int size;

	public LinkedList()
	{
		head=null;
		size=0;
	}

	public int size()
	{
		return size;
	}

	public void add(T item)
	{
		if (head==null)
		{
			head = new Node(item);
			size++;
		}

		else
		{
			Node prev = head;
			while (prev.next != null)
				prev=prev.next;
			Node curr = new Node(item);
			prev.next=curr;
			size++;
		}
	}

	public void add(int pos, T item) throws Exception
	{
		if (pos<0 || pos>size)
			throw new Exception();
		if (pos==0)
		{
			Node curr = new Node(item);
			curr.next=head;
			head=curr;
			size++;
		}

		else
		{
			Node current = new Node(item);
			Node prev = head;
			for (int i=0; i<pos-1; i++)
			{
				prev=prev.next;
			}
			current.next=prev.next;
			prev.next=current;
			size++;
		}
	}

	public T remove(int pos) throws Exception
	{
		if (pos<0 || pos>=size)
			throw new Exception();

		if (pos==0)
		{
			T item = (T) head.data;
			head=head.next;
			size--;
			return item;
		}

		else
		{
			Node prev = head;
			for (int i=0; i<pos-1; i++)
			{
				prev=prev.next;
			}
			Node curr = prev.next;
			T item = (T) curr.data;
			prev.next=curr.next;
			size--;
			return item;
		}
	}

	public T get(int pos) throws Exception
	{
		if (pos<0 || pos>=size)
			throw new Exception();
		Node prev = head;
		for (int i=0; i<pos; i++)
		{
			prev=prev.next;
		}
		return (T)prev.data;
	}

	private class Node<T>
	{
		private T data;
		private Node next;

		public Node(T item)
		{
			data = item;
			next = null;
		}

		public void setData(T data)
		{
			this.data = data;
		}

		public void setNext(Node nextNode)
		{
			next = nextNode;
		}

		public T getData()
		{
			return data;
		}

		public Node getNext()
		{
			return next;
		}
	}
}