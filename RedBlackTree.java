import java.util.LinkedList;
import java.util.Stack;

//import RedBlackTree.Node;

public class RedBlackTree<T extends Comparable<T>> implements RedBlackTreeInterface<AE_Car>{

	@SuppressWarnings("hiding")
	protected static class Node<AE_Car> {
        public AE_Car data;
        public int blackHeight;
        // The context array stores the context of the node in the tree:
        // - context[0] is the parent reference of the node,
        // - context[1] is the left child reference of the node,
        // - context[2] is the right child reference of the node.
        // The @SupressWarning("unchecked") annotation is used to supress an unchecked
        // cast warning. Java only allows us to instantiate arrays without generic
        // type parameters, so we use this cast here to avoid future casts of the
        // node type's data field.
        @SuppressWarnings("unchecked")
        public Node<AE_Car>[] context = (Node<AE_Car>[])new Node[3];
        public Node(AE_Car data) { this.data = data; blackHeight = 0; }
        public boolean isRightChild() {
            return context[0] != null && context[0].context[2] == this;
        }
	}
	
	protected Node<AE_Car> root;
	protected int size = 0;
	
	@Override
	public AE_Car getRightChild(AE_Car parentNodeData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (findNodeWithData(parentNodeData).context[2] != null) {
			return findNodeWithData(parentNodeData).context[2].data;
		}
		throw new IllegalArgumentException("No right child");
	}

	@Override
	public AE_Car getLeftChild(AE_Car parentNodeData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (findNodeWithData(parentNodeData).context[1] != null) {
			return findNodeWithData(parentNodeData).context[1].data;
		}
		throw new IllegalArgumentException("No left child");
	}

	@Override
	public boolean insert(AE_Car data) throws NullPointerException, IllegalArgumentException {
		// TODO Auto-generated method stub
		
		if(data == null) throw new NullPointerException(
                "This RedBlackTree cannot store null references.");

        Node<AE_Car> newNode = new Node<>(data);
        if (this.root == null) {
            // add first node to an empty tree
            root = newNode; size++; 
            enforceRBTreePropertiesAfterInsert(root);
            return true;
        } else {
            // insert into subtree
            Node<AE_Car> current = this.root;
            while (true) {
                int compare = newNode.data.compareTo(current.data);
                if (compare == 0) {
                    throw new IllegalArgumentException("This RedBlackTree already contains value " + data.toString());
                } else if (compare < 0) {
                    // insert in left subtree
                    if (current.context[1] == null) {
                        // empty space to insert into
                        current.context[1] = newNode;
                        newNode.context[0] = current;
                        this.size++;
                        enforceRBTreePropertiesAfterInsert(newNode);
                        return true;
                    } else {
                        // no empty space, keep moving down the tree
                        current = current.context[1];
                    }
                } else {
                    // insert in right subtree
                    if (current.context[2] == null) {
                        // empty space to insert into
                        current.context[2] = newNode;
                        newNode.context[0] = current;
                        this.size++;
                        enforceRBTreePropertiesAfterInsert(newNode);
                        return true;
                    } else {
                        // no empty space, keep moving down the tree
                        current = current.context[2]; 
                    }
                }
            }
        }
	}

	@Override
	public boolean remove(AE_Car data) throws NullPointerException, IllegalArgumentException {
		// TODO Auto-generated method stub
		if (data == null) {
            throw new NullPointerException("This RedBlackTree cannot store null references.");
        } else {
            Node<AE_Car> nodeWithData = this.findNodeWithData(data);
            // throw exception if node with data does not exist
            if (nodeWithData == null) {
                throw new IllegalArgumentException("The following value is not in the tree and cannot be deleted: " + data.toString());
            }  
            boolean hasRightChild = (nodeWithData.context[2] != null);
            boolean hasLeftChild = (nodeWithData.context[1] != null);
            if (hasRightChild && hasLeftChild) {
                // has 2 children
                Node<AE_Car> successorNode = this.findMinOfRightSubtree(nodeWithData);
                // replace value of node with value of successor node
                nodeWithData.data = successorNode.data;
                // remove successor node
                if (successorNode.context[2] == null) {
                    // successor has no children, replace with null
                    this.replaceNode(successorNode, null);
                } else {
                    // successor has a right child, replace successor with its child
                    this.replaceNode(successorNode, successorNode.context[2]);
                }
            } else if (hasRightChild) {
                // only right child, replace with right child
                this.replaceNode(nodeWithData, nodeWithData.context[2]);
            } else if (hasLeftChild) {
                // only left child, replace with left child
                this.replaceNode(nodeWithData, nodeWithData.context[1]);
            } else {
                // no children, replace node with a null node
                this.replaceNode(nodeWithData, null);
            }
            this.size--;
            return true;
        }
	}
	
