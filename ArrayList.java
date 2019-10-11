import java.util.Arrays;

public class ArrayList<T> implements List <T>
{
	protected T [] a;
	protected int size;

	public ArrayList()
	{
		a = (T[]) new Object[10];
		size=0;
	}

	public void add (T item)
	{
		if (size == a.length)
			growArray();
		a[size++] = item;
	}

	public void add (int pos, T item) throws Exception
	{
		if (pos<0 || pos>size)
			throw new Exception();
		if (size == a.length)
			growArray();
		for (int i=size-1; i>=pos; i--)
		{
			a[i]=a[i-1];
		}
		a[pos]=item;
		size++;
	}

	public T get (int pos) throws Exception
	{
		if (pos<0 || pos>=size)
			throw new Exception();
		return a[pos];
	}

	public T remove (int pos) throws Exception
	{
		if (pos<0 || pos>=size)
			throw new Exception();
		T item = a[pos];
		for (int i=pos; i<size-1; i++)
		{
			a[i]=a[i+1];
		}
		size--;
		return item;
	}

	public int size()
	{
		return size;
	}

	private void growArray()
	{
		int len = a.length;
		T [] new_array = (T[]) new Object[len*2];
		new_array = Arrays.copyOf(a, len*2);
		a = new_array;
	}
}