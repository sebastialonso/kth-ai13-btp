package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Vector<String> board = new Vector<String>();
        Element root;
        Boolean goal = false;
        LinkedList<Element> paths;
        LinkedList<Element> already_visited;
        Vector<Integer> final_position;

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String line;


        while(br.ready()) {
            line = br.readLine();
            board.add(line);
        } // End while

        final_position = getGoalPosition(board);
        root = new Element(board, getStartPosition(board));
        root.setType('@');
        root.setParent(null);
        paths = new LinkedList<Element>();
        already_visited = new LinkedList<Element>();
        paths.add(root);
        already_visited.add(root);

        /* print the maze */
        for ( String lines : board){
            for ( int j = 0; j < lines.length(); j++){
                System.out.print(lines.charAt(j));
            }
            System.out.println();
        }


        System.out.println(root.getPosition());
        System.out.print("puedo mover a la derecha: ");
        System.out.println(root.canMoveRight());
        System.out.print("puedo mover a la izquierda: ");
        System.out.println(root.canMoveLeft());

        //Miramos hacia la derecha, si tipo igual espacio, creamos elemento y agregamos a lista de vecinos, seteamos el padre.
        //Idem si miramos a arriba, izquieda, abajo.
        Element current_node = paths.removeFirst();
        //Moving cycle
        while (!goal){
            //Look right
            System.out.println(current_node.getPosition());
            //If I can move right
            if (current_node.canMoveRight()){
                //We need position in right of current node
                Vector<Integer> right = new Vector<Integer>();
                right.add( current_node.getPosition().firstElement() +1);
                right.add( current_node.getPosition().lastElement());

                Element next_node = new Element(right);
                // TODO Check if position is final
                if (next_node.samePositionAs(final_position)){
                    paths.add(next_node);
                    //We are done. Proceed to the path building stage
                    break;
                }
                //And if right is not already visited...
                else if (!next_node.isIn(already_visited)){
                    //Add right node to queue
                    paths.add(next_node);
                    already_visited.add(next_node);
                }
            }
            //Move up
            if (current_node.canMoveUp()){
                Vector<Integer> up = new Vector<Integer>();
                up.add( current_node.getPosition().firstElement());
                up.add( current_node.getPosition().lastElement() - 1);

                Element next_node = new Element(up);
                if (next_node.samePositionAs(final_position)){
                    paths.add(next_node);
                    //We are done. Proceed to the path building stage
                    break;
                }
                else if (!next_node.isIn(already_visited)){
                    paths.add(next_node);
                    already_visited.add(next_node);
                }
            }
            //Move left
            if (current_node.canMoveLeft()){
                Vector<Integer> left = new Vector<Integer>();
                left.add( current_node.getPosition().firstElement() - 1);
                left.add( current_node.getPosition().lastElement());

                Element next_node = new Element(left);
                if (next_node.samePositionAs(final_position)){
                    paths.add(next_node);
                    break;
                }
                else if (!next_node.isIn(already_visited)){
                    paths.add(next_node);
                    already_visited.add(next_node);
                }

            }
            //Move down
            if (current_node.canMoveDown()){
                Vector<Integer> down = new Vector<Integer>();
                down.add(current_node.getPosition().firstElement());
                down.add(current_node.getPosition().lastElement() + 1);

                Element next_node = new Element(down);
                if (next_node.samePositionAs(final_position)){
                    paths.add(next_node);
                    break;
                }
                else if (!next_node.isIn(already_visited)){
                    paths.add(next_node);
                    already_visited.add(next_node);
                }

            }
            current_node = paths.removeFirst();
        }

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
    //Checks for the first goal position only!
    public static Vector<Integer> getGoalPosition( Vector<String> board)
    {
        Vector<Integer> result = new Vector<Integer>();
        int j;

        for ( int i = 0; i < board.size(); i++){
            String line = board.get(i);

            for(j = 0; j < line.length(); j++){

                if (line.charAt(j) == '*'){
                    result.add(i);
                    result.add(j);
                    break;
                }
            }
        }
        return result;
    }

    /*public static String buildPath(LinkedList<Element> path){
        String response = "";
        int path_length = path.size();
        Element current = path.poll();
        for (Element next : path ){
            //Change in Y coordinate
            if (current.getPosition().firstElement() < next.getPosition().firstElement()
        }

        return response;
    }*/
} // End Main
