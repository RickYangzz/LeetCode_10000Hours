# -*- coding:utf-8 -*-
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def Serialize(self, root):
        if not root: return "#"
        return str(root.val) + "," + self.Serialize(root.left) + "," + self.Serialize(root.right)
    
    def Deserialize(self, s):
        if s == "#": return None
        
        arr = s.split(',')
        return self.deserialize_function(arr)
    
    def deserialize_function(self, arr: List[str]) -> TreeNode:
        if len(arr) == 0: return None

        val = arr.pop(0)
        if val == "#": return None

        root = TreeNode(int(val))
        root.left = self.deserialize_function(arr)
        root.right = self.deserialize_function(arr)
        return root
