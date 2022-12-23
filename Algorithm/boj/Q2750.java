package boj;

import java.util.Scanner;

public class Q2750 {
    public static void main(String[] args) {


        BubbleSort bubbleSort = new BubbleSort();
        InsertSort insertSort = new InsertSort();
        MergeSort mergeSort = new MergeSort();
        PrintArr printArr = new PrintArr();


        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
       int[] sortNum = new int[size];
        for (int i = 0; i < size; i++) {
            sortNum[i] = sc.nextInt();
        }
       // bubbleSort.bubbleSort(sortNum);
       // insertSort.insertSort(sortNum);
        printArr.printArray(sortNum);
        mergeSort.sort(sortNum,0,sortNum.length-1);
        printArr.printArray(sortNum);

    }
}


class BubbleSort {
    public void bubbleSort(int[] arr) {
        int arlen = arr.length;
        for (int i = 0; i < arlen - 1; i++) {
            for (int j = 0; j < (arlen - i) - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }

        }
    }
}

class SelectionSort{
    public void selectionSort(int[] arr){
        int arlen = arr.length;
        for(int i=0; i<arlen; i++ ){
            int minIdx = i;
            for(int j=i+1; j<arlen; j++){
                if(arr[j]<arr[minIdx]){
                    minIdx = j;
                }
                if(minIdx != j){
                    int temp = arr[j];
                    arr[j] = arr[minIdx];
                    arr[minIdx] = temp;
                }

            }
        }
    }
}

class InsertSort{
    public void insertSort(int[] arr){
        int arlen = arr.length;
        for(int i=1; i<arlen; i++){
            int temp = arr[i];
            int j=i-1;
            System.out.println("arr[i] :"+arr[i]+" i :"+i);
            while( j >= 0 && arr[j] > temp){
                System.out.println("before arr[j] : "+arr[j]+" arr[j+1]: "+arr[j+1] +" j: "+j );
                arr[j+1] = arr[j];
                System.out.println("after arr[j] : "+arr[j]+ " arr[j+1] : "+arr[j+1]+" j: "+j);
                j--;
             //  System.out.println("after arr[j] : "+arr[j]+" j: "+j);
            }
            arr[j+1]=temp;
         System.out.println("final arr[j] : "+arr[j]+ " arr[j+1] : "+arr[j+1]+" j: "+j);
        }

        }
    }


/*
          for(int j = i-1; j>=0; j--){
              if(arr[j] > temp){
                  temp = arr[j];
                  arr[j] = arr[j+1];
                  arr[j+1] = temp;
                  System.out.println("test");
              }
            }
 */

class MergeSort{
    public void mergeSort(int[] arr,int l, int m, int r){

        int n1 = m-l +1;
        int n2 = r -m;
       // System.out.println("n1: "+n1+"n2: "+n2);

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i<n1; ++i){
            L[i] = arr[l+i];
          //  System.out.println("L[i]: "+ L[i]);
        }
        for(int j=0; j<n2; ++j){
            R[j] = arr[m+1+j];
           // System.out.println("R[j]: "+R[j]);
        }

        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                i++;
                System.out.println("111 n1: "+n1+" n2: "+n2+" i: "+i);
            }
            else{
                arr[k] = R[j];
                j++;
               // System.out.println("222 n1: "+n1+" n2: "+n2+" j: "+j);
            }
            k++;
            //System.out.println("333 n1: "+n1+" n2: "+n2+" i: "+i+" j: "+j+" k: "+k);
        }

        while (i<n1){
            arr[k] = L[i];
            i++;
            k++;
            //System.out.println("444  i: "+i+" k: "+k);

        }
        while ( j<n2){
            arr[k] = R[j];
            j++;
            k++;
            //System.out.println("555  j: "+j+" k: "+k);
        }
    }

    void sort(int arr[], int l, int r){
        if(l<r){
            int m = (l+r)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            mergeSort(arr,l,m,r);

        }
    }
}


class PrintArr{
    public void printArray(int arr[]){
        int n = arr.length;
        System.out.print("[");
        for(int i=0; i<n; ++i){
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
    }
}

