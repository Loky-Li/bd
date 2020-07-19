package com.hong.algor.tree

object t_03_BinarySortTree {
    def main(args: Array[String]): Unit = {
        
        val arr = Array(3,7,10,12,5,1,9,2)
        
        // 创建一颗二叉排序树
        val binarySortTree = new BinarySortTree
        for(item <- arr){
            binarySortTree.add(new Node(item))
        }
        // 遍历二叉排序树
        binarySortTree.infixOrder()
        
        println("-----------------")
        binarySortTree.delNode(1)
        binarySortTree.infixOrder()
    
    }
    
}

case class Node(var value:Int){
    var left:Node = null
    var right:Node = null
    
    //查找某个节点，根据值
    def search(value:Int):Node = {
        // 先判断当前的节点是否是要删除的节点
        if(value == this.value){
            return this
        }else if(value < this.value){   // 向左边查找
            if(this.left == null){
                return null
            }else{
                return this.left.search(value)
            }
        }else{
            if(this.right == null){
                return null
            }else{      // 递归向右子树查找
                return this.right.search(value)
            }
        }
    }
    
    // 查找某个节点的父节点
    def searchParent(value:Int):Node = {
        // 思路
        // 1、 先判断当前节点的左子节点或者右子节点是否是这个值
        if((this.left != null && this.left.value == value) ||
            (this.right != null && this.right.value == value)){
            return  this
        }else{
           if(this.left != null && value < this.value){  // 说明需要向左边递归
               this.left.searchParent(value)
               
           }else if(this.right != null && value < this.value){  // 说明需要向左边递归
                this.right.searchParent(value)
            }else{
               return  null
           }
        }
        
    }
    
    // 添加的方法
    def add(node:Node):Unit = {
        if(node == null){
            return
        }
        
        //如果要加入的值，小于当前节点的值，放在左子树
        if(node.value < this.value){
            if(this.left == null){  // 说明该节点下没有左子节点
                this.left = node
            }else{
                // 递归进行插入
                this.left.add(node)
            }
        }else{
            if(this.right == null){
                this.right = node
            }else{
                this.right.add(node)
            }
        }
    }
    
    
    // 中序遍历刚好是从小到大
    def infixOrder():Unit = {
        if(this.left != null){
            this.left.infixOrder()
        }
        
        printf("当前节点信息 value=%d\n",this.value)
        
        if(this.right != null){
            this.right.infixOrder()
        }
    }
}

// 定义二叉排序树
case class BinarySortTree(var root:Node = null){
    
    def search(value:Int):Node = {
        if(root != null){
            return root.search(value)
        }else{
            return null
        }
    }
    
    
    
    def searchParent(value:Int):Node = {
        if(root!=null){
            root.searchParent(value)
        }else{
            return null
        }
    }
    
    // 删除某个子树的最小值的节点，并返回最小值
    def delRightTreeMin(node:Node):Int = {
        var target = node
        // 使用while循环找到右子树的最小值
        while(target.left != null){
            target = target.left
        }
        val minValue = target.value
        // 删除最小值对应的节点
        delNode(minValue)
        return minValue
        
    }
    
    // 删除节点
    // 1、 先考虑的是叶子节点
    def delNode(value:Int):Unit = {
        //
        if(root == null){   //如果是空树不删除
            return null
        }
        // 先看有没有要删除的节点
        var targetNode = search(value)
        if(targetNode == null){     // 没有要删除的节点，就直接返回
            return
        }
        
        // 查找targetNode 的父节点
        var parentNode = searchParent(value)
        if(parentNode == null){
            root = null
            return
        }
        
        // 先考虑叶子节点
        if(targetNode.left == null && targetNode.right == null){
            // 判断要删除的节点是parentNode的左子节点，还是右子节点
            if(parentNode.left != null && parentNode.left.value == value){
                parentNode.left == null
            }else{
                parentNode.right = null
            }
        }else if(targetNode.left != null && targetNode.right != null){  // 有两个子节点
            //todo  删除有左右子节点的节点：
            // 1） 找出该节点右子树的最小值
            // 2) 将该最小值的对应的节点删除
            // 3) 将该要删除的节点的值 赋值为 找到的最小值
            //其实删除节点，并不是树没有了这个节点，而是删除这个节点的值
            
            val value = delRightTreeMin(targetNode.right)
            targetNode.value = value
        
        }else{      // 只有一个子节点
            // 判断节点是左子节点还是右子节点
            if(targetNode.left != null){    // 要删除的节点的左子节点不为空。该节点的左节点替换该节点
                // 判断targetNode 是 parentNode 的左还是右
                if(parentNode.left.value == value){
                    parentNode.left = targetNode.left   // 将targetNode的左子节点，上移了一层。作为...
                }else{
                    parentNode.right = targetNode.left
                }
            }else{
                if(parentNode.left.value == value){
                    parentNode.left = targetNode.right
                }else{
                    parentNode.right = targetNode.right
                }
            }
        
        }
    }
    
    def add(node:Node):Unit = {
        if(root == null){
            root = node
        }else{
            root.add(node)
        }
    }
    
    def infixOrder():Unit = {
        if(root == null){
            println("二叉树为空")
        }else{
            root.infixOrder()
        }
    }
}
