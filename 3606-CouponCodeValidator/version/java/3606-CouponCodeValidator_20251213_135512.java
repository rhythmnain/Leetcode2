// Last updated: 12/13/2025, 1:55:12 PM
1class Solution {
2    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
3        List<String>res = new ArrayList();
4
5        List<String>e = new ArrayList();
6        List<String>g = new ArrayList();
7        List<String>p = new ArrayList();
8        List<String>r = new ArrayList();
9        
10        for(int i=0;i<isActive.length;i++){
11            if(isActive[i]){
12                if(businessLine[i].equals("electronics") 
13                    || businessLine[i].equals("grocery")
14                  || businessLine[i].equals("pharmacy")
15                  || businessLine[i].equals("restaurant")){
16                    if(code[i].length() == 0)continue;
17                    boolean found = true;
18                    for(int j=0;j<code[i].length();j++){
19                        char ch = code[i].charAt(j);
20                        if (!Character.isLetterOrDigit(ch) && ch != '_') {
21                            found = false;
22                            break;
23                        }
24                    }
25
26                    if(found){
27                        if(businessLine[i].startsWith("e"))e.add(code[i]);
28                        if(businessLine[i].startsWith("g"))g.add(code[i]);
29                        if(businessLine[i].startsWith("p"))p.add(code[i]);
30                        if(businessLine[i].startsWith("r"))r.add(code[i]);
31                    }
32                  }
33            }
34        }
35        Collections.sort(e);
36        Collections.sort(g);
37        Collections.sort(p);
38        Collections.sort(r);
39        res.addAll(e);
40        res.addAll(g);
41        res.addAll(p);
42        res.addAll(r);
43        
44        return res;
45    }
46}