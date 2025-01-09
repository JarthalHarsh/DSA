#include <bits/stdc++.h>

using namespace std; // Makes all standard library names available without the "std::" prefix


void swap(int *a, int *b)
{
     int temp = *a;
     *a = *b;
     *b = temp;
}

void bubblesort(vector<int> arr)
{
   int n = arr.size();
   for(int i=n-1; i >= 1 ; i--)
   {
      int element = arr[i];
      for(int j = i - 1; j >=0;j--)
      {
        if(arr[i] < arr[j])
        {
            swap(arr[i],arr[j]);
        }
      }
   }

   for(int val : arr)
   {
      cout<<val<<",";
   }
}

void selectionSort(vector<int> arr)
{
    int n = arr.size();
    for(int i = 0; i < n-1; i++)
    {
       int k = i;
       int min = arr[i];
       for(int j = i+1; j<n; j++)
       {
           if(arr[j] < min)
           {
              min = arr[j];
              k = j;
           }
       }
       swap(arr[i], arr[k]);
    }

    for(int val : arr)
   {
      cout<<val<<",";
   }
}

void InsertionSort(vector<int> arr)
{
    int n = arr.size();
    for(int i = 0; i < n; i++)
    {
       int temp = arr[i];
       for(int j = i - 1 ; j >=0;j--)
       {
         if(arr[j] > temp)
         {
            arr[j+1] = arr[j];
            arr[j] = temp;
         }
         else
         {
            arr[j+1] = temp;
            break;
         }
       }
    }

   for(int val : arr)
   {
      cout<<val<<",";
   }
}

int partitionArr(vector<int> &arr, int start, int end)
{
   //{5,3,1,4,2,18,3,6,8,11,12}
   int n = end+1;
   int partEle = arr[n-1];
   int j = start-1;
   for(int i = start; i < n; i++)
   {
       if(arr[i] <= partEle)
       {
         int k = i;
         int temp = arr[i];
         while(k > j+1)
         {
            arr[k] = arr[k-1];
            k--;
         }
         arr[k] = temp;
         j++;
         if(i == n-1)
         {
           return k;  
         }
       }
       
   }
   return -1;
} 

void quickSort(vector<int> &arr, int start, int end)
{
   if(start > end)
   {
      return;
   }
   int index = partitionArr(arr,start,end);
   quickSort(arr,start,index-1);
   quickSort(arr,index+1,end);
}


int main() {
    vector<int> arr = {5,3,1,4,2,18,3,6,8,11,7};
    //bubblesort(arr);
    //selectionSort(arr);

    //InsertionSort(arr);

    //cout<<partitionArr(arr,0,10);
    quickSort(arr,0,10);

    for(int val : arr)
   {
      cout<<val<<",";
   }

    return 0;
}
