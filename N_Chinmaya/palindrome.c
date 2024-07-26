#include <stdlib.h>
#include <string.h>

bool isPalindrome(int x) {
    if(x<0) return false;
    int i;
    char s[12];
    snprintf(s, sizeof(s), "%d", x);
    int n=strlen(s);
    char str[12];
    for (i=0,n=n-1;n>=0;i++,n--){
        str[i] = s[n];
    }
    str[i]='\0';
    for(i=0;str[i]!='\0' && s[i]!='\0';i++){
        if(str[i]!=s[i]) return false;
    }
    return true;
}
