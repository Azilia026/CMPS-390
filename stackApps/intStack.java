class intStack {
int stack[] = new int[40];
    int top;

    void init(){
        top = -1;
    }
    
    boolean isStackEmpty(){
        boolean answer;
        answer = false;
        if(top==-1){
            answer=true;
        }
        return answer;
    }

    void push(int i){
        top++;
        stack[top] = i;
    }

    int pop(){
        int i;
        i = stack[top];
        top--;
        return i;
    }
    
    void showStack(){
        int j;
        for(j=0; j<=top; j++){
            System.out.print(stack[j]);
        }
    }
}
