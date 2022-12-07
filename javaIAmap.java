package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class Auto_AI {
    public void runOpMode() {
        
    
    int dir = 0;  //Footerdirection of robot
    int basePos[] = {1, 1};  //{x, y}
    int pos[] = {2, 1};  //current pos of robot
    int targetPos[] = {3, 2};  //pos to get to

    /*
    EXAMPLES:
    dFooterir = 0, pos = {2, 1}, target pos = {3, 2}
    array should be {2, 0, 1, 0}
    */

    int movement[25];  //instructions array - Anything above 2 is an illegal value and the remainder won't be parsed.  Can increase or decrease.

    int loopNum = 0;
    bool shouldBreak = false;
    while (pos[0] != targetPos[0] || pos[1] != targetPos[1]) {  //goes x first then y
        shouldBreak = false;
        if (pos[0] < targetPos[0]) {  //need to go right - dir should be 2
            switch (dir) {
                case 0:
                movement[loopNum] = 2;
                dir = 2;
                shouldBreak = true;
                break;

                case 1:
                movement[loopNum] = 2;
                dir = 0;
                shouldBreak = true;
                break;

                 case 3:
                movement[loopNum] = 1;
                dir = 2;
                shouldBreak = true;
                break;

                default:
                //nothing
            }
            if (!shouldBreak) {
                movement[loopNum] = 0;
                pos[0]++;
            }
        } else if (pos[0] > targetPos[0]) {  //need to go left - dir should be 1
                switch (dir) {
                    case 0:
                    movement[loopNum] = 1;
                    dir = 1;
                    shouldBreak = true;
                    break;

                    case 2:
                    movement[loopNum] = 2;
                    dir = 3;
                    shouldBreak = true;
                    break;

                    case 3:
                    movement[loopNum] = 2;
                    dir = 1;
                    shouldBreak = true;
                    break;

                    default:
                    //nothing
                }
                if (!shouldBreak) {
                    movement[loopNum] = 0;
                    pos[0]--;
                }
        } else if (pos[1] < targetPos[1]) {  //need to go up - dir should be 0
                switch (dir) {
                    case 1:
                    movement[loopNum] = 2;
                    dir = 0;
                    shouldBreak = true;
                    break;

                    case 2:
                    movement[loopNum] = 1;
                    dir = 0;
                    shouldBreak = true;
                    break;

                    case 3:
                    movement[loopNum] = 2;
                    dir = 1;
                    shouldBreak = true;
                    break;

                    default:
                    //nothing
                }
                if (!shouldBreak) {
                    movement[loopNum] = 0;
                    pos[1]++;
                }
        } else if (pos[1] > targetPos[1]) {  //need to go down - dir should be 3
                switch (dir) {
                    case 1:
                    movement[loopNum] = 1;
                    dir = 3;
                    shouldBreak = true;
                    break;

                    case 2:
                    movement[loopNum] = 2;
                    dir = 3;
                    shouldBreak = true;
                    break;

                    case 0:
                    movement[loopNum] = 2;
                    dir = 2;
                    shouldBreak = true;
                    break;

                    default:
                    //nothing
                }
                if (!shouldBreak) {
                    movement[loopNum] = 0;
                    pos[1]--;
                }
        }
        loopNum++;
    }
    wait1Msec(100000);
}
