
public interface IList<T> {
	void insertAtHead(T item);
	void insertAt(T item, int index) throws Exception;
	void insertAtTail(T item);
	void deleteHead() throws Exception;
	void deleteAt(int index) throws Exception;
	void deleteTail() throws Exception;
	T getHead() throws Exception;
	T getAt(int index) throws Exception, Exception;
	T getTail() throws Exception;
	int length();
	boolean isEmpty();
}

