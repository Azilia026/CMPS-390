class linked {
    node front;
    
    void init(){
        front=null;
    }

    node makeNode(int number){
        node t = new node();
        t.data = number;
        t.next = null;
        return t;
    }

    node findPrev(int number){
        node current = front;
        node prev = current;
        while(current.data != number){
            if(current.next == null){
                throw new NullPointerException();
            }
            prev = current;
            current=current.next;
        }
        return prev;
    }
    

    node findNode(int number){
        node current = front;
        while(current.data != number){
            if(current.next == null){
                throw new NullPointerException();
            }
            current=current.next;
        }
        return current;
    }
    
    node findTail(){
        node current = front;
        while(current.next != null){
            current=current.next;
        }
        return current;
    }

    void buildSimpleList(int n){
        node tail;
        for(int j = 0; j<n; j++){
            if(j==0){
                init();
                front = makeNode(j);
            }
            else{
                tail=findTail();
                tail.next = makeNode(j);
            }
        }
    }

    void showlist(){
        node current=front;
        while(current!= null){
            System.out.print(current.data + " ");
            current=current.next;
        }
    }

    void deleteNode(int data){
        node toDelete = findNode(data);
        node prevNode = findPrev(data);
        if(front.data == data){
            front = toDelete.next;
            toDelete.next = null;
        }
        else{
            prevNode.next = toDelete.next;
            toDelete.next = null;
        }
    }

    void insertOrdered(int number){
        node curr;
        node prev;
        node t;
        boolean searching;

        if(number<front.data){
            t=makeNode(number);
            t.next=front;
            front=t;
        }
        else{
            curr =front;
            prev =curr;
            searching = true;
            while(searching){
                if(curr.data==number){
                    System.out.println("Duplicate.");
                    searching = false;
                }
                else if(curr.data<number){
                    if(curr.next==null){
                        t=makeNode(number);
                        curr.next=t;
                        searching=false;
                    }
                    prev =curr;
                    curr =curr.next;
                }
                else if(curr.data>number){
                    t=makeNode(number);
                    t.next = curr;
                    prev.next = t;
                    searching =false;
                }
            }
        }
    }

    void insertChaos(int number, int data){
        node t = makeNode(data);
        node found = findNode(number);

        if(found.next == null){
            t.next = null;
            found.next = t;
        }
        else{
            t.next = found.next;
            found.next = t;
        }
    }

}
