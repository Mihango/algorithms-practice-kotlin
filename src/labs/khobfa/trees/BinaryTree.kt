 package labs.khobfa.trees

fun main() {
    val intTree = Tree()
    println("============ In order traversal ============")
//    intTree.insert(25)
//    intTree.insert(20)
//    intTree.insert(15)
//    intTree.insert(27)
//    intTree.insert(30)
//    intTree.insert(29)
//    intTree.insert(26)
//    intTree.insert(22)
//    intTree.insert(32)
//    intTree.insert(17)

    intTree.insertIterative(25)
    intTree.insertIterative(20)
    intTree.insertIterative(15)
    intTree.insertIterative(27)
    intTree.insertIterative(30)
    intTree.insertIterative(29)
    intTree.insertIterative(26)
    intTree.insertIterative(22)
    intTree.insertIterative(32)
    intTree.insertIterative(17)

    intTree.traverseInOrder()
    println("\n============ Pre order traversal ============")
    intTree.traversePreOrder()
    println("\n============ Get Value ============")
    println("Get 32 >>>> ${intTree.get(32)}")
    println("Get 50 >>>> ${intTree.get(50)}")
    println("============ Get Min Value ============")
    println(intTree.min())
    println("============ Get Max Value ============")
    println(intTree.max())

    intTree.delete(27)
    intTree.traverseInOrder()

}


class TreeNode(var data: Int, var leftChild: TreeNode? = null,
               var rightChild: TreeNode? = null) {
    fun insert(value: Int) {
        // doesnt handle duplicates
        if (data == value) {
            return
        }
        if (value < data) {
            if (leftChild == null) {
                leftChild = TreeNode(value)
            } else {
                leftChild!!.insert(value)
            }
        } else {
            if (rightChild == null) {
                rightChild = TreeNode(value)
            } else {
                rightChild!!.insert(value)
            }
        }
    }

    fun get(value: Int): TreeNode? {
        if (data == value) {
            return this
        }
        return if (value < data) {
            leftChild?.get(value)
        } else {
            rightChild?.get(value)
        }
    }

    fun traverseInOrder() {
        if (leftChild != null) {
            leftChild?.traverseInOrder()
        }
        print("$data, ")
        if (rightChild != null) {
            rightChild?.traverseInOrder()
        }
    }

    fun traversePreOrder() {
        print("$data, ")
        if(leftChild != null) {
            leftChild?.traversePreOrder()
        }
        if(rightChild != null) {
            rightChild?.traversePreOrder()
        }
    }

    fun min(): TreeNode {
        return if (leftChild == null) {
            this
        } else {
            leftChild!!.min()
        }
    }

    fun max(): TreeNode {
        return if (rightChild == null) {
            this
        } else {
            rightChild!!.max()
        }
    }

    override fun toString(): String {
        return "Tree { data : $data }"
    }
}

class Tree {
    private var root: TreeNode? = null
    fun insert(value: Int) {
        if (root == null) {
            root = TreeNode(value)
        } else {
            root!!.insert(value)
        }
    }

    fun traverseInOrder() {
        root?.traverseInOrder()
    }

    fun traversePreOrder() {
        root?.traversePreOrder()
    }

    fun get(value: Int): TreeNode? {
        return root?.get(value)
    }

    fun delete(value: Int) {
        root = delete(root, value)
    }

    private fun delete(subTreeRoot: TreeNode?, value: Int): TreeNode? {
        if (subTreeRoot == null)
            return subTreeRoot

        when {
            value < subTreeRoot.data -> {
                subTreeRoot.leftChild = delete(subTreeRoot.leftChild, value)
            }
            value > subTreeRoot.data -> {
                subTreeRoot.rightChild = delete(subTreeRoot.rightChild, value)
            }
            else -> {
                if (subTreeRoot.leftChild == null) {
                    return subTreeRoot.rightChild
                } else if (subTreeRoot.rightChild == null) {
                    return subTreeRoot.leftChild
                }
                subTreeRoot.data = subTreeRoot.rightChild!!.min().data
                subTreeRoot.rightChild = delete(subTreeRoot.rightChild, subTreeRoot.data)
            }
        }
        return subTreeRoot
    }

    fun min(): TreeNode? {
        return root?.min()
    }

    fun max(): TreeNode? {
        return root?.max()
    }

    fun insertIterative(value: Int) {
        if(root == null) {
            root = TreeNode(value)
        } else {
            var parent: TreeNode? = null
            var current = root

            while (current != null) {
                parent = current
                if(value < parent.data) {
                    current = parent.leftChild
                } else {
                    current = parent.rightChild
                }
            }

            if(value < parent?.data!!) {
                parent.leftChild = TreeNode(value)
            } else {
                parent.rightChild = TreeNode(value)
            }
        }
    }

}