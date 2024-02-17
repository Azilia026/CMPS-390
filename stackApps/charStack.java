class charStack {
    char stack[] = new char[40];
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

    void push(char c){
        top++;
        stack[top] = c;
    }

    char pop(){
        char c;
        c = stack[top];
        top--;
        return c;
    }

    void showStack(){
        for(int j=0; j<=top; j++){
            System.out.print(stack[j]);
        }
    }

    String stackToString(){
        String string = "";
        for(int j=0; j<=top; j++){
            string += stack[j];
        }
        return string;
    }
}
