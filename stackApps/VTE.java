class VTE{
    static boolean isGood = true;

    void validateString(String string){
        isGood = true;
        charStack stack = new charStack();
        stack.init();

        for(int i = 0; i<string.length(); i++){
            if(string.charAt(i) == '('){
                stack.push('(');
            }
            else if(string.charAt(i) == ')'){
                if(stack.isStackEmpty()==false){
                    stack.pop();
                }
                else{
                    System.out.println("Error: too many ')'");
                    isGood=false;
                    break;
                }
            }
        }
        if(stack.isStackEmpty()==false){
            System.out.println("Error: too many '('");
            isGood = false;
        }

        if(isGood == true){
            System.out.println("Verified: " + string);
        }  
    }

    String translateString(String string){
        charStack post = new charStack();
        charStack op = new charStack();
        post.init();
        op.init();

        for(int i = 0; i<string.length(); i++){
            if((string.charAt(i)>='0' && string.charAt(i)<='9') || (string.charAt(i)>='a' && string.charAt(i)<='z')){
                post.push(string.charAt(i));
            }
            else if(string.charAt(i) == '+' || string.charAt(i) == '-' || string.charAt(i) == '*' || string.charAt(i) == '/'){
                op.push(string.charAt(i));
            }
            else if(string.charAt(i) == ')'){
                if(op.isStackEmpty() == false){
                    post.push(op.pop());
                }
            }
        }

        while(op.isStackEmpty() == false){
            post.push(op.pop());
        }

        System.out.println("Translated: " + post.stackToString());
        return post.stackToString();

    }

    void evaluateString(String string){
        intStack stack = new intStack();
        int x, y;
        stack.init();

        for(int i = 0; i<string.length(); i++){
            if(string.charAt(i)>='0' && string.charAt(i)<='9'){
                stack.push((int)(string.charAt(i) - '0'));
            }
            else if(string.charAt(i) == '+'){
                y = stack.pop();
                x = stack.pop();
                stack.push(x+y);
            }
            else if(string.charAt(i) == '-'){
                y = stack.pop();
                x = stack.pop();
                stack.push(x-y);
            }
            else if(string.charAt(i) == '*'){
                y = stack.pop();
                x = stack.pop();
                stack.push(x*y);
            }
            else if(string.charAt(i) == '/'){
                y = stack.pop();
                x = stack.pop();
                stack.push(x/y);
            }
        }

        System.out.println("Evaluated: " + stack.pop());
    }

    void fullCheck(String string){
        String translated;
        validateString(string);
        if(isGood == true){
            translated = translateString(string);
            evaluateString(translated);
        }
    }
}