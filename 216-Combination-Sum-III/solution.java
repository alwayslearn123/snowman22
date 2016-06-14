public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
            	List<List<Integer>> res = new ArrayList<> ();
        if (k <= 0 || n <= 0) return res;
        
        dfs(res, new ArrayList<Integer>(), 0, k, n);
        return res;
    }
    
        private void dfs(List<List<Integer>> res, ArrayList<Integer> partial, int sum, int k, int n)
    {
    	if (partial.size() == k)
    	{
    		if (sum == n)
    			res.add(new ArrayList<Integer>(partial));
    		return;
    	}
    	
    	for (int i = partial.isEmpty() ? 1 : partial.get(partial.size() - 1) + 1; i <= 9; i++) {
			if (sum + i <= n)
			{
				partial.add(i);
				dfs(res, partial, sum + i, k, n);
				partial.remove(partial.size() - 1);
			}
		}
    }
}