//Practise problem for Array and List

//Q1:is unique

//Method I: using data structure 
//Using hashtable to store the key for each characteristic in the string 
public boolean IsUnique(String str){
    HashMap<Character,Integer> char_dic = new HashMap<Character,Integer>();
    for(int i = 0;i<str.length();i++){
    	if (char_dic.containsKey(str.charAt(i))){return false;}
    	else {char_dic.put(str.charAt(i),1);}
    }
    return true;
}

//Method II: not using any data structure 
