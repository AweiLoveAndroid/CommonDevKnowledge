
/**
 * 快速排序demo
 * 使用二叉树的原理去解决：
 * 
 * 堆是一颗被完全填满的二叉树，有可能的例外是在底层，底层上的元素从左到右填入。
 这样的树称为完全二叉树。
 * 
 * 堆的性质:
    比如我们想找出最大元，因为最大元在根上，
    而且任意子树也是一个堆，那么任意节点就应该大于它的所有后裔。
 */
public class HeapSort2Demo{

	public static void main(String[] args) {
		int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}

	/** 
	 * 堆排序 
	 *  
	 * @param ts 
	 */  
	public static <T extends Comparable<? super T>> void heapSort(T[] ts) {  
	  
		// 通过下虑，将数组初始化成一个堆。  
		for (int length = ts.length, i = length / 2 - 1; i >= 0; i--)  
			percDown(ts, i, length);  
	  
		// 对具有堆性质的数组排序  
		for (int len = ts.length - 1; len >= 0; len--) {  
			// 将最大元[0]删除，即放到堆尾，堆尾元素放到最大元位置  
			swap(ts, len);  
			// 对最大元位置元素 下虑  
			percDown(ts, 0, len);  
		}  
	}  
	  
	/** 
	 * 下虑 找出最大元
	 * @param ts 
	 * @param index 
	 * @param length 
	 */  
	private static <T extends Comparable<? super T>> void percDown(T[] ts, int i, int length) {  
	  
		T temp = ts[i];// 待调整最大元位置元素  
	  
		for (int child = leftChild(i); child < length; i = child, child = leftChild(i)) {  
	  
			// 判断有右儿子&&右儿子>左儿子  
			if (child + 1 != length && ts[child + 1].compareTo(ts[child]) > 0) {   
				child++;  
			}
			// 最大儿子跟父比较  
			if (temp.compareTo(ts[child]) < 0){  
				ts[i] = ts[child];  
			}
			else { 
				break; 
			}
		}  
	  
		ts[i] = temp;// 放到正确位置  
	}  
	  
	/** 
	 * 堆尾、堆首互换  
	 * @param ts 
	 * @param index 
	 */  
	private static <T extends Comparable<? super T>> void swap(T[] ts, int index) {  
		T temp = ts[index];  
		ts[index] = ts[0];  
		ts[0] = temp;  
	}  
	  
	/** 
	 * 左儿子位置 
	 * @param i 
	 * @return 
	 */  
	private static int leftChild(int i) {  
		return i * 2 + 1;  
	}  

}