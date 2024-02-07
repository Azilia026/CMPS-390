#include <iostream>
using namespace std;

int main(){
    int a[10];
    int *mptr;
    mptr = &(a[0]);

    for(int i=0; i<10; i++){
        a[i] = i;
    }
    
    for(int i=0; i<10; i++){
        cout << a[i] << " ";
    }

    int j=100;
    for(int i=0; i<10; i++){
        *mptr = j;
        j++;
        mptr++;
    }

    cout << "\n";

    mptr = &(a[0]);
    for(int i=0; i<10; i++){
        cout << *mptr << " ";
        mptr++;
    }
}