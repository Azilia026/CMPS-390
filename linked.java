import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class linked {
    node front;
    node[] index = new node[26];
    
    void init(){
        front=null;
    }

    int nameToNumber(String name){
        int number = 0;
        if(name.length() == 3){    
            number = (int)(
            (((name.charAt(0)-'a')+1)*Math.pow(26, 4))
            +(((name.charAt(1)-'a')+1)*Math.pow(26, 3))
            +(((name.charAt(2)-'a')+1)*Math.pow(26, 2)));
        }
        else if(name.length() == 4){    
            number = (int)(
            (((name.charAt(0)-'a')+1)*Math.pow(26, 4))
            +(((name.charAt(1)-'a')+1)*Math.pow(26, 3))
            +(((name.charAt(2)-'a')+1)*Math.pow(26, 2))
            +(((name.charAt(3)-'a')+1)*Math.pow(26, 1)));
        }
        else{
            number = (int)(
            (((name.charAt(0)-'a')+1)*Math.pow(26, 4))
            +(((name.charAt(1)-'a')+1)*Math.pow(26, 3))
            +(((name.charAt(2)-'a')+1)*Math.pow(26, 2))
            +(((name.charAt(3)-'a')+1)*Math.pow(26, 1))
            +(((name.charAt(4)-'a')+1)*Math.pow(26, 0)));
        }
        return number;
    }

    node makeNode(String name){
        name = name.toLowerCase();
        
        node t = new node();
        t.name = name;

        t.data = nameToNumber(name);
        t.next = null;
        return t;
    }

    void deleteNode(String name){
        node toDelete = findNode(name);
        node prevNode = findPrev(name);
        if(front.name.equals(name)){
            front = toDelete.next;
            toDelete.next = null;
        }
        else{
            prevNode.next = toDelete.next;
            toDelete.next = null;
        }
    }

    void showlist(){
        node current=front;
        while(current!= null){
            System.out.print(current.name + " ");
            current=current.next;
        }
    }

    void insertOrdered(String name){
        node curr;
        node prev;
        node t=makeNode(name);
        boolean searching;

        if(front == null){
            front = t;
        }
        else if(t.data<front.data){
            t.next=front;
            front=t;
        }
        else{
            curr =front;
            prev =curr;
            searching = true;
            while(searching){
                if(curr.data==t.data){
                    System.out.println("Duplicate: " + name);
                    searching = false;
                }
                else if(curr.data<t.data){
                    if(curr.next==null){
                        curr.next=t;
                        searching=false;
                    }
                    prev =curr;
                    curr =curr.next;
                }
                else if(curr.data>t.data){
                    t.next = curr;
                    prev.next = t;
                    searching =false;
                }
            }
        }
    }

    public void makeListFromFile(String fname){
        boolean looping;
        DataInputStream in;
        String line;

        try {
            in = new DataInputStream(new FileInputStream(fname));

            looping = true;
            while(looping) {
                if (null == (line = in.readLine())) {
                    looping = false;
                    in.close();
                }
                else {
                    insertOrdered(line);
                }
            }
        }
        catch(IOException e) {
            System.out.println("Error " + e);
        }
    }

    int getListLength(){
        int count = 0;
        node curr = front;
        while(curr.next != null){
            count++;
            curr=curr.next;
        }
        return count+1;
    }

    void buildIndex(){
        node curr = front;
        int i = curr.name.charAt(0) - 'a';
        index[0] = curr;

        while(curr.next != null){
            if(curr.name.charAt(0) - 'a' != i){
                i = curr.name.charAt(0) - 'a';
                index[i] = curr;
            }
            curr =curr.next;
        }
    }

    int getSectionLength(char c){
        int count = 0;
        int i = c - 'a';
        node curr = index[i];

        while(curr != null){
            if(curr.name.charAt(0) - 'a' != i){
                break;
            }
            count++;
            curr = curr.next;
        }
        
        return count;
    }

    void displaySection(char c){
        int i = c - 'a';
        node curr = index[i];

        while(curr != null){
            if(curr.name.charAt(0) - 'a' != i){
                break;
            }
            System.out.print(curr.name + " ");
            curr = curr.next;
        }
    }

    node findPrev(String name){
        node current = front;
        node prev = current;
        while(!current.name.equals(name)){
            if(current.next == null){
                throw new NullPointerException();
            }
            prev = current;
            current=current.next;
        }
        return prev;
    }
    
    node findNode(String name){
        node current = front;
        while(!current.name.equals(name)){
            if(current.next == null){
                throw new NullPointerException();
            }
            current=current.next;
        }
        return current;
    }
}
