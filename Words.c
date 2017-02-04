/*
sort array of words by their lengths and ASCII values(Alphabetically)
*/

#include<stdio.h>
#include<string.h>
int main()
{

    int n;
    char words[100][11], temp[11];
    scanf("%d",&n);
    for (int i = 0; i <n; ++i) {
        scanf("%s",words[i]);

    }
    
    //first sort by length
    for (int i = 0; i < n - 1 ; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (strlen(words[i])>strlen(words[j]))
            {
                strcpy(temp, words[i]);
                strcpy(words[i], words[j]);
                strcpy(words[j], temp);
            }
        }
    }
    
    //second sort by ASCII values and by length comparison 
    
       for (int i = 0; i < n - 1 ; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (strcmp(words[i],words[j])>0&&strlen(words[i])>=strlen(words[j]))
            {
                strcpy(temp, words[i]);
                strcpy(words[i], words[j]);
                strcpy(words[j], temp);
            }
        }
    }


    for (int i = 0; i < n; i++)
    {
        printf("%s\n", words[i]);
    }

    return 0;
}
