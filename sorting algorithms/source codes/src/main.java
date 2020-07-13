import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {

	static long averageInsertion = 0;
	static long averageMerge = 0;
	static long averageHeap = 0;
	static long averageFirst = 0;
	static long averageThree = 0;
	static long averageMedian = 0;

	public static void main(String[] args) throws IOException {
		String fileName = "sorted10";
		String lastStr = "";

		String fName = "reversed10";
		String filename = "average10";
		int arrayAmount = 1;
		int size = 0;


		for (int inp = 0; inp < 12; inp++) {
			if (inp == 0) {
				System.out.println("------------------------------Sorted Cases----------------------\n");
				lastStr = fileName + ".txt";
				size = 10;
			} else if (inp <= 3 && inp != 0) {
				fileName += 0;
				lastStr = fileName + ".txt";
				size *= 10;
			} else if (inp == 4) {
				System.out.println("\n----------------------------------Sorted in Reversed Order Cases-------------------\n");
				fileName = fName;
				lastStr = fileName + ".txt";
				size = 10;
			} else if (inp > 4 && inp < 8) {
				fileName += 0;
				lastStr = fileName + ".txt";
				size *= 10;
			} else if (inp == 8) {
				System.out.println("\n----------------------------------------------Average Cases------------------\n");
				fileName = filename;
				lastStr = fileName + ".txt";
				size = 10;
				arrayAmount = 50;
			} else if (inp > 8) {
				fileName += 0;
				lastStr = fileName + ".txt";
				size *= 10;
				arrayAmount = 50;
			}
            
	
			File file = new File("testCases/" + lastStr);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			List<int[]> list = new ArrayList<int[]>();

			String line = "";
			int arr[] = null;
			int index = 0;
			while ((line = br.readLine()) != null) {
				String[] numbers = line.split(" ");
				arr = new int[size];
				for (String number : numbers) {
					int num = Integer.parseInt(number);
					arr[index] = num;
					index++;
				}
				index = 0;
				list.add(arr);
				arr = null;
			}

			br.close();
			int mPosition;

			// Reset average timers
			averageInsertion = 0;
			averageMerge = 0;
			averageHeap = 0;
			averageFirst = 0;
			averageThree = 0;
			averageMedian = 0;

			for (int j = 0; j < arrayAmount; j++) {
				arr = list.get(j);
				mPosition = (int) Math.ceil(arr.length / 2);
				// Insertion Sort
				averageInsertion += insertion(arr, mPosition);

				// Merge Sort
				averageMerge += merge(arr, mPosition);

				// Max Heap
				averageHeap += heap(arr, mPosition);

				// Quick Select Pivot First
				averageFirst += quickFirst(arr, mPosition);

				// Quick Select Median of Three
				averageThree += quickThree(arr, mPosition);

				// Quick Select Median of Medians
				averageMedian += quickMedian(arr, mPosition);
			}

			averageInsertion /= arrayAmount;
			averageMerge /= arrayAmount;
			averageHeap /= arrayAmount;
			averageFirst /= arrayAmount;
			averageThree /= arrayAmount;
			averageMedian /= arrayAmount;

			
			System.out.println(fileName + "- Insertion sort:	" + averageInsertion);
			System.out.println(fileName + "- Merge sort:		" + averageMerge);
			System.out.println(fileName + "- Max Heap:		" + averageHeap);
			System.out.println(fileName + "- Pivot First:		" + averageFirst);
			System.out.println(fileName + "- Median of Three:		" + averageThree);
			System.out.println(fileName + "- Median of Median:		" + averageMedian);
			

		}
	}


	double median(int arr[]) {
		double median = 0;
		if (arr.length % 2 == 1) {
			median = arr[arr.length / 2];
		}
		if (arr.length % 2 == 0) {
			int x = arr[arr.length / 2];
			int y = arr[(arr.length / 2) - 1];
			median = (double) (x + y) / 2;
		}
		return median;
	}

	public static long insertion(int[] arr, int mPosition) {
		insertionSort is = new insertionSort();
			int array2[] = is.insertionsort(arr);
		return is.getCounter();
	}

	public static long merge(int[] arr, int mPosition) {
		mergeSort ms = new mergeSort();
		int msArr[] = ms.sort(arr, 0, arr.length - 1);
		long longCtr = ms.getCounter();
		return longCtr;
	}

	public static long heap(int[] arr, int mPosition) {
		maxHeap mh = new maxHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			mh.insert(arr[i]);
		}
		int rCount = (int) Math.floor(arr.length / 2);
		for (int k = 0; k < rCount; k++) {
			mh.extractMax();
		}
		int median = mh.extractMax();
		return mh.getCounter();
	}

	public static long quickFirst(int[] arr, int mPosition) {
		quickSelectPivotFirst qsPF = new quickSelectPivotFirst();
		int[] array = arr.clone();
		int median = qsPF.kthSmallest(array, 0, array.length - 1, mPosition + 1);
		return qsPF.getCounter();
	}

	public static long quickThree(int[] arr, int mPosition) {
		int[] array2 = arr.clone();
		quickSelectMOT MOT = new quickSelectMOT();
		int median = MOT.kthSmallest(array2, 0, array2.length - 1, mPosition + 1);
		long Motctr = MOT.getCounter();
		return Motctr;
	}

	public static long quickMedian(int[] arr, int mPosition) {
		medianOfmedians MoMedians = new medianOfmedians();
		int medianOfmedians = MoMedians.LS(arr, (arr.length / 2) + 1);
		return MoMedians.getCounter();
	}

}