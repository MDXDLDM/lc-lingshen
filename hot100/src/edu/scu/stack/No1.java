package edu.scu.stack;

public class No1 {
    public boolean isValid(String s) {
        char[] stack=new char[s.length()];
        int index=-1;
        for(char a:s.toCharArray()){
            if(a=='('||a=='['||a=='{'){
                index++;
                stack[index]=a;
            }else{
                if(index==-1) return false;
                char judge=stack[index];
                if(a==')'&&judge!='(') return false;
                if(a==']'&&judge!='[') return false;
                if(a=='}'&&judge!='{') return false;
                index--;
            }
        }
        return index==-1;
    }
}
