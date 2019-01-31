int largest(int arr[], int n)
{
    int i;
    int max = arr[0];

    for (i = 1; i < n; i++)
        if (arr[i] > max)
            max = arr[i];
 
    return max;
}
 
int main()
{
    int arr[] = {67, 111, 79, 123, 6480, 00};
    int n = sizeof(arr)/sizeof(arr[0]);
    printf("The largest element in the array is %d", largest(arr, n));
    return 0;
}