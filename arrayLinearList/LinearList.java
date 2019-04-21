package arrayLinearList;

public interface LinearList
{
	public void add(int index, Object element);
	public void checkIndex(int index);
	public boolean isEmpty();
	public int size();
	public void ChangeArrayLength();
	public Object remove(int index);
	
}
