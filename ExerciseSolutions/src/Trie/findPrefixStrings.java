package Trie;

import java.util.*;

public class findPrefixStrings {

    static class node{

        char ch;
        HashMap<Character,node> next;
        boolean isTerminal;
        node(char a){
            ch=a;
            next = new HashMap<>();
            isTerminal=false;
        }
    }

    static class Trie{
        node root= new node('\0');

        //inserting in a Trie
        void insert(String str){
            node temp=root;
            for(int i=0; i<str.length(); i++){
                if(!temp.next.containsKey(str.charAt(i))){
                    temp.next.put(str.charAt(i),new node(str.charAt(i)));
                }
                temp=temp.next.get(str.charAt(i));
            }
            temp.isTerminal=true;
        }


        //Searching in a Trie
        boolean search(String str){
            node temp=root;
            for(int i=0; i<str.length(); i++){
                if(!temp.next.containsKey(str.charAt(i))){
                    return false;
                }
                temp=temp.next.get(str.charAt(i));
            }
            return temp.isTerminal;
        }


        void dfs(node temp, ArrayList<String> v, StringBuilder word ){
            if(temp.isTerminal){
                v.add(word.toString());
            }
            if(temp.next.isEmpty()){
                return;
            }
            for(Map.Entry<Character, node> p:temp.next.entrySet()){
                word.append(p.getKey());
                dfs(temp.next.get(p.getKey()),v,word);
                word.deleteCharAt(word.length()-1);
            }
            return;
        }



        ArrayList<String> find(String str){
            ArrayList<String> v = new ArrayList<>();
            node temp=root;
            StringBuilder word= new StringBuilder("");
            for(int i=0; i<str.length(); i++){
                if(!temp.next.containsKey(str.charAt(i))){
                    return v;
                }
                word.append(str.charAt(i));
                temp=temp.next.get(str.charAt(i));
            }

            dfs(temp,v,word);
            Collections.sort(v);
            return v;
        }




    };



    static ArrayList<String> findPrefixStrings(List<String> words, String prefix){

        Trie t = new Trie();
        for(String s:words){
            t.insert(s);
        }
        return t.find(prefix);
    }


    public static void main(String[] args) {

        List<String> words = new ArrayList<>(Arrays.asList("abc","abd","acde","abe","aeb","abba"));
        findPrefixStrings(words, "ap");
    }



}
