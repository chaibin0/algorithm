package leetcode.problems.q1993;

import java.util.*;

class LockingTree {
    private final Map<Integer, Tree> numsToTrees;

    public LockingTree(int[] parent) {

        Tree[] trees = new Tree[parent.length];
        for (int i = 0; i < parent.length; i++) {
            trees[i] = new Tree(null, new ArrayList<>(), 0);
        }

        numsToTrees = new HashMap<>();
        numsToTrees.put(0, trees[0]);
        for (int i = 1; i < parent.length; i++) {
            Tree parentTree = trees[parent[i]];
            Tree nextTree = trees[i];
            nextTree.ancestor = parentTree;
            parentTree.descendants.add(nextTree);
            numsToTrees.put(i, nextTree);
        }
    }

    public boolean lock(int num, int user) {

        Tree tree = numsToTrees.get(num);
        if (tree.lockUser != 0) {
            return false;
        }

        tree.lockUser = user;

        Tree ancestorTree = tree.ancestor;
        while (ancestorTree != null) {
            ancestorTree.parentLockSize++;
            ancestorTree = ancestorTree.ancestor;
        }

        return true;
    }

    public boolean unlock(int num, int user) {

        Tree tree = numsToTrees.get(num);

        if (tree.lockUser != user || tree.lockUser == 0) {
            return false;
        }

        tree.lockUser = 0;

        Tree ancestorTree = tree.ancestor;
        while (ancestorTree != null) {
            ancestorTree.parentLockSize--;
            ancestorTree = ancestorTree.ancestor;
        }

        return true;
    }

    private void allUnlock(List<Tree> descendants) {

        for (Tree descendant : descendants) {

            if (descendant.parentLockSize != 0) {
                allUnlock(descendant.descendants);
            }

            if (descendant.lockUser == 0) {
                continue;
            }

            descendant.lockUser = 0;

            Tree ancestorTree = descendant.ancestor;
            while (ancestorTree != null) {
                ancestorTree.parentLockSize--;
                ancestorTree = ancestorTree.ancestor;
            }
        }
    }

    public boolean upgrade(int num, int user) {

        Tree tree = numsToTrees.get(num);

        if (tree.lockUser != 0 || tree.parentLockSize == 0) {
            return false;
        }

        Tree ancestorTree = tree.ancestor;
        while (ancestorTree != null) {
            if (ancestorTree.lockUser != 0) {
                return false;
            }
            ancestorTree = ancestorTree.ancestor;
        }

        allUnlock(tree.descendants);
        lock(num, user);
        return true;
    }
}

class Pair {

    int num;
    int parent;


    public Pair(int num, int parent) {
        this.num = num;
        this.parent = parent;
    }
}

class Tree {
    Tree ancestor;
    List<Tree> descendants;
    int lockUser = 0;
    int parentLockSize;

    public Tree(Tree ancestor, List<Tree> descendants, int parentLockSize) {
        this.ancestor = ancestor;
        this.descendants = descendants;
        this.parentLockSize = parentLockSize;
        this.lockUser = 0;
    }
}
