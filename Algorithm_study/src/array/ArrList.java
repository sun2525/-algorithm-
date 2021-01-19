package array;
import java.util.NoSuchElementException;

public class ArrList <E>{ //동적 배열
	private E a[]; //항목을 저장힐 배열
	private int size; //배열에 저장된 항목 수
	public ArrList() {
		a = (E[]) new Object[1];
		size = 0;
	}
	
	public E peek(int k) { //k번째 저장된 항목을 리턴
		if(size == 0 || k>=size)
			throw new NoSuchElementException();
		return a[k];
	}
	
	public boolean isEmpty() {
		if(size == 0) return true;
		return false;
	}
	
	public void insertLast(E newItem) { //가장 뒤에 새 항목 추가
		if (size == a.length)
			resize(2*a.length);
		a[size++] = newItem;
	}
	
	public void insert(E newItem, int k) {//새 항목을 k번째에 추가
		if(size == a.length)
			resize(2*a.length);
		for(int i = size-1; i >=k; i--)
			a[i+1] = a[i];
		a[k] = newItem;
		size++;
	}
	
	public void insert(E newItem) {
		insertLast(newItem);
	}
	
	private void resize(int newSize) {//배열의 크기 조절
		Object[] t =new Object[newSize];
		for(int i = 0;i<size;i++)
			t[i] = a[i];
		a= (E[]) t;
	}
	
	public E delete(int k) {//k번째 항목 삭제
		if(isEmpty())
			throw new NoSuchElementException();
		E item = a[k];
		for(int i = k; i<size; i++)
			a[i] = a[i+1];
		size--;
		if(size > 0&& size <=a.length/4)
			resize(a.length/2);
		return item;
	}
	
	public void print() {//배열을 출력
		for( int i = 0;i<a.length ;i++) {
			if(i<size) 
				System.out.print(a[i]+"\t");
			else 
				System.out.print("null\t");
			 
		}
		System.out.println();
	}
}
