package com.company;

import java.io.*;
import java.util.Vector;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Vector<String> board = new Vector<String>();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String line;
        Element root = new Element();

        while(br.ready()) {
            line = br.readLine();
            board.add(line);
        } // End while


        /* print the maze */
        for ( String lines : board){
            for ( int j = 0; j < lines.length(); j++){
                System.out.print(lines.charAt(j));
            }
            System.out.println();
        }

        root.setPosition(getStartPosition(board));
        root.setType('@');
        root.setParent(null);
        System.out.println(root.getPosition());

        //
    } // main

    public static Vector<Integer> getStartPosition( Vector<String> board)
    {
        Vector<Integer> result = new Vector<Integer>();
        int j;

        for ( int i = 0; i < board.size(); i++){
            String line = board.get(i);

            for(j = 0; j < line.length(); j++){

                if (line.charAt(j) == '@'){
                    result.add(i);
                    result.add(j);
                    break;
                }
            }
        }
        return result;
    }
} // End Main
