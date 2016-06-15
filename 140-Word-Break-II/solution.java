public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
               HashMap<String, List<String>> map = new HashMap<>();
        dfs(map, s, wordDict, 0, new ArrayList<String> ());
        return map.get(s);
    }
    
       private void dfs(HashMap<String, List<String>> map, String s, Set<String> wordDict, int begin, ArrayList<String> partial)
    {
    	if (map.containsKey(s))
    		return;
//    	if (begin == s.length())
//    	{
//    		map.put(s, new ArrayList<String> (partial));
//    		return;
//    	}
    	ArrayList<String> ans = new ArrayList<String>();
    	if (wordDict.contains(s))
    		ans.add(s);
    	
    	for (int i = 1; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			if (!wordDict.contains(prefix)) continue;
			dfs(map, s.substring(i), wordDict, 0, new ArrayList<String> ());
			List<String> rest = map.get(s.substring(i));
			for (String suffix : rest) {
				ans.add(prefix + " " + suffix);
			}
		}
    	map.put(s, ans);
    	
    }
}