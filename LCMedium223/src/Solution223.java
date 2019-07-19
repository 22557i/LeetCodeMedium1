public class Solution223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int ABCD_area=(C-A)*(D-B);
		int EFGH_area=(G-E)*(H-F);
		int leftBoundary=Math.max(A, E);
		int bottomBoundary=Math.max(B, F);
		int rightBoundary=Math.max(Math.min(C, G),leftBoundary);
		int upBoundary=Math.max(Math.min(D, H),bottomBoundary);
		int overlapArea=(rightBoundary-leftBoundary)*(upBoundary-bottomBoundary);
		return ABCD_area+EFGH_area-overlapArea;
	}
}
