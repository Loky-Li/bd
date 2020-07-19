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
        println("---------")
    
        val resNode: HeroNode = binaryTree.preOrderSearch(5)
        
        if(resNode != null){
            printf("找到的节点为：编号=%d  name=%s",resNode.no,resNode.name)
        }else{
            println("没有找到需要的节点")
        }
        
        
    }
    
}

// 定义节点
case class HeroNode(no:Int, name:String){
    var left:HeroNode = null
    var right:HeroNode = null
    
    // 删除节点，规则：
    // 1 如果删除的节点是叶子节点，则删除该节点
    // 2 如果删除的节点是非叶子节点，则删除该子树
    def delNode(no:Int):Unit = {
        // 首先比较当前节点的左子节点是否是要删除的节点（单向二叉树）
        if(this.left != null && this.left.no == no){
            this.left = null
            return
        }
        
        // 比较右节点
        if(this.right != null && this.right.no == no){
            this.right = null
            return
        }
        
        // 向左递归删除
        if(this.left != null){  // 由于前面已经对this的left进行判断。如果此处不为null，那说明没有删
            this.left.delNode(no)
        }
        
        // 向右递归删除
        if(this.right != null){
            this.right.delNode(no)
        }
        
    }
    
    // 前序查找
    def preOrderSearch(no:Int):HeroNode = {
        
        // 当前节点
        if(no == this.no){
            return this
        }
        
        // 向左递归查找
        var resNode:HeroNode = null
        if(this.left != null){
            resNode = this.left.preOrderSearch(no)
        }
        
        if(resNode != null){
            return resNode
        }
        
        // 向右边递归查找
        if(this.right != null){
            resNode = this.right.preOrderSearch(no)
        }
        
        return resNode
        
        
    }
    
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
    
    //
    def delNode(no:Int):Unit={
        if(root != null){
            // 先处理root是不是要删除的
            if(root.no == no){
                root == null
            }else{
                root.delNode(no)
            }
        }
    }
    
    // 前序遍历
    def preOrder():Unit ={
        if(root != null){
            root.preOrder()
        }else{
            println("当前二叉树为空")
        }
    }
    
    // 前序查找
    def preOrderSearch(no:Int):HeroNode = {
        if(root != null){
            root.preOrderSearch(no)
        }else{
            return null
        }
    }
}
