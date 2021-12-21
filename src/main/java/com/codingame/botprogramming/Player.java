package com.codingame.botprogramming;

import java.awt.*;
import java.util.*;
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean boost = true;
        ArrayList<Point> allPoints = new ArrayList<>();
        int turn = 1;
        int lap = 1;
        int i = 1;
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            System.err.println("nextCheckpointX: " + nextCheckpointX);
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            System.err.println("nextCheckpointY: " + nextCheckpointY);
            Point p = new Point(nextCheckpointX, nextCheckpointY);
            System.err.println("turn: " + turn);
            if (turn == 1) {
                allPoints.add(p);
                turn++;
            } else {
                System.err.println("!allPoints.contains(p): " + !allPoints.contains(p));
                if (!allPoints.contains(p)) {
                    allPoints.add(p);
                    System.err.println("allPoints.get(0).getX(): " + allPoints.get(0).getX());
                    System.err.println("allPoints.get(0).getX() == nextCheckpointX: " + (allPoints.get(0).getX() == nextCheckpointX));
                }
            }
            if ((allPoints.get(0).getX() == nextCheckpointX) && allPoints.size() >= 2) {
                lap = 2;
            }
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            System.err.println(nextCheckpointDist);
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            //System.err.println(nextCheckpointAngle);
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();
            if (boost && nextCheckpointAngle == 0 && nextCheckpointDist >= 5000) {
                System.out.println(nextCheckpointX + " " + nextCheckpointY + " BOOST");
                boost = false;
                continue;
            }
            String thrust = getThrust(nextCheckpointAngle, nextCheckpointDist);
            if (lap == 2) {
                System.err.println("nextCheckpointX == (int)allPoints.get(allPoints.size()-1).getX() && i == 0 "
                        + (nextCheckpointX == (int)allPoints.get(allPoints.size()-1).getX() && i == 0));
                if (nextCheckpointX == (int)allPoints.get(allPoints.size()-1).getX() && i == 0){
                    System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + thrust);
                    continue;
                }
                if (i == allPoints.size()) {
                    i = 0;
                }
                if (((int)allPoints.get(i).getX() == nextCheckpointX) && ((int)allPoints.get(i).getY() == nextCheckpointY)) {
                    i++;
                }
                System.err.println("nextCheckpointAngle: " + nextCheckpointAngle);
                if (nextCheckpointDist <= 2000 && (nextCheckpointAngle < 45 && nextCheckpointAngle > -45)) {
                    System.err.println("i == allPoints.size(): " + (i == allPoints.size()));
                    System.err.println("(int)allPoints.get(i).getX(): " + (int)allPoints.get(i).getX());
                    System.err.println("(int)allPoints.get(i).getY(): " + (int)allPoints.get(i).getY());
                    System.out.println((int)allPoints.get(i).getX() + " " + (int)allPoints.get(i).getY() + " " + thrust);
                    System.err.println("i before checkpoint: " + i);
                    System.err.println("i: " + i);
                    continue;
                }
            }
            System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + thrust);
        }
    }

    public static String getThrust(int nextCheckpointAngle, int nextCheckpointDist) {
        double maxThrust = 100.0;
        double thrust = maxThrust * (1.0 - Math.abs(nextCheckpointAngle) / 90.0);
        if (nextCheckpointAngle > 90 || nextCheckpointAngle < -90) {
            return "0";
        } else {
            return "100";
        }
    }
}