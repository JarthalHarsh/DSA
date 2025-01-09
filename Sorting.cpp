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
int main() {
    vector<int> arr = {5,3,1,4,2,18,3,6,8,11,12};
    //bubblesort(arr);
    //selectionSort(arr);

    InsertionSort(arr);
    return 0;
}
