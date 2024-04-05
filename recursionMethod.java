class recursionMethod {
    int summation(int x){
        if(x==1){
            return 1;
        }
        else{
            return x+summation(x-1);
        }
    }

    int summationI(int x){
        int sum = 0;
        for(int j=x; j>=1; j--){
            sum = sum+j;
        }
        return sum;
    }


}
