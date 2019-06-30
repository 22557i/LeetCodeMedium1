package lcwu;

public class Trie {
	private Node root;

	public Trie() {
		root = new Node();
	}

	public void insert(String word) {
		Node current = root;

		for (char c : word.toCharArray()) {
			Node child = current.getChild(c);
			if(child == null) {
				child = current.setChild(c, new Node());
			}

			current = child;
		}

		current.isWord = true;
	}

	public boolean search(String word) {
		Node node = findNode(word);
		return node != null && node.isWord;
	}

	public boolean startsWith(String prefix) {
		return findNode(prefix) != null;
	}

	private Node findNode(String word) {
		Node current = root;

		for (char c : word.toCharArray()) {
			Node child = current.getChild(c);
			if(child == null) return null;
			current = child;
		}

		return current;
	}
	private static class Node {
		private Node[] children = new Node[26];
		boolean isWord;
		Node getChild(char c) {
			return children[toIndex(c)];
		}
		Node setChild(char c, Node child) {
			children[toIndex(c)] = child;
			return child;
		}
		private int toIndex(char c) {
			return c - 'a';
		}
	}
}
