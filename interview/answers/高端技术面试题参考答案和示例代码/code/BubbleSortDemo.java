
/**
 * 冒泡排序demo
 */
public class BubbleSortDemo{

	/**
	 * 冒泡排序方式1
	 */
	public void bubbleSort(int[] score){
		for(int i =0;i < score.length - 1;i++) {
			for(int j = 0;j <  score.length - 1-i;j++) {  // j开始等于0
				if(score[j] < score[j+1]) {
					int temp = score[j];  
					score[j] = score[j+1];  
					score[j+1] = temp;  
				}
			}
		}
	}

	/**
	 * 冒泡排序方式2
	 * 倒着遍历
	 */
	public void bubbleSort2(int[] score){
		for(int i =0;i < score.length - 1;i++){
			for(int j = (score.length - 2);j >= 0;j--){
				if(score[j] < score[j+1]){
					int temp = score[j];
					score[j] = score[j+1];
					score[j+1] = temp;
				}
			}
		}
	}  
}