	protected void replaceNode(Node<AE_Car> nodeToReplace, Node<AE_Car> replacementNode) {
        if (nodeToReplace == null) {
            throw new NullPointerException("Cannot replace null node.");
        }
        if (nodeToReplace.context[0] == null) {
            // we are replacing the root
            if (replacementNode != null)
                replacementNode.context[0] = null;
            this.root = replacementNode;
        } else {
            // set the parent of the replacement node
            if (replacementNode != null)
                replacementNode.context[0] = nodeToReplace.context[0];
            // do we have to attach a new left or right child to our parent?
            if (nodeToReplace.isRightChild()) {
                nodeToReplace.context[0].context[2] = replacementNode;
            } else {
                nodeToReplace.context[0].context[1] = replacementNode;
            }
        }
    }
	
	protected Node<AE_Car> findMinOfRightSubtree(Node<AE_Car> node) {
        if (node.context[1] == null && node.context[2] == null) {
            throw new IllegalArgumentException("Node must have two children");
        }
        // take a steop to the right
        Node<AE_Car> current = node.context[2];
        while (true) {
            // then go left as often as possible to find the successor
            if (current.context[1] == null) {
                // we found the successor
                return current;
            } else {
                current = current.context[1];
            }
        }
    }

	@Override
	public boolean contains(AE_Car data) {
		// TODO Auto-generated method stub
		if (data == null) {
            throw new NullPointerException("This RedBlackTree cannot store null references.");
        } else {
            Node<AE_Car> nodeWithData = this.findNodeWithData(data);
            // return false if the node is null, true otherwise
            return (nodeWithData != null);
        }
	}
	
	protected Node<AE_Car> findNodeWithData(AE_Car data) {
        Node<AE_Car> current = this.root;
        while (current != null) {
            int compare = data.compareTo(current.data);
            if (compare == 0) {
                // we found our value
                return current;
            } else if (compare < 0) {
                // keep looking in the left subtree
                current = current.context[1];
            } else {
                // keep looking in the right subtree
                current = current.context[2];
            }
        }
        // we're at a null node and did not find data, so it's not in the tree
        return null; 
    }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public AE_Car lowest() {
		// TODO Auto-generated method stub
		if (root.context[1] == null) {
			return root.data;
		}
		Node<AE_Car> rep = root;
		while (rep.context[1] != null) {
			rep = rep.context[1];
		}
		return rep.data;
	}

	@Override
	public AE_Car highest() {
		// TODO Auto-generated method stub
		if (root.context[2] == null) {
			return root.data;
		}
		Node<AE_Car> rep = root;
		while (rep.context[2] != null) {
			rep = rep.context[2];
		}
		return rep.data;
	}
	
