public interface RedBlackTreeInterface<T extends Comparable <T>> extends SortedCollectionInterface <T>{

	public T getRightChild(T parentNodeData) throws IllegalArgumentException;
	public T getLeftChild(T parentNodeData) throws IllegalArgumentException;
	public boolean insert(T data) throws NullPointerException, IllegalArgumentException;
    public boolean remove(T data) throws NullPointerException, IllegalArgumentException;
    public boolean contains(T data);
    public int size();
    public boolean isEmpty();
    public T lowest();
    public T highest();
    public T getroot();
    public T find(double key);
}
