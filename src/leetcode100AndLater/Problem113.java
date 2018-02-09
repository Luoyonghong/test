package leetcode100AndLater;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
	List<List<Integer>> l=new ArrayList<>();
	List<Integer> now=new ArrayList<>();
	int count;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        height(root,sum);
		return l;
	}

	public void height(TreeNode r, int sum) {
		if (r == null)
			return;
		count += r.val;
		now.add(r.val);
		if (r.left == null && r.right == null) {
			if (count == sum) {
				List<Integer> f=new ArrayList<>();
				for (Integer in : now) {
					f.add(in);
				}
				l.add(f);
				//return;
			}
            return;
		}

		height(r.left, sum);

		height(r.right, sum);
		count -= r.val;
		now.remove(now.size()-1);
	}
}