	protected void enforceRBTreePropertiesAfterInsert(Node<AE_Car> node) {
    	//node is the root
    	if (node.context[0] == null) {
    		root.blackHeight = 1;
    		return;
    	}
    	// only 2 other nodes in tree
    	else if (node.context[0].context[0] == null) {
    		if (node.context[0].context[1] != null && node.context[0].context[1].blackHeight ==1) {
    			node.blackHeight = 1;
    		}
    		else if (node.context[0].context[2] != null && node.context[0].context[2].blackHeight ==1) {
    			node.blackHeight = 1;
    		}
    		else {
    			return;
    		}
    	}
    	// more than 2 nodes in tree
    	else {
    		Node<AE_Car> parent = node.context[0];
    		Node<AE_Car> gp = node.context[0].context[0];
    		Node<AE_Car> uncle;
    		if (gp.context[1] == parent) {
    			uncle = gp.context[2];
    		}
    		else {
    			uncle = gp.context[1];
    		}
    		
    		//parent = black
    		if (parent.blackHeight == 1) {
    			return;
    		}
    		else if (uncle != null && uncle.blackHeight == 0) {
    			//parent and uncle = red
    			parent.blackHeight = 1;
    			uncle.blackHeight = 1;
    			gp.blackHeight = 0;
    			enforceRBTreePropertiesAfterInsert(gp);
    		}
    		else {
    			// parent red and uncle is black
    			if (parent.context[1] == node && gp.context[1] == parent) {
    				rightRotate(gp);
    				parent.blackHeight = 1;
    				gp.blackHeight = 0;
    			}
    			else if (parent.context[2] == node && gp.context[2] == parent) {
    				leftRotate(gp);
    				parent.blackHeight = 1;
    				gp.blackHeight = 0;
    			}
    			else if (parent.context[2] == node && gp.context[1] == parent) {
    				leftRotate(parent);
    				enforceRBTreePropertiesAfterInsert(parent);
    				return;
    			}
    			else if (parent.context[1] == node && gp.context[2] == parent) {
    				rightRotate(parent);
    				enforceRBTreePropertiesAfterInsert(parent);
    				return;
    			}
    		}
    	}
    	
    	root.blackHeight = 1;
    }
	
	 private void rotate(Node<AE_Car> child, Node<AE_Car> parent) throws IllegalArgumentException {
	        // TODO: Implement this method.
	    	
	    	if (parent.context[1] == child) {
	    		rightRotate(parent);
	    	}
	    	else if (parent.context[2] == child) {
	    		leftRotate(parent);
	    	}
	    	else {
	    		throw new IllegalArgumentException("Invalid Child and/or Parent");
	    	}
	    }
	    
	    private void rightRotate(Node<AE_Car> parent) {
	    	Node<AE_Car> temp = parent.context[1];
	    	parent.context[1] = temp.context[2];
	    	if (temp.context[2] != null) {
	    		temp.context[2].context[0] = parent;
	    	}
	    	
	    	temp.context[0] = parent.context[0];
	    	if (parent.context[0] == null) {
	    		root = temp;
	    	}
	    	else if (parent == parent.context[0].context[2]) {
	    		parent.context[0].context[2] = temp;
	    	}
	    	else {
	    		parent.context[0].context[1] = temp;
	    	}
	    	
	    	temp.context[2] = parent;
	    	parent.context[0] = temp;
	    	
	    }
	    
	    private void leftRotate(Node<AE_Car> parent) {
	    	Node<AE_Car> temp = parent.context[2];
	    	parent.context[2] = temp.context[1];
	    	
	    	if (temp.context[1] != null) {
	    		temp.context[1].context[0] = parent;
	    	}
	    	
	    	temp.context[0] = parent.context[0];
	    	
	    	if (parent.context[0] == null) {
	    		root = temp;
	    	}
	    	else if (parent == parent.context[0].context[1]) {
	    		parent.context[0].context[1] = temp;
	    	}
	    	else {
	    		parent.context[0].context[2] = temp;
	    	}
	    	
	    	temp.context[1] = parent;
	    	parent.context[0] = temp;
	    	
	    }

	@Override
	public AE_Car getroot() {
		// TODO Auto-generated method stub
		return root.data;
	}

	@Override
	public AE_Car find(double key) {
		// TODO Auto-generated method stub
		Node<AE_Car> find = this.root;
		while (find != null) {
			double compare = find.data.getPrice() - key;
			if (compare == 0) {
				return find.data;
			}
			if (compare > 0) {
				find = find.context[1];
			}
			if (compare < 0) {
				find = find.context[2];		
			}
			
		}
		return null;
	}
}

