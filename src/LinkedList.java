
public class LinkedList<T> implements IList<T> {
	
	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;
	
	
	//constant time
	@Override
	public void insertAtHead(T data)
	{		
		
		Node<T> newNode = new Node<T>(data);
		
		if (isEmpty())
		{
			head = newNode;
			tail = new Node<T>(null);
			tail.setPrev(head);
			tail.setNext(null);
			head.setNext(tail);
			head.setPrev(null);
			size+=2;
		}	
		
		else 
		{
			
			newNode.setPrev(null);
			newNode.setNext(head.getNext());
			newNode.getNext().setPrev(newNode);
			head = newNode;
		}
		
		size++;
	}

	/* Linear time, must traverse the list to access the index
	  in a linkedList */
	@Override
	public void insertAt(T data, int index) throws Exception
	{
		
		if (index < 0)
			throw new Exception();
		
		if (index >= size)
			throw new Exception();
		
		if (index == size - 1)
			insertAtTail(data);
			
		if (index == 0)
			insertAtHead(data);
		
		else 
		{
			Node<T> newNode = new Node<T>(data);
			Node<T> current = head;
	
			for(int i = 0; i < index; i++)
			{
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			newNode.setPrev(current.getPrev());
			newNode.getPrev().setNext(newNode);
			newNode.getNext().setPrev(newNode);
			
			size++;
		}
	}

	//constant time
	@Override
	public void insertAtTail(T data) 
	{
			
		Node<T> newNode = new Node<T>(data);
			
		if (isEmpty())
		{
			tail = newNode;
			head = new Node<T>(null);
			head.setNext(tail);
			head.setPrev(null);
			tail.setPrev(head);
			tail.setNext(null);
			size +=2;
		}	
			
		else 
		{
			newNode.setNext(null);
			newNode.setPrev(tail.getPrev());
			newNode.getPrev().setNext(newNode);
			tail = newNode;
		}
		
		size++;
	}
		
	
    //constant
	@Override
	public void deleteHead()
	{
		
		if (head.equals(null)||head.getData().equals(null))
			System.out.println("There is nothing to delete here.");
		
		else if(head.getNext().equals(tail))
		{
			head.setData(null);
		}
		
		else 
		{
			
			head.setPrev(null);
			if(head.getNext() != null)
				head = head.getNext();
           		size--;
		}
	}
    //linear as above
	@Override
	public void deleteAt(int index) throws Exception 
	{
		if (index < 0)
			throw new Exception();
		
		if (index == 0)
			deleteHead();
		
		if (index > size - 1)
			throw new Exception();
		
		if (index == size - 1)
			deleteTail();
		
		else 
		{
			
			Node<T> current = head.getNext();
	
			for(int i = 1; i < index; i++)
			{
				current = current.getNext();
			}
			current.getPrev().setNext(current.getNext());
			if(current.getNext() != null)
				current.getNext().setPrev(current.getPrev());
			size--;	
		}	
			
	}

	@Override
	public void deleteTail() throws Exception 
	{
		
		if (tail.equals(null)||tail.getData().equals(null))
			System.out.println("There is nothing to delete here.");
		
		else if (tail.getPrev().equals(head))
		{
			tail.setData(null);
		}
		
		else 
		{
			
			tail = tail.getPrev();
            		tail.setNext(null);
           		size--;
		}
	}

	public void deleteAll()
	{
		head=null;
		tail=null;
	}
	
	@Override
	public T getHead() throws Exception
	{
		if (isEmpty())
			throw new Exception();
		return head.getData();
	}

	@Override
	public T getAt(int index) throws Exception
	{
		
		if (index < 0)
			throw new Exception();
		
		if (isEmpty())
			throw new Exception();
		
		if (index >= size)
			throw new Exception();
		
		if (index == size - 1)
			return getTail();
	
		if (index == 0)
			return getHead();
		
		Node<T> currNode = head;
		for (int i = 0; i < index; i++)
			currNode = currNode.getNext();	
		
		return currNode.getData();
	}

	@Override
	public T getTail() throws Exception
	{
		
		if (isEmpty())
			throw new Exception();

		return tail.getData();
	}
    
	@Override
	public int length()
	{
		return size;
		
		
	}

	@Override
	public boolean isEmpty()
	{
		return  (head.equals(null)||head.getData().equals(null)&&head.getNext().equals(null))
				&& (tail.equals(null)||tail.getData().equals(null)&&tail.getPrev().equals(null));
	}		
				
}
	
	
	


