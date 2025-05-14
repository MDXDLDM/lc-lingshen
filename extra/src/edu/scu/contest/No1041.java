package edu.scu.contest;

public class No1041 {
    public boolean isRobotBounded(String instructions) {
        int x=0;int y=0;
        int index=0;
        int flag=0;
        while(index<instructions.length()) {
            switch(instructions.charAt(index)) {
                case 'L':flag--;break;
                case 'R':flag++;break;
                case 'G':
                    if(flag%4==0){
                        y++;
                    }else if(flag%4==1||flag%4==-3){
                        x++;
                    }else if(flag%4==2||flag%4==-2){
                        y--;
                    }else if(flag%4==3||flag%4==-1){
                        x--;
                    }
            }
            index++;
        }
        System.out.println("x"+x+" y"+y);
        return (x == 0 && y == 0)||flag%4!=0;
    }
}
