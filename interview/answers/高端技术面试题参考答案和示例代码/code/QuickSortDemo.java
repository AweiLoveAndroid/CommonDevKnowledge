
/**
 * 快速排序demo
 */
public class QuickSortDemo{

	//main方法中将数组传入排序方法中处理,之后打印新的数组
	public static void main(String[] stra){
	　　int[] a={7,10,3,5,4,6,2,8,1,9};
		quickSort(a,1,10);
	　　for (int i=0;i<a.length;i++) {
	　　	System.out.println(a[i]);
		}
	}

	public static void quickSort(int[] a,int p,int r){
	　　if(p<r){
	　　　　int q=Partition(a,p,r);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);
	　　}
	} 

	public static int Partition(int[] a,int p,int r){
	　　int x=a[r-1];
	　　int i=p-1;
	　　int temp;
	　　for(int j=p;j<=r-1;j++){
	　　　　if(a[j-1]<=x){
	　　　　　　// 交换(a[j-1],a[i-1]);
	　　　　　　i++;
	　　　　　　temp=a[j-1];
	　　　　　　a[j-1]=a[i-1];
	　　　　　　a[i-1]=temp;
	　　　　}
	　　}
	　　//交换(a[r-1,a[i+1-1]);
	　　temp=a[r-1];
	　　a[r-1]=a[i+1-1];
	　　a[i+1-1]=temp;
	　　return i+1;
	}

}