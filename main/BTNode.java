public class BTNode<T> {

    private T item;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T item){
        this.item = item;
        this.left = null;
        this.right = null;
    }

    public T getItem(){
        return item;
    }

    public void setItem(T key) {
		this.item = key;
	}

	public BTNode<T> getLeft() {
		return left;
	}

	public BTNode<T> getRight() {
		return right;
    }

	public BTNode<T> setLeft(BTNode<T> left) {
		this.left = left;
        return this.left;
	}

	public BTNode<T> setRight(BTNode<T> right) {
		this.right = right;
        return this.right;
	}
    
    
}