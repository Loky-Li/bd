package com.hong.algor.tree

object t_01_BinaryTree {
    def main(args: Array[String]): Unit = {
        /*
                root
                /  \
               h2   h3
                   / \
                  h5  h4
         */
        // 先使用
        val root = new HeroNode(1, "A")
        val h2 = new HeroNode(2, "B")
        val h3 = new HeroNode(3, "C")
        val h4 = new HeroNode(4, "D")
        val h5 = new HeroNode(5, "E")
        
        root.left = h2
        root.right = h3
        
        h3.left = h5
        h3.right = h4
    
        val binaryTree = new BinaryTree(root)
        
        println("前序遍历")
        binaryTree.preOrder()
        
        
    }
    
}

// 定义节点
case class HeroNode(no:Int, name:String){
    var left:HeroNode = null
    var right:HeroNode = null
    
    // 前序遍历
    def preOrder():Unit = {
        // 先输出当前节点的值
        printf("节点信息 no=%d  name=%s\n",no,name)
        // 向左递归输出左子树
        if(this.left != null){
            this.left.preOrder()
        }
        // 向右递归输出左子树
        if(this.right != null){
            this.right.preOrder()
        }
    }
}

case class BinaryTree(var root:HeroNode){
    // 前序遍历
    def preOrder():Unit ={
        if(root != null){
            root.preOrder()
        }else{
            println("当前二叉树为空")
        }
    }
}
