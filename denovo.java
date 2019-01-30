import java.io.*;
import java.util.Iterator;
import java.io.File; 
import java.util.*;
import java.util.Scanner;
import java.util.LinkedList; 
import java.util.Queue; 
import java.util.HashMap;
import java.util.Map; 

public class denovo{
	
	public static void main(String[] args) throws Exception{ 
		ArrayList<Node> nodeArray = new ArrayList<Node>();
		ArrayList<Edge> edgeArray = new ArrayList<Edge>();
		HashMap<Integer, Integer> EdgeB = new HashMap<Integer,Integer>();
		ArrayList<Integer> arrB = new ArrayList<Integer>();
		HashMap<String,Integer> nodeB = new HashMap<String,Integer>();
		HashMap<Integer,Integer> all = new HashMap<Integer,Integer>();
		HashMap<Character,Integer> am = new HashMap<Character,Integer>();
		HashMap<Integer,HashMap<String,Integer>> deno = new HashMap<Integer,HashMap<String,Integer>>();
		boolean bIon = false;
		boolean q1a = false;
		boolean q1b = false;
		boolean q2a = false;
		boolean q2b = false;
		
		am.put('A',71);
		am.put('R',156);
		am.put('N',114);
		am.put('D',115);
		am.put('C',103);
		am.put('E',129);
		//am.put('Q',128);
		am.put('G',57);
		am.put('H',137);
		//am.put('I',113);
		am.put('L',113);
		am.put('K',128);
		am.put('M',131);
		am.put('F',147);
		am.put('P',97);
		am.put('S',87);
		am.put('T',101);
		am.put('W',186);
		am.put('Y',163);
		am.put('V',99);
		int j;
		int count = 0;
		if(args[0].equals("q1a")){	
			q1a = true;
			Node nodeStart = new Node(1);
			nodeStart.intensity = 0;
			nodeArray.add(nodeStart);
			arrB.add(1);
		}
		if(args[0].equals("q1b")){
			q1b = true;
			Node nodeStart = new Node(19);
			nodeStart.intensity = 0;
			nodeArray.add(nodeStart);
			arrB.add(19);
		}
		File file2 = new File(args[1]);
		Scanner s = new Scanner(file2);
		String arg3;
		if(!(args[0].equals("q2a"))){
			 arg3 = args[2];
		}
		else{
			arg3 = " ";
		}
		
		int w = 0;
		int water = 0;
		water = s.nextInt();
		water = water - 18;
		//System.out.println("water is " + water);
		s.nextLine();
		int start = 0;
		int cal1 = 0;
		int cal2 =0;
		int find = 0;
		while(s.hasNext()){
			
			//Node node = new Node(cal1);
			cal1 = s.nextInt();
			cal2 = s.nextInt();
			//System.out.println(cal1 +" " + cal2);
			all.put(cal1,cal2);
			//nodeArray.add(node);
		}
		//int lastElement = cal2;
		//System.out.println("size if all is " + all.size());
		Vector<Integer> v = new Vector<Integer>(10000);
		for(int i = 0;i< 10000;i++){
			v.add(0,0);

		}
		
		if(args[0].equals("q2a")){
			v.add(1,1);
			//v.add(19,19);
			all.put(1,0);
			//all.put(water,water);
			all.put(water,0);
			q2a = true;
		}
		if(args[0].equals("q2b")){
			q2b = true;
		}
		//if(!(args[0].equals("q2a"))){	
		if(args[0].equals("q1a")||args[0].equals("q1b")||args[0].equals("q2b")){ //|| args[0].equals("q1b")){
			for(int q =0;q<arg3.length();q++){
				find +=am.get((arg3.charAt(q)));
				for(Map.Entry<Integer,Integer>entry:all.entrySet()){
					if((entry.getKey() -1) == find){
						count += entry.getValue();
					}

				}

			}
		}
		int get = 0;
		get = find;
		int count2 = 0;
		for(Map.Entry<Integer,Integer>entry:all.entrySet()){
                                        if((entry.getKey()== get)){
                                                count2 += entry.getValue();
                                        }

                 }
		if(args[0].equals("q1b")){
			for(int n =1;n<arg3.length();n++){
				get= get - am.get(arg3.charAt(n-1));	
                                for(Map.Entry<Integer,Integer>entry:all.entrySet()){
                                        if((entry.getKey() -19) == get){
                                                count2 += entry.getValue();
                                        }

                                }

                        }

		}
		if(args[0].equals("q1a")){
			System.out.println(arg3+" "+count);
		}
		if(args[0].equals("q1b")){
			System.out.println(arg3+" "+ (count+count2));
		}
		 
		File file3 = new File(args[1]);
                Scanner s2 = new Scanner(file3);
		s2.nextLine();
		while(s2.hasNext()&&q2a){	
				j = s2.nextInt();
				w = s2.nextInt();
				//System.out.println(" input is " + j);	
				HashMap<String,Integer> mPut = new HashMap<String,Integer>();
				String sb = new String();
				if((v.contains(j-71) && (j - 71) != 0)){
                                        v.set(j,j);
					mPut.put("A",j-71);	
					deno.put(j,mPut);
					//System.out.println("mass is " + j);
					
				}
				if(v.contains(j- 156) && (j - 156)!= 0){
					//System.out.println("mass is " + j);
                                        v.set(j,j);
					mPut.put("R",j - 156);
					deno.put(j,mPut);
				}
				if(v.contains(j- 114)&& (j - 114)!= 0){
                                        v.set(j,j);
					mPut.put("N",j - 114);
					deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j- 115)&& (j - 115)!= 0){
                                        v.set(j,j);
					mPut.put("D", j - 115);
					//System.out.println("mass is " + j);
					deno.put(j,mPut);
				}
				if(v.contains(j-103)&& (j - 103)!= 0){
                                        v.set(j,j);
					mPut.put("C", j - 103);
					deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j - 129)&& (j - 129)!= 0){
                                        v.set(j,j);
					mPut.put("E", j - 129);
					deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				/*if(v.contains(j- 128)&& (j - 128)!= 0){
                                        v.set(j,j);
                                        mPut.put("Q", j - 128);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
                                }*/
				if(v.contains(j-57)&& (j - 57)!= 0){
                                        v.set(j,j);
                                        mPut.put("G", j - 57);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j- 137)&& (j - 137)!= 0){
                                        v.set(j,j);
                                        mPut.put("H", j - 137);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				
				/*if((j-arrB.get(i))== 113){
                                	Node node1 = new Node(arrB.get(i));
                                        node1.st = "I";
                                        Edge edge = new Edge(node1);
                                        node.adj.add(edge);
                                        EdgeB.put(arrB.get(i),j);
                                        nodeB.put("I",w);
				}*/
				if(v.contains(j- 113)&& (j - 113)!= 0){
                                        v.set(j,j);
                                        mPut.put("L", j - 113);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j-128)&& (j - 128)!= 0){
                                        v.set(j,j);
                                        mPut.put("K", j - 128);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j-131)&& (j - 131)!= 0){
                                        v.set(j,j);
                                        mPut.put("M", j - 131);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j-147)&& (j - 147)!= 0){
                                        v.set(j,j);
                                        mPut.put("F", j - 147);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j-97)&& (j - 97)!= 0){
                                        v.set(j,j);
                                        mPut.put("P", j - 97);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j-87)&& (j - 87)!= 0){
                                        v.set(j,j);
                                        mPut.put("S", j - 87);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j -101)&& (j - 101)!= 0){
                                        v.set(j,j);
                                        mPut.put("T", j - 101);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j- 186)&& (j - 186)!= 0){
                                        v.set(j,j);
                                        mPut.put("W", j - 186);
                                        deno.put(j,mPut);
					//System.out.println("mass is " + j);
				}
				if(v.contains(j- 163)&& (j - 163)!= 0){
                                        v.set(j,j);
                                        mPut.put("Y", j - 163);
					//System.out.println("mass is " + j);
                                        deno.put(j,mPut);                        
	
				}
				if(v.contains(j - 99)&& (j - 99)!= 0){
					v.set(j,j);
					//System.out.println("mass is " + j);
                                        mPut.put("V", j - 99);
                                        deno.put(j,mPut);
				}
				
				
		}
		//File file4 = new File(args[1]);
                //Scanner s3 = new Scanner(file4);
                //System.out.println("water mass is " + water  );
		//for( int o : v){
		//	if(o > 0){
				//System.out.println("vector is " + o);
		//	}
		//}
		int greater = -1;
		if(q2a || q2b){
		for(int val : v){
			
			if(val != 0){
				//System.out.println(val);
				HashMap<String,Integer> mPut = new HashMap<String,Integer>();	
				if(water - val == 71 ){

                                                v.set(water,water);
                                                mPut.put("A",water - 71);
                                          	deno.put(water,mPut);

				}
				if(water - val == 156  ){

                                                v.set(water,water);
                                                mPut.put("R",water - 156);
						deno.put(water,mPut);
                                          
				}
				if(water - val == 141){

                                                v.set(water,water);
                                                mPut.put("N",water - 141);
						deno.put(water,mPut);
                                          
				}
				if(water -val == 115){

                                                v.set(water, water);
                                                mPut.put("D",water - 115);
						deno.put(water,mPut);
                                 }
				if(water -val == 103){

                                                v.set(water,water);
                                                mPut.put("C",water - 103);
						deno.put(water,mPut);
                                 }
				if(water - val== 129){

                                                v.set(water,water);
                                                mPut.put("E",water - 129);
						deno.put(water,mPut);
                                  }
				if(water -val == 128){
						//System.out.println(" inside 128");
                                                v.set(water,water);
                                                mPut.put("K",water - 128);
						deno.put(water,mPut);
                                  }
				if(water - val ==57){

                                                v.set(water,water);
                                                mPut.put("G",water - 57);
						deno.put(water,mPut);
                                  }
				if(water -val == 137){

                                                v.set(water,water);
                                                mPut.put("H",water - 137);
						deno.put(water,mPut);
                                 }
				if(water -val== 113){

                                                v.set(water,water);
                                                mPut.put("L",water - 113);
						deno.put(water,mPut);
                                 }
				if(water -val == 131){

                                                v.set(water,water);
                                                mPut.put("M",water - 131);
						deno.put(water,mPut);
                                 }
				if(water -val == 147){

                                                v.set(water,water);
                                                mPut.put("F",water - 147);
						deno.put(water,mPut);
                                 }
				if(water - val ==97 ){

                                                v.set(water,water);
                                                mPut.put("P",water - 97);
						deno.put(water,mPut);
                                 }
				if(water -val == 87){

                                                v.set(water,water);
                                                mPut.put("S",water - 87);
						deno.put(water,mPut);
                                 }
				if(water -val == 101){

                                                v.set(water,water);
                                                mPut.put("T",water - 101);
						deno.put(water,mPut);
                                 }
				if(water -val == 186){

                                                v.set(water,water);
                                                mPut.put("W",water - 186);
						deno.put(water,mPut);
                                 }
				if(water -val== 163){

                                                v.set(water,water);
                                                mPut.put("Y",water - 163);
						deno.put(water,mPut);
                                 }
				if(water - val ==99){

                                                v.set(water,water);
                                                mPut.put("V",water - 99);
						deno.put(water,mPut);
                                 }
		}
		}
		}
		/*if(!(v.contains(water))){
			System.out.println(" vector doesn't contain water ion");
			v.set(water,water);

		}*/
		/*for(int value : v){
			if(value ! = 0){
				if(water == greater){
					
				}
			}
		}*/
		
		ArrayList<StringBuilder> accString = new ArrayList<StringBuilder>();
		
		ArrayList<StringBuilder> y = new ArrayList<StringBuilder>();
		ArrayList<StringBuilder> newStr = new ArrayList<StringBuilder>();
		String replace = " ";
		HashMap< Integer, StringBuilder> ret = new HashMap<Integer,StringBuilder>();
		HashMap<Integer,Integer> pathScore = new HashMap<Integer,Integer>();
		for(Map.Entry<Integer, Integer> entry:all.entrySet()){
		}
	int finalNode = 0;
	if(args[0].equals("q2a") || q2b){	
		for(int val : v){
			if(val > 0){
				if(deno.containsKey(val)){
					HashMap< String, Integer> x = new HashMap<String,Integer>();
					///System.out.print(val + " ");
					//System.out.print(all.get(val));
					x = deno.get(val);
					//System.out.println( x);
					int counting = -1;
					int dd = 0;
					String str =" ";
					String str2 = " ";
					int intenNode = 0;
					int use = 0;
					for(Map.Entry<String, Integer> entry:x.entrySet()){
						dd = all.get(entry.getValue());
						//str = entry.getKey();
						//System.out.println("mass " + entry.getValue() + " intensity " + dd + " counting " + counting + " str " + str ); 
						if(dd > counting){
							counting = dd;
							
							use =entry.getValue();	
							str = entry.getKey();
							//System.out.println("use " + use + " str " + str);
						}	
						//str2 = str;
						//System.out.println("str2 in for is " + str2);	
						
					}
					//str2 = str;
					//System.out.println(" str2 is " + str2);
						if(!(pathScore.containsKey(use))){
							//System.out.println("back to " + str);
							intenNode  =  all.get(val);
							//System.out.println("mass is " + val + " intensity " + intenNode); 	
							pathScore.put(val,intenNode);
						}
						if(pathScore.containsKey(use)){
							//System.out.println("back to " + str);
							intenNode=all.get(val)+pathScore.get(use);	
							finalNode = intenNode;
							//System.out.println(all.get(val) + " " + pathScore.get(use)  + " intensity " + intenNode); 	
							pathScore.put(val,intenNode);

						}
						
						if(!(ret.containsKey(use))){
							StringBuilder sb1 = new StringBuilder(str);
							//StringBuilder sb = new StringBuilder(ret.containsKey(use));
							//System.out.println("val is " + val + " " + "put string " +sb1);
							ret.put(val,sb1);
						}
						 if(ret.containsKey(use)){
							StringBuilder sb1 = new StringBuilder(str);
							StringBuilder sb = new StringBuilder(ret.get(use));
							//System.out.println(" in else, value of newStr is " + newStr);
							sb.append(sb1);
							//System.out.println(" ret contains some string " + newStr);
							//System.out.println("val is " + val + " " + "put string " + sb);
							//System.out.println(" letter is " + 
							ret.put(val,sb);
						}
						
				
				}
			
			}


		}}
		//System.out.println("intensity is " + finalNode);
		if(args[0].equals("q2a")){
		int check = -1;
		int check2 = -1;
		for(Map.Entry<Integer,StringBuilder> entry:ret.entrySet()){
			if(entry.getKey() > check2){
				check2 = entry.getKey();
			}

		}
		int path = 0;
		if(!((ret.get(check2)).toString().isEmpty())){
			System.out.print(ret.get(check2) + " ");
		}
		else {
			System.out.println("NONE" + " "+ 0);
		}
		//if(args[0].equals("q2a")){
		for(Map.Entry<Integer, Integer> entry:pathScore.entrySet()){
			//System.out.println(entry.getKey() + " " + entry.getValue());
			if(entry.getKey() > check){
				check = entry.getKey();
				
			}
		}
		//System.out.println(" mass is " + check); 
		if(!((ret.get(check2)).toString().isEmpty())){
		System.out.println(pathScore.get(check));
		}
		//}
	}
}		
}
