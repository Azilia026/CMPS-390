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
        int j;
        for(j=0; j<=top; j++){
            System.out.print(stack[j]);
        }
    }

    void stringToStack(String n){
        charStack stacks = new charStack();
        stacks.init();
        for(int j=0; j<n.length(); j++){
            stacks.push(n.charAt(j));
        }

        while(stacks.isStackEmpty() == false){
            System.out.print(stacks.pop());
        }

        System.out.println("");
    }
}
