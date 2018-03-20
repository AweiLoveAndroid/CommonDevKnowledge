

public class BinaryTreeDemo {

	public static void main(String[] args){
		
	}

	public boolean specialPath(Node *pRoot,Node *pNode,vector<int> &v){  
		if(pRoot==NULL){  
			return false;  
		}  
		v.push_back(pRoot->m_value);  
		boolean found=false;  
		if(pRoot==pNode){//还是比较指针稳妥，节点值有可能重复  
			for(int i=0;i<v.size();i++){  
				cout<<v[i]<<" ";  
			}
			cout<<endl;  
			return true;  
		}  
		if(!found && pRoot->m_pLeft){  
			found=specialPath(pRoot->m_pLeft,pNode,v);  
		}  
	  
		//一旦左子树中找到节点，就不需要再遍历右子树  
		if(!found && pRoot->m_pRight){
			found=specialPath(pRoot->m_pRight,pNode,v);  
		}  
		if(!found){
			v.pop_back();
		}
		return found;  
	}

	class Node{  
		Node m_pLeft;  
		Node m_pRight;  
		int m_value;  
	}
}