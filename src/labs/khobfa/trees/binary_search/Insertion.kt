package labs.khobfa.trees.binary_search

fun main() {
    val intTree = Tree()
    intTree.insert(25)
    intTree.insert(20)
    intTree.insert(15)
    intTree.insert(27)
    intTree.insert(30)
    intTree.insert(29)
    intTree.insert(26)
    intTree.insert(22)
    intTree.insert(32)

    intTree.traverseInOrder()

}


class TreeNode(var data: Int) {
    var leftChild: TreeNode? = null
    var rightChild: TreeNode? = null

    fun insert(value: Int) {
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

    fun traverseInOrder() {
        if(leftChild != null) {
            leftChild?.traverseInOrder()
        }
        print("$data, ")
        if(rightChild != null) {
            rightChild?.traverseInOrder()
        }
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

}