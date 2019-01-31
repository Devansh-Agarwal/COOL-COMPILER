#include <stdio.h>
#include <string.h>
int main()
{
	char str[250], rev[250];
	int i, j= 0;
	printf("Enter the string\n");
	gets(str);
	for(i = strlen(str) -1; i>=0 ; i++)
	{
		rev[j++] = str[i];
	}
	rev[i] = '\0';
	printf("Reverse of the string is: \n%s",rev);
}